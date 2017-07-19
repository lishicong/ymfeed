package com.sc.ymfeed.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.common.cookie.CookieInfoParser;
import com.sc.ymfeed.mybatis.dto.UserAccount;

public abstract class BaseController {

	/**
	 * cookie中获取的用户信息（id && email）
	 */
	protected UserAccount userAccountByCookie;

	protected void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String cookie = (String) session.getAttribute(CookieConstant.USER_COOKIE);
		userAccountByCookie = CookieInfoParser.cookieDecrypt(cookie);
	}

}
