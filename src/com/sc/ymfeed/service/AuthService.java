package com.sc.ymfeed.service;

import com.sc.ymfeed.common.cookie.CookieInfo;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserPersistent;

/**
 * 登录、注册、权限、cookie等所有和账号权限安全相关操作
 * 
 * @author lishicong
 *
 */
public interface AuthService {

	/**
	 * 根据邮箱获取用户帐号信息
	 * 
	 * @param email
	 * @return
	 */
	public UserAccount getUserAccountByEmail(String email);

	/**
	 * 根据邮箱和series获取自动登录信息
	 * 
	 * @param email
	 * @param series
	 * @return
	 */
	public UserPersistent getUserPersistentByEmailAndSeries(String email, String series);

	/**
	 * 根据昵称获取用户信息
	 * 
	 * @param nickname
	 * @return
	 */
	public UserAccount getUserAccountByNickname(String nickname);

	/**
	 * 添加用户帐号信息
	 * 
	 * @param userAccount
	 * @return
	 */
	public UserAccount addUserAccount(UserAccount userAccount);

	/**
	 * 根据ID修改自动登录信息
	 * 
	 * @param userPersistent
	 * @return
	 */
	public int modifyUserPersistent(UserPersistent userPersistent);

	/**
	 * 根据ID删除自动登录信息
	 * 
	 * @param id
	 * @return
	 */
	public int removeUserPersistentById(String id);

	/**
	 * 发送激活邮件
	 * 
	 * @param nickname
	 * @param email
	 * @param activeUrl
	 * @return
	 */
	public int sendActiveEmail(String nickname, String email, String activeUrl);

	/**
	 * 发送激活邮件
	 * 
	 * @param userAccount
	 * @return
	 */
	public int sendLostEmail(UserAccount userAccount);

	/**
	 * 激活帐号
	 * 
	 * @param activeCode
	 * @return
	 */
	public int activeUserAccount(String activeCode);

	/**
	 * 记住我
	 * 
	 * @param userAccount
	 * @param cookieInfo
	 * @return
	 */
	public int remeberMe(UserAccount userAccount, CookieInfo cookieInfo);

	/**
	 * 忘记我
	 * 
	 * @param userAccountId
	 * @return
	 */
	public int forgetMe(String userAccountId);

}
