package com.sc.ymfeed.common.cookie;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

	private CookieUtil() {
	}

	/**
	 * 添加一个新Cookie
	 * 
	 * @param response
	 * @param cookie
	 */
	public static void addCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			response.addCookie(cookie);
		}
	}

	/**
	 * 添加一个新Cookie
	 * 
	 * @param response
	 * @param cookieName
	 *            cookie名称
	 * @param cookieValue
	 *            cookie值
	 * @param domain
	 *            cookie所属的子域
	 * @param httpOnly
	 *            是否将cookie设置成HttpOnly
	 * @param maxAge
	 *            cookie的最大生存期
	 * @param path
	 *            cookie路径
	 * @param secure
	 *            是否只允许HTTPS访问
	 */
	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain,
			boolean httpOnly, int maxAge, String path, boolean secure) {

		if (!StringUtils.isEmpty(cookieName) && !StringUtils.isEmpty(cookieValue)) {

			Cookie newCookie = new Cookie(cookieName, cookieValue);
			if (domain != null) {
				newCookie.setDomain(domain);
			}
			newCookie.setHttpOnly(httpOnly);
			newCookie.setMaxAge(maxAge);
			newCookie.setPath(path);
			newCookie.setSecure(secure);

			addCookie(response, newCookie);
		}
	}

	/**
	 * 添加一个新Cookie
	 * 
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param domain
	 */
	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain) {
		addCookie(response, cookieName, cookieValue, domain, true, CookieConstant.COOKIE_MAX_AGE, "/", false);
	}

	/**
	 * 根据Cookie名获取对应的Cookie
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null && !StringUtils.isEmpty(cookieName)) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName))
					return (Cookie) c;
			}
		}
		return null;
	}

	/**
	 * 根据Cookie名获取对应的Cookie值
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie cookie = getCookie(request, cookieName);
		if (cookie != null) {
			return cookie.getValue();
		}
		return null;
	}

	/**
	 * 删除Cookie
	 * 
	 * @param response
	 * @param cookie
	 */
	public static void removeCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			cookie.setPath("/");
			cookie.setMaxAge(0);
			cookie.setValue(null);

			response.addCookie(cookie);
		}
	}

	/**
	 * 根据cookie名删除指定的cookie
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie cookie = getCookie(request, cookieName);
		if (cookie != null && cookie.getName().equals(cookieName)) {
			removeCookie(response, cookie);
		}
	}

	/**
	 * 根据cookie名修改指定的cookie
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 *            cookie名
	 * @param cookieValue
	 *            修改之后的cookie值
	 * @param domain
	 *            修改之后的domain值
	 */
	public static void modifyCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
			String cookieValue, String domain) {
		Cookie cookie = getCookie(request, cookieName);
		if (cookie != null && !StringUtils.isEmpty(cookieName)) {
			if (cookie.getName().equals(cookieName)) {
				addCookie(response, cookieName, cookieValue, domain);
			}
		}
	}

}
