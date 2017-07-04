package com.sc.ymfeed.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.mybatis.dto.UserAccount;

public abstract class BaseController {

	protected UserAccount userAccountByCookie;

	protected void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		userAccountByCookie = (UserAccount) session.getAttribute(CookieConstant.USER_COOKIE);
	}

}
