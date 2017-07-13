package com.sc.ymfeed.controller.auth;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sc.ymfeed.common.util.DateUtil;
import com.sc.ymfeed.common.util.GsonUtil;
import com.sc.ymfeed.common.util.ValidUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;

/**
 * 找回密码
 * 
 * @author lishicong
 *
 */
@Controller
public class SignLostController extends SignController {

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_LOST, method = { RequestMethod.GET })
	public String signlost(HttpServletRequest request, Model model) {

		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);

		if (map != null && map.size() > 0) {
			model.addAttribute(Messages.CODE, map.get(Messages.CODE));
			model.addAttribute(Messages.CODE_MSG, map.get(Messages.CODE_MSG));
			model.addAttribute(Messages.PARAM_EMAIL, map.get(Messages.PARAM_EMAIL));
			model.addAttribute(Messages.PARAM_VALIDATE, map.get(Messages.PARAM_VALIDATE));
			model.addAttribute(Messages.PARAM_PASSWORD, map.get(Messages.PARAM_PASSWORD));
		}
		return "view.sign.lost" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_LOST, method = { RequestMethod.POST })
	public ModelAndView datasignlost(@RequestParam("email") String email, @RequestParam("validate") String validate,
			@RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {

		redirectAttributes.addFlashAttribute(Messages.PARAM_EMAIL, email);
		redirectAttributes.addFlashAttribute(Messages.PARAM_VALIDATE, validate);
		redirectAttributes.addFlashAttribute(Messages.PARAM_PASSWORD, password);

		if (!ValidUtil.isEmail(email)) {
			// 邮箱格式不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNUP_EMAIL);
		} else if (!ValidUtil.isPasswordLength(password)) {
			// 密码长度不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_PASSWORD);
		} else if (!ValidUtil.isPassword(password)) {
			// 密码格式不符
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_PASSWORD2);
		} else if (!ValidUtil.isValidateLength(validate)) {
			// 验证码格式错误
			redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
			redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_VALIDATE);
		} else {
			UserAccount userAccount = authService.getUserAccountByEmail(email);
			if (userAccount == null) {
				// 邮箱错误
				redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
				redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_EMAIL);
			} else {
				String code = userAccount.getResetPasswordCode();
				if (code == null || !code.equals(validate)) {
					// 未下发验证码，或验证码不一致
					redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
					redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_VALIDATE);
				} else {
					Date codeTime = userAccount.getResetPasswordCodeTime();
					if (codeTime == null || DateUtil.isResetPasswordExpired(codeTime)) {
						// 验证码已过期
						redirectAttributes.addFlashAttribute(Messages.CODE, Messages.CODE_FAILURE);
						redirectAttributes.addFlashAttribute(Messages.CODE_MSG, Messages.SIGNLOST_CODE_OVERDUE);
					} else {
						return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_RESET);
					}
				}
			}
		}

		return new ModelAndView("redirect:" + MAPPING.NP.DIRECT_SIGN_LOST);
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_VALIDATE, method = {
			RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String datasignvalidate(@RequestParam("email") String email, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes) {

		if (email == null || email.trim().length() == 0) {
			// 邮箱格式不符
			return GsonUtil.toJSONSimple(Messages.CODE_FAILURE, Messages.SIGNLOST_EMAIL_EMPTY);
		} else if (!ValidUtil.isEmail(email)) {
			// 邮箱格式不符
			return GsonUtil.toJSONSimple(Messages.CODE_FAILURE, Messages.SIGNUP_EMAIL);
		}

		UserAccount userAccount = authService.getUserAccountByEmail(email);
		if (userAccount == null) {
			// 邮箱错误
			return GsonUtil.toJSONSimple(Messages.CODE_FAILURE, Messages.SIGNLOST_EMAIL);
		}

		authService.sendLostEmail(userAccount);
		// 已发送验证码到邮箱
		return GsonUtil.toJSONSimple(Messages.CODE_SUCCESS, Messages.SIGNLOST_VALIDATE_SEND);
	}

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_RESET, method = { RequestMethod.GET })
	public String signreset(HttpServletRequest request, Model model) {

		return "widget.sign.reset" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

}
