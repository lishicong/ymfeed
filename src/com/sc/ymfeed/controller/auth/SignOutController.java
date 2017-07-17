package com.sc.ymfeed.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.common.cookie.CookieInfoParser;
import com.sc.ymfeed.common.cookie.CookieUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.UserAccount;

/**
 * 注销
 * 
 * @author lishicong
 *
 */
@Controller
public class SignOutController extends SignController {

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_OUT, method = { RequestMethod.GET })
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		// 从session中获取用户帐号
		String cookieValue = (String) request.getSession().getAttribute(CookieConstant.USER_COOKIE);

		UserAccount userAccount = CookieInfoParser.cookieDecrypt(cookieValue);

		authService.forgetMe(userAccount.getId());
		// 清除session和用于自动登录的cookie
		request.getSession().removeAttribute(CookieConstant.USER_COOKIE);
		CookieUtil.removeCookie(request, response, CookieConstant.REMEMBER_ME);

		return new ModelAndView("redirect:/index");
	}

}
