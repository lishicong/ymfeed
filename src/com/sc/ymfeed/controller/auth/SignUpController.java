package com.sc.ymfeed.controller.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sc.ymfeed.common.util.ValidUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;

/**
 * 注册
 * 
 * @author lishicong
 *
 */
@Controller
public class SignUpController extends SignController {

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_UP, method = { RequestMethod.GET })
	public String signup(HttpServletRequest request, Model model) {

		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

		if (map != null && map.size() > 0) {
			model.addAttribute(Messages.CODE, map.get(Messages.CODE));
			model.addAttribute(Messages.CODE_MSG, map.get(Messages.CODE_MSG));
			model.addAttribute(Messages.PARAM_NICKNAME, map.get(Messages.PARAM_NICKNAME));
			model.addAttribute(Messages.PARAM_EMAIL, map.get(Messages.PARAM_EMAIL));
			model.addAttribute(Messages.PARAM_PASSWORD, map.get(Messages.PARAM_PASSWORD));
		}
		return "view.sign.up" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_UP, method = { RequestMethod.POST })
	public ModelAndView datasignup(@RequestParam("nickname") String nickname, @RequestParam("email") String email,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute(Messages.PARAM_NICKNAME, nickname);
		redirectAttributes.addFlashAttribute(Messages.PARAM_EMAIL, email);
		redirectAttributes.addFlashAttribute(Messages.PARAM_PASSWORD, password);

		if (!ValidUtil.isNicknameLength(nickname)) {
			// 昵称长度不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_NICKNAME);
		} else if (!ValidUtil.isEmail(email)) {
			// 邮箱格式不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_EMAIL);
		} else if (!ValidUtil.isPasswordLength(password)) {
			// 密码长度不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_PASSWORD);
		} else if (!ValidUtil.isPassword(password)) {
			// 密码格式不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_PASSWORD2);
		} else {
			// 表单验证结束，验证数据
			UserAccount userAccount = authService.getUserAccountByNickname(nickname);
			if (userAccount != null) {
				// 昵称已被使用
				redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
				redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_NICKNAME_USED);
			} else {
				userAccount = authService.getUserAccountByEmail(email);
				if (userAccount != null) {
					// 邮箱已注册
					redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
					redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_EMAIL_USED);
				} else {
					// 邮箱未被注册，添加一个用户
					userAccount = new UserAccount();
					userAccount.setEmail(email);
					userAccount.setPassword(password);
					userAccount.setNickname(nickname);
					userAccount = authService.addUserAccount(userAccount);

					if (userAccount != null) {
						// 添加用户成功 -> 去激活
						redirectAttributes.addAttribute(Messages.PARAM_NICKNAME, nickname);
						redirectAttributes.addAttribute(Messages.PARAM_EMAIL, email);
						return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_ACTIVE);
					} else {
						// 添加用户失败
						redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
						redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.ERROR_OTHER);
					}
				}
			}
		}

		return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_UP);
	}
}
