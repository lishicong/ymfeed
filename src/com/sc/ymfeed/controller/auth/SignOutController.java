package com.sc.ymfeed.controller.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.controller.MAPPING;

/**
 * 注销
 * 
 * @author lishicong
 *
 */
@Controller
public class SignOutController extends SignController {

	@RequestMapping(value = MAPPING.NP.DATA_SIGN_OUT, method = { RequestMethod.POST })
	public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response) {
		authService.forgetMe(request, response);
		return "success";
	}

}
