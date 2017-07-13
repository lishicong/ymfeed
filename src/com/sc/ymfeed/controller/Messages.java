package com.sc.ymfeed.controller;

public class Messages {

	public static final int CODE_SUCCESS = 1001;
	public static final int CODE_FAILURE = 1002;

	public static final String CODE = "code";
	public static final String CODE_MSG = "message";
	public static final String ERROR_OTHER = "未知错误";

	public static final String SIGNUP_NICKNAME = "昵称长度为2~16位";
	public static final String SIGNUP_NICKNAME_USED = "该昵称已被人使用";
	public static final String SIGNUP_EMAIL = "邮箱格式错误";
	public static final String SIGNUP_EMAIL_USED = "该邮箱已被人使用";
	public static final String SIGNUP_PASSWORD = "密码长度为6~16位";
	public static final String SIGNUP_PASSWORD2 = "密码需包含字母和数字";

	public static final String SIGNLOST_EMAIL = "输入的邮箱不存在";
	public static final String SIGNLOST_EMAIL_EMPTY = "请输入注册的邮箱";
	public static final String SIGNLOST_VALIDATE = "输入的验证码错误";
	public static final String SIGNLOST_VALIDATE_SEND = "验证码已发送至邮箱";
	public static final String SIGNLOST_PASSWORD = "密码长度为6~16位";
	public static final String SIGNLOST_PASSWORD2 = "密码需包含字母和数字";
	public static final String SIGNLOST_CODE_OVERDUE = "验证码已过期，请重新发送";

	public static final String SIGNIN_EMAIL = "输入的邮箱错误";
	public static final String SIGNIN_PASSWORD = "输入的密码错误";

	public static final String PARAM_USER_ACCOUNT = "userAccount";
	public static final String PARAM_NICKNAME = "nickname";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_REMEMBER = "remember";
	public static final String PARAM_VALIDATE = "validate";

}
