package com.sc.ymfeed.controller.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sc.ymfeed.common.util.ContextUtil;
import com.sc.ymfeed.common.util.DateUtil;
import com.sc.ymfeed.common.util.GsonUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.service.AuthService;

@Controller
public class SignActiveController {

	@Resource
	private AuthService authService;

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_ACTIVE, method = { RequestMethod.GET })
	public String signactive(HttpServletRequest request, Model model) {

		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

		if (nickname != null && email != null) {
			model.addAttribute(Messages.PARAM_NICKNAME, nickname);
			model.addAttribute(Messages.PARAM_EMAIL, email);
		}

		return "view.sign.active" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_REACTIVE, method = {
			RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String sginreactive(@RequestParam("nickname") String nickname,
			@RequestParam("email") String email, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {

		UserAccount userAccount = authService.getUserAccountByEmail(email);
		if (userAccount.getActiveCodeTime() != null && !DateUtil.isAllowSendMail(userAccount.getActiveCodeTime())) {
			// 发送激活邮件时间间隔过短
			return GsonUtil.toJSONSimple(Messages.CODE_FAILURE, Messages.ERROR_OTHER);
		}

		int result = authService.sendActiveEmail(nickname, email,
				ContextUtil.getRootPath(request) + MAPPING.NP.DIRECT_SIGN_ACTIVED);
		if (result == 1) {
			// 发送邮件成功
			return GsonUtil.toJSONSimple(Messages.CODE_SUCCESS, Messages.CODE_MSG);
		}
		return GsonUtil.toJSONSimple(Messages.CODE_FAILURE, Messages.ERROR_OTHER);
	}

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_ACTIVED + "/{rest}", method = { RequestMethod.GET })
	public String signactived(HttpServletRequest request, Model model, @PathVariable(value = "rest") String rest) {
		int result = authService.activeUserAccount(rest);
		if (result == 1) {
			model.addAttribute(Messages.CODE, Messages.CODE_SUCCESS);
		} else {
			model.addAttribute(Messages.CODE, Messages.CODE_FAILURE);
		}
		return "view.sign.actived" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

}
