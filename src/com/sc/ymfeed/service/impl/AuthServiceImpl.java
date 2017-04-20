package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.common.cookie.CookieInfo;
import com.sc.ymfeed.common.cookie.CookieUtil;
import com.sc.ymfeed.mybatis.dao.UserAccountMapper;
import com.sc.ymfeed.mybatis.dao.UserInfoMapper;
import com.sc.ymfeed.mybatis.dao.UserPersistentMapper;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserAccountExample;
import com.sc.ymfeed.mybatis.dto.UserInfo;
import com.sc.ymfeed.mybatis.dto.UserInfoExample;
import com.sc.ymfeed.mybatis.dto.UserPersistent;
import com.sc.ymfeed.mybatis.dto.UserPersistentExample;
import com.sc.ymfeed.service.AuthService;

@Transactional("transactionManager")
@Service("authService")
public class AuthServiceImpl implements AuthService {

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
	public UserInfo getUserInfoByNickname(String nickname) {
		UserInfoExample example = new UserInfoExample();
		example.createCriteria().andNicknameEqualTo(nickname);
		List<UserInfo> list = userInfoMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int addUserAccount(String nickname, String email, String password) {

		UserAccount userAccount = new UserAccount();
		userAccount.setEmail(email);
		userAccount.setPassword(password);

		UserInfo userInfo = new UserInfo();
		userInfo.setNickname(nickname);

		userAccountMapper.insertSelective(userAccount);
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andEmailEqualTo(email);
		List<UserAccount> list = userAccountMapper.selectByExample(example);
		userInfo.setUserAccountId(list.get(0).getId());

		return userInfoMapper.insert(userInfo);

	}

	@Override
	public int modifyUserPersistent(UserPersistent userPersistent) {
		return userPersistentMapper.updateByPrimaryKeySelective(userPersistent);
	}

	@Override
	public int removeUserPersistentById(Long id) {
		return userPersistentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int remeberMe(UserAccount userAccount, HttpServletResponse response) {

		CookieInfo cookieInfo = new CookieInfo(userAccount);

		UserPersistent userPersistent = getUserPersistentByUserAccountId(userAccount);

		int result = 0;

		if (userPersistent == null) {
			userPersistent = new UserPersistent();
			userPersistent.setId(0L); // @TODO modify id auto
			userPersistent.setUserAccountId(userAccount.getId());
			userPersistent.setEmail(userAccount.getEmail());
			userPersistent.setSeries(cookieInfo.getSeries());
			userPersistent.setToken(cookieInfo.getToken());
			userPersistent.setValidTime(cookieInfo.getValidTime());
			result = userPersistentMapper.insertSelective(userPersistent);
		} else {
			userPersistent.setSeries(cookieInfo.getSeries());
			userPersistent.setToken(cookieInfo.getToken());
			userPersistent.setValidTime(cookieInfo.getValidTime());
			result = userPersistentMapper.updateByPrimaryKeySelective(userPersistent);
		}

		// 保存cookie
		CookieUtil.addCookie(response, CookieConstant.REMEMBER_ME, cookieInfo.getCookieValue(), null);

		return result;
	}

	@Override
	public int forgetMe(HttpServletRequest request, HttpServletResponse response) {
		// 从session中获取用户帐号
		UserAccount userAccount = (UserAccount) request.getSession().getAttribute(CookieConstant.USER_COOKIE);
		int result = removeUserPersistentByUserAccountId(userAccount);

		// 清除session和用于自动登录的cookie
		request.getSession().removeAttribute(CookieConstant.USER_COOKIE);
		CookieUtil.removeCookie(request, response, CookieConstant.REMEMBER_ME);
		return result;
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

	/**
	 * 根据用户帐号ID删除cookie信息
	 * 
	 * @param userAccount
	 * @return
	 */
	private int removeUserPersistentByUserAccountId(UserAccount userAccount) {
		UserPersistentExample example = new UserPersistentExample();
		example.createCriteria().andUserAccountIdEqualTo(userAccount.getId());
		return userPersistentMapper.deleteByExample(example);
	}

}
