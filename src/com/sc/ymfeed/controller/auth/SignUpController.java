package com.sc.ymfeed.controller.auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.util.GsonUtil;
import com.sc.ymfeed.common.util.ValidUtil;
import com.sc.ymfeed.controller.BaseModel;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserInfo;
import com.sc.ymfeed.service.AuthService;

@Controller
public class SignUpController {

	@Resource
	private AuthService authService;

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_UP, method = { RequestMethod.GET })
	public String signup(HttpServletRequest request, Model model) {
		return "view.sign.up" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_UP, method = {
			RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String signUp(HttpServletRequest request, Model model,
			@RequestParam("nickname") String nickname, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		BaseModel form = new BaseModel();

		if (!ValidUtil.isNicknameLength(nickname)) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_NICKNAME;
			return GsonUtil.toJSON(form);
		}
		if (!ValidUtil.isEmail(email)) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_EMAIL;
			return GsonUtil.toJSON(form);
		}
		if (!ValidUtil.isPasswordLength(password)) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_PASSWORD;
			return GsonUtil.toJSON(form);
		}
		if (!ValidUtil.isPassword(password)) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_PASSWORD2;
			return GsonUtil.toJSON(form);
		}

		UserInfo userInfo = authService.getUserInfoByNickname(nickname);
		if (userInfo != null) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_NICKNAME_USED;
			return GsonUtil.toJSON(form);
		}

		UserAccount userAccount = authService.getUserAccountByEmail(email);
		if (userAccount != null) {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.SIGNUP_EMAIL_USED;
			return GsonUtil.toJSON(form);
		}

		int result = authService.addUserAccount(nickname, email, password);

		if (result == 1) {
			form.code = Messages.CODE_SUCCESS;
			form.message = Messages.SUCCESS;
		} else {
			form.code = Messages.CODE_FAILURE;
			form.message = Messages.ERROR_OTHER;
		}

		return GsonUtil.toJSON(form);
	}
}
