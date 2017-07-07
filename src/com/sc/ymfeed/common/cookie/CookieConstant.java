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

	/**
	 * 用户Cookie
	 */
	public final static String USER_COOKIE = "ymfeed-cookie";

	/**
	 * AES key
	 */
	public static final String AES_KEY_COOKIE = "1234567890123456";

	/**
	 * Cookie安全验证码
	 */
	public static final String COOKIE_SECRET_CODE = "0123456789abcdef";

	/**
	 * 分割符
	 */
	public static final String COOKIE_DIVIDER = "|$|";

	/**
	 * 分割符正则
	 */
	public static final String COOKIE_REGULAR = "\\|\\$\\|";

}
