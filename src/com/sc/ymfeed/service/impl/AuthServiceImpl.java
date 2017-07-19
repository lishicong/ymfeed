package com.sc.ymfeed.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.ymfeed.common.cookie.CookieInfo;
import com.sc.ymfeed.common.cookie.EncryptionUtil;
import com.sc.ymfeed.common.email.MailActive;
import com.sc.ymfeed.common.email.MailFactory;
import com.sc.ymfeed.common.email.MailType;
import com.sc.ymfeed.common.email.MailValidateCode;
import com.sc.ymfeed.common.email.Mailer;
import com.sc.ymfeed.common.util.DateUtil;
import com.sc.ymfeed.common.util.UUIDUtil;
import com.sc.ymfeed.common.util.ValidUtil;
import com.sc.ymfeed.mybatis.dao.UserAccountMapper;
import com.sc.ymfeed.mybatis.dao.UserPersistentMapper;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserPersistent;
import com.sc.ymfeed.service.AuthService;

@Transactional("transactionManager")
@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	@Resource
	private UserAccountMapper userAccountMapper;
	@Resource
	private UserPersistentMapper userPersistentMapper;

	@Override
	public UserAccount getUserAccountByEmail(String email) {
		UserAccount userAccount = userAccountMapper.selectByEmail(email);
		return userAccount;
	}

	@Override
	public UserPersistent getUserPersistentByEmailAndSeries(String email, String series) {
		UserPersistent userPersistent = userPersistentMapper.selectByEmailAndSeries(email, series);
		return userPersistent;
	}

	@Override
	public UserAccount getUserAccountByNickname(String nickname) {
		UserAccount userAccount = userAccountMapper.selectByNickname(nickname);
		return userAccount;
	}

	@Override
	public UserAccount addUserAccount(UserAccount userAccount) {

		userAccount.setId(UUIDUtil.getUUID());
		int result = userAccountMapper.insertSelective(userAccount);
		if (result == 1) {
			userAccount = getUserAccountByEmail(userAccount.getEmail());
		}
		return userAccount;
	}

	@Override
	public int modifyUserPersistent(UserPersistent userPersistent) {
		return userPersistentMapper.updateByPrimaryKeySelective(userPersistent);
	}

	@Override
	public int removeUserPersistentById(String id) {
		return userPersistentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int sendActiveEmail(String nickname, String email, String activeUrl) {

		// 生成激活码 (格式 = email+":"+time)
		Date date = new Date();
		String sourceCode = email + ":" + date.getTime();
		String activeCode = EncryptionUtil.base64Encode(sourceCode);

		UserAccount userAccount = userAccountMapper.selectByEmail(email);
		userAccount.setActiveCode(activeCode);
		userAccount.setActiveCodeTime(date);

		int result = userAccountMapper.updateByPrimaryKeySelective(userAccount);
		if (result == 1) {
			// 更新帐户激活后发送激活邮件
			try {
				taskExecutor.execute(new Runnable() {
					public void run() {
						Mailer mailer = MailFactory.createMailer(MailType.MAIL_ACTIVE);
						mailer.setMailTo(email);
						mailer.setNickname(nickname);
						((MailActive) mailer).setActiveUrl(activeUrl + "/" + activeCode);
						try {
							mailer.send();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int sendLostEmail(UserAccount userAccount) {

		String validateCode = ValidUtil.generateLostCode();
		userAccount.setResetPasswordCode(validateCode);
		userAccount.setResetPasswordCodeTime(new Date());

		int result = userAccountMapper.updateByPrimaryKeySelective(userAccount);
		if (result == 1) {
			// 更新帐户重置密码激活码后发送验证码邮件
			try {
				taskExecutor.execute(new Runnable() {
					public void run() {
						Mailer mailer = MailFactory.createMailer(MailType.MAIL_PASSWORD);
						mailer.setMailTo(userAccount.getEmail());
						mailer.setNickname(userAccount.getNickname());
						((MailValidateCode) mailer).setValidateCode(validateCode);
						try {
							mailer.send();
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int activeUserAccount(UserAccount userAccount, String activeCode) {

		int result = 0;

		if (userAccount == null) {
			return -1; // 激活码不存在或已失效
		}
		try {
			String sourceCode = EncryptionUtil.base64Decode(activeCode);
			String[] source = sourceCode.split(":");
			if (source.length == 2) {
				String email = source[0];
				String date = source[1];

				if (DateUtil.isActiveExpired(date)) {
					// 激活时间已过期
					return -3;
				} else if (userAccount.getEmail().equals(email)) {
					// 未过期 -> 激活
					userAccount.setActive(true);
					userAccount.setActiveTime(new Date());
					result = userAccountMapper.updateByPrimaryKeySelective(userAccount);
				}
			} else {
				return -2; // 激活码错误
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -2; // 激活码错误
		}

		return result;
	}

	@Override
	public UserAccount getUserAccountByUserActiveCode(String activeCode) {
		UserAccount userAccount = userAccountMapper.selectByActiveCodeAndActive(activeCode, false);
		return userAccount;
	}

	@Override
	public int remeberMe(UserAccount userAccount, CookieInfo cookieInfo) {

		UserPersistent userPersistent = getUserPersistentByUserAccountId(userAccount);

		int result = 0;

		if (userPersistent == null) {
			userPersistent = new UserPersistent();
			userPersistent.setId(UUIDUtil.getUUID());
			userPersistent.setUserAccountId(userAccount.getId());
			userPersistent.setEmail(userAccount.getEmail());
			userPersistent.setSeries(cookieInfo.getSeries());
			userPersistent.setToken(cookieInfo.getToken());
			userPersistent.setValidTime(cookieInfo.getValidTime());
			userPersistent.setCreateTime(new Date());
			result = userPersistentMapper.insertSelective(userPersistent);
		} else {
			userPersistent.setSeries(cookieInfo.getSeries());
			userPersistent.setToken(cookieInfo.getToken());
			userPersistent.setValidTime(cookieInfo.getValidTime());
			userPersistent.setUpdateTime(new Date());
			result = userPersistentMapper.updateByPrimaryKeySelective(userPersistent);
		}

		return result;
	}

	@Override
	public int forgetMe(String userAccountId) {
		return userPersistentMapper.deleteByUserAccountId(userAccountId);
	}

	/**
	 * 根据用户帐号ID获取用户cookie信息
	 * 
	 * @param userAccount
	 * @return
	 */
	private UserPersistent getUserPersistentByUserAccountId(UserAccount userAccount) {
		UserPersistent userPersistent = userPersistentMapper.selectByUserAccountId(userAccount.getId());
		return userPersistent;
	}

}
