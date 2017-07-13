package com.sc.ymfeed.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.ymfeed.common.cookie.CookieInfo;
import com.sc.ymfeed.common.cookie.EncryptionUtil;
import com.sc.ymfeed.common.email.MailActive;
import com.sc.ymfeed.common.email.MailFactory;
import com.sc.ymfeed.common.email.MailPassword;
import com.sc.ymfeed.common.email.MailType;
import com.sc.ymfeed.common.email.Mailer;
import com.sc.ymfeed.common.util.DateUtil;
import com.sc.ymfeed.common.util.UUIDUtil;
import com.sc.ymfeed.common.util.ValidUtil;
import com.sc.ymfeed.mybatis.dao.UserAccountMapper;
import com.sc.ymfeed.mybatis.dao.UserInfoMapper;
import com.sc.ymfeed.mybatis.dao.UserPersistentMapper;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserAccountExample;
import com.sc.ymfeed.mybatis.dto.UserPersistent;
import com.sc.ymfeed.mybatis.dto.UserPersistentExample;
import com.sc.ymfeed.service.AuthService;

@Transactional("transactionManager")
@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;
	@Resource
	private UserAccountMapper userAccountMapper;
	@Resource
	private UserInfoMapper userInfoMapper;
	@Resource
	private UserPersistentMapper userPersistentMapper;

	@Override
	public UserAccount getUserAccountByEmail(String email) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andEmailEqualTo(email);
		List<UserAccount> list = userAccountMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserPersistent getUserPersistentByEmailAndSeries(String email, String series) {
		UserPersistentExample userPersistentExample = new UserPersistentExample();
		userPersistentExample.createCriteria().andEmailEqualTo(email).andSeriesEqualTo(series);
		List<UserPersistent> list = userPersistentMapper.selectByExample(userPersistentExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserAccount getUserAccountByNickname(String nickname) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andNicknameEqualTo(nickname);
		List<UserAccount> list = userAccountMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
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

		UserAccount userAccount = new UserAccount();
		userAccount.setActiveCode(activeCode);
		userAccount.setActiveCodeTime(date);

		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andEmailEqualTo(email);

		int result = userAccountMapper.updateByExampleSelective(userAccount, example);
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

		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andEmailEqualTo(userAccount.getEmail());

		int result = userAccountMapper.updateByExampleSelective(userAccount, example);
		if (result == 1) {
			// 更新帐户重置密码激活码后发送验证码邮件
			try {
				taskExecutor.execute(new Runnable() {
					public void run() {
						Mailer mailer = MailFactory.createMailer(MailType.MAIL_PASSWORD);
						mailer.setMailTo(userAccount.getEmail());
						mailer.setNickname(userAccount.getNickname());
						((MailPassword) mailer).setValideCode(validateCode);
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
	public int activeUserAccount(String activeCode) {

		int result = 0;

		UserAccount userAccount = getUserAccountByUserActiveCode(activeCode);

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
		UserPersistentExample example = new UserPersistentExample();
		example.createCriteria().andUserAccountIdEqualTo(userAccountId);
		return userPersistentMapper.deleteByExample(example);
	}

	/**
	 * 根据激活码获取帐户信息
	 * 
	 * @param email
	 * @param activeCode
	 * @return
	 */
	private UserAccount getUserAccountByUserActiveCode(String activeCode) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andActiveCodeEqualTo(activeCode).andActiveEqualTo(false);
		List<UserAccount> list = userAccountMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据用户帐号ID获取用户cookie信息
	 * 
	 * @param userAccount
	 * @return
	 */
	private UserPersistent getUserPersistentByUserAccountId(UserAccount userAccount) {
		UserPersistentExample userPersistentExample = new UserPersistentExample();
		userPersistentExample.createCriteria().andUserAccountIdEqualTo(userAccount.getId());
		List<UserPersistent> list = userPersistentMapper.selectByExample(userPersistentExample);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
