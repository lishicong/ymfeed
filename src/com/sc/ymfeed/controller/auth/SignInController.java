package com.sc.ymfeed.controller.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.service.AuthService;

@Controller
public class SignInController {

	@Resource
	private AuthService authService;

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_IN, method = { RequestMethod.GET })
	public String signin(HttpServletRequest request, Model model) {
		String param = request.getParameter("code");
		if (param != null) {
			int code = Integer.parseInt(param);
			String message = request.getParameter("message");
			model.addAttribute("code", code);
			model.addAttribute("message", message);
//			model.addAllAttributes(request.getParameterMap());
			System.out.println("sss");
		}
		return "view.sign.in" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_IN, method = { RequestMethod.POST })
	public ModelAndView datasignin(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam(name = "remember", required = false) boolean remember, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {

		UserAccount userAccount = authService.getUserAccountByEmail(email);
		if (userAccount != null) {
			if (userAccount.getPassword().equals(password)) {
				if (remember) {
					authService.remeberMe(userAccount, response);
				}

				HttpSession session = request.getSession();
				String callback = (String) session.getAttribute("callback");
				session.removeAttribute("callback"); // 获取之后移除

				// 基本路径
				StringBuffer basePath = new StringBuffer();
				basePath.append(request.getScheme()).append("://");
				basePath.append(request.getServerName()).append(":");
				basePath.append(request.getServerPort()).append(request.getContextPath());

				ModelAndView mAndView = null;
				if (callback != null && callback.trim().length() > 0) {
					String[] urls = callback.split(basePath.toString());
					if (urls.length == 2 && urls[1] != null && urls[1].trim().length() > 0) {
						mAndView = new ModelAndView("redirect:" + urls[1]);
					} else {
						mAndView = new ModelAndView("redirect:/index");
					}
				} else {
					mAndView = new ModelAndView("redirect:/index");
				}

				session.setAttribute(CookieConstant.USER_COOKIE, userAccount); // 登录成功之后加入session中
				redirectAttributes.addFlashAttribute(CookieConstant.USER_COOKIE, userAccount);

				return mAndView;
			} else {
				redirectAttributes.addAttribute(Messages.CODE, Messages.CODE_FAILURE);
				redirectAttributes.addAttribute(Messages.MESSAGE, Messages.SIGNIN_PASSWORD);
			}
		} else {
			redirectAttributes.addAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addAttribute(Messages.MESSAGE, Messages.SIGNIN_EMAIL);
		}
		return new ModelAndView("redirect:/signin");
	}

}
