package com.sc.ymfeed.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUtil {

	private static final String EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	private static final String MOBILE = "((^(13|14|15|17|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
	/**
	 * 中级（包含字母和数字）
	 */
	private static final String PASSWORD = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$";
	/**
	 * 简单（只包含数字或字母）
	 */
	private static final String PASSWORD_LOW = "^(?:\\d+|[a-zA-Z]+|[!@#$%^&*]+)$";
	/**
	 * 复杂（同时包含数字，字母，特殊符号）
	 */
	private static final String PASSWORD_HIGN = "^^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*_-]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!@#$%^&*_-]+$)(?![\\d!@#$%^&*_-]+$)[a-zA-Z\\d!@#$%^&*_-]+$";

	private ValidUtil() {
	}

	public static boolean isMatcher(String expression, String str) {
		Pattern p = Pattern.compile(expression);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isEmail(String email) {

		return isMatcher(EMAIL, email);
	}

	public static final boolean isMobile(String mobile) {

		return isMatcher(MOBILE, mobile);
	}

	public static final boolean isPassword(String password) {

		return isMatcher(PASSWORD, password);
	}

	public static final boolean isPasswordLow(String password) {

		return isMatcher(PASSWORD_LOW, password);
	}

	public static final boolean isPasswordHign(String password) {

		return isMatcher(PASSWORD_HIGN, password);
	}

	public static final boolean isPasswordLength(String password) {

		return (password != null && password.length() >= 6 && password.length() <= 16);
	}

	public static final boolean isNicknameLength(String nickname) {
		return (nickname != null && nickname.length() >= 2 && nickname.length() <= 16);
	}

}
