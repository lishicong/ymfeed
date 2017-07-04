package com.sc.ymfeed.controller.auth;

import java.util.Map;

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
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sc.ymfeed.common.cookie.CookieConstant;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;

/**
 * 登录
 * 
 * @author lishicong
 *
 */
@Controller
public class SignInController extends SignController {

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_IN, method = { RequestMethod.GET })
	public String signin(HttpServletRequest request, Model model) {

		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

		if (map != null && map.size() > 0) {
			model.addAttribute(Messages.CODE, map.get(Messages.CODE));
			model.addAttribute(Messages.CODE_MSG, map.get(Messages.CODE_MSG));
			model.addAttribute(Messages.PARAM_EMAIL, map.get(Messages.PARAM_EMAIL));
			model.addAttribute(Messages.PARAM_PASSWORD, map.get(Messages.PARAM_PASSWORD));
			model.addAttribute(Messages.PARAM_REMEMBER, map.get(Messages.PARAM_REMEMBER));
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

				if (userAccount.getActive()) {
					// 帐号已激活
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
					// 登录成功，帐号未激活 -> 去激活
					redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_SUCCESS);
					redirectAttributes.addFlashAttribute(Messages.PARAM_NICKNAME, userAccount.getNickname());
					redirectAttributes.addFlashAttribute(Messages.PARAM_EMAIL, email);
					return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_ACTIVE);
				}
			} else {
				// 登录的密码错误
				redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
				redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNIN_PASSWORD);
			}
		} else {
			// 登录的邮箱不存在
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNIN_EMAIL);
		}

		redirectAttributes.addFlashAttribute(Messages.PARAM_EMAIL, email);
		redirectAttributes.addFlashAttribute(Messages.PARAM_PASSWORD, password);
		redirectAttributes.addFlashAttribute(Messages.PARAM_REMEMBER, remember);

		return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_IN);
	}

}
