package com.sc.ymfeed.common.interceptor;

import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.common.cookie.CookieInfo;
import com.sc.ymfeed.common.cookie.CookieInfoParser;
import com.sc.ymfeed.common.cookie.CookieUtil;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserPersistent;
import com.sc.ymfeed.service.AuthService;

/**
 * 拦截器
 * 
 * @author lishicong
 *
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

	private static Logger logger = Logger.getLogger(AuthorizedInterceptor.class);

	@Resource
	private AuthService authService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		HttpSession session = request.getSession();
		String cookieValue = (String) session.getAttribute(CookieConstant.USER_COOKIE);

		if (cookieValue != null) {
			// session中存在，已登录
			return true;
		}

		// 从cookie中取值
		Cookie remember = CookieUtil.getCookie(request, CookieConstant.REMEMBER_ME);
		if (remember != null) {
			CookieInfoParser parser = new CookieInfoParser();
			parser.parse(remember); // 解析cookie数据

			if (parser.isParseSuccess()) { // cookie合法

				String emailByCookie = parser.getCookieInfo().getEmail();
				String seriesByCookie = parser.getCookieInfo().getSeries();

				// 到数据库中查询自动登录记录
				UserPersistent userPersistent = authService.getUserPersistentByEmailAndSeries(emailByCookie,
						seriesByCookie);

				if (userPersistent != null) {

					// 获取有效时间
					Date savedValidtime = userPersistent.getValidTime();
					Date currentTime = new Date();

					// 如果还在cookie有效期之内，继续判断是否可以自动登录
					if (currentTime.before(savedValidtime)) {
						UserAccount userAccount = authService.getUserAccountByEmail(emailByCookie);
						if (userAccount != null) {

							CookieInfo cookieInfo = new CookieInfo();
							cookieInfo.createAuthToken(userAccount, userPersistent);

							String savedToken = userPersistent.getToken(); // 数据库中保存的密文
							String newToken = cookieInfo.getToken(); // 为了校验而生成的密文

							// 校验token的值，如果不一样则表示用户部分信息已被修改，需要重新登录
							if (savedToken.equals(newToken)) {

								String newUUID = UUID.randomUUID().toString();
								String newCookieValue = CookieInfo.createCookieValue(userAccount.getEmail(), newUUID);

								// 更新cookie值 (为了提高安全性，每次登录之后都更新自动登录的cookie值)
								CookieUtil.modifyCookie(request, response, CookieConstant.REMEMBER_ME, newCookieValue,
										null);

								// 更新数据库
								userPersistent.setSeries(newUUID);
								authService.modifyUserPersistent(userPersistent);

								// 将用户加到session中，不退出浏览器时就只需判断session即可
								cookieValue = CookieInfoParser.cookieEncrypt(userAccount);
								session.setAttribute(CookieConstant.USER_COOKIE, cookieValue);

								return true; // 校验成功，此次拦截操作完成
							} else {
								// 用户部分信息被修改，删除cookie并清空数据库中的记录
								CookieUtil.removeCookie(response, remember);
								authService.removeUserPersistentById(userPersistent.getId());
							}
						}
					} else {
						// 超过保存的有效期，删除cookie并清空数据库中的记录
						CookieUtil.removeCookie(response, remember);
						authService.removeUserPersistentById(userPersistent.getId());
					}
				}
			}
		}

		if (!isNeedValid(request)) {
			// 不需要登录校验
			return true;
		}

		// 将来源地址存放在session中，登录成功之后跳回原地址
		String callback = request.getRequestURL().toString();
		session.setAttribute("callback", callback);
		response.sendRedirect(request.getContextPath() + "/signin?callback=" + URLEncoder.encode(callback, "UTF-8"));
		return false;
	}

	/**
	 * 检查是否需要验证登录
	 * 
	 * @param request
	 * @return
	 */
	private boolean isNeedValid(HttpServletRequest request) {

		StringBuffer basePath = new StringBuffer();
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName()).append(":");
		basePath.append(request.getServerPort());

		String uri = basePath.toString() + request.getRequestURI();
		String prefix = basePath.toString() + request.getContextPath() + "/p/";

		if (uri.startsWith(prefix)) {
			return true;
		}

		return false;
	}

}
