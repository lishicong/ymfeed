package com.sc.ymfeed.common.cookie;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;

import com.sc.ymfeed.common.util.AESUtil;
import com.sc.ymfeed.common.util.MD5Util;
import com.sc.ymfeed.mybatis.dto.UserAccount;

public class CookieInfoParser {

	private CookieInfo cookieInfo;
	private boolean isParseSuccess;

	public CookieInfo getCookieInfo() {
		return cookieInfo;
	}

	public boolean isParseSuccess() {
		return isParseSuccess;
	}

	public void parse(Cookie remember) throws UnsupportedEncodingException {

		String cookieValue = EncryptionUtil.base64Decode(remember.getValue());

		String[] cookieValues = cookieValue.split(":");
		if (cookieValues.length == 2) {
			cookieInfo = new CookieInfo();
			cookieInfo.setEmail(cookieValues[0]);
			cookieInfo.setSeries(cookieValues[1]);
			isParseSuccess = true;
		}
	}

	/**
	 * Cookie加密
	 * 
	 * @param email
	 * @return
	 */
	public static String cookieEncrypt(UserAccount userAccount) {
		String userAccountId = userAccount.getId();
		String email = userAccount.getEmail();
		String source = userAccountId + CookieConstant.COOKIE_DIVIDER + email + CookieConstant.COOKIE_DIVIDER
				+ MD5Util.GetMD5Code(CookieConstant.COOKIE_SECRET_CODE);
		String cookie = source;
		try {
			cookie = AESUtil.encrypt(source, CookieConstant.AES_KEY_COOKIE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cookie;
	}

	/**
	 * Cookie解密
	 * 
	 * @param cookie
	 * @return
	 */
	public static UserAccount cookieDecrypt(String cookie) {
		UserAccount userAccount = new UserAccount();
		try {
			String source = AESUtil.decrypt(cookie, CookieConstant.AES_KEY_COOKIE);
			String[] s = source.split(CookieConstant.COOKIE_REGULAR);
			if (s != null && s.length == 3) {
				userAccount.setId(s[0]);
				userAccount.setEmail(s[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAccount;
	}

	/**
	 * 检查Cookie是否合法
	 * 
	 * @param cookie
	 * @return
	 */
	public static boolean isRightCookie(String cookie) {
		if (cookie != null && cookie.length() > 0) {
			String[] source = cookie.split(CookieConstant.COOKIE_REGULAR);
			if (source != null && source.length == 3) {
				String secret = source[2];
				if (secret.equals(MD5Util.GetMD5Code(CookieConstant.COOKIE_SECRET_CODE))) {
					return true;
				}
			}
		}
		return false;
	}

}
