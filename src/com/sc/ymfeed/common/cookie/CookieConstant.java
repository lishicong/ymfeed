package com.sc.ymfeed.common.cookie;

public class CookieConstant {

	/**
	 * cookie的有效期
	 */
	public final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 7; // 7天

	/**
	 * cookie加密时的额外的salt
	 */
	public final static String SALT = "www.ymfeed.com";

	/**
	 * 自动登录的Cookie名
	 */
	public final static String REMEMBER_ME = "ymfeed-remember-me";

	public final static String USER_COOKIE = "ymfeed-cookie";

}
