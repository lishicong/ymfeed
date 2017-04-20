package com.sc.ymfeed.common.cookie;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;

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

}
