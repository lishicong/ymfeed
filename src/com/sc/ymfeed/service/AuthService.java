package com.sc.ymfeed.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserInfo;
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
	public UserInfo getUserInfoByNickname(String nickname);

	/**
	 * 添加用户帐号信息
	 * 
	 * @param userAccount
	 * @return
	 */
	public int addUserAccount(String nickname, String email, String password);

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
	public int removeUserPersistentById(Long id);

	/**
	 * 记住我
	 * 
	 * @param userAccount
	 * @param response
	 * @return
	 */
	public int remeberMe(UserAccount userAccount, HttpServletResponse response);

	/**
	 * 忘记我
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public int forgetMe(HttpServletRequest request, HttpServletResponse response);

}
