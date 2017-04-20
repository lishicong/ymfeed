package com.sc.ymfeed.controller.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.ymfeed.controller.MAPPING;

@Controller
public class SignActiveController {

	@RequestMapping(value = MAPPING.NP.DIRECT_SIGN_ACTIVE, method = { RequestMethod.GET })
	public String signin(HttpServletRequest request, Model model) {
		return "view.sign.active" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

}
