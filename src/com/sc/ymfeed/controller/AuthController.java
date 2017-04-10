package com.sc.ymfeed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sign")
public class AuthController {

	@RequestMapping(value = "/in", method = { RequestMethod.GET })
	public String signIn(HttpServletRequest request, Model model) {
		return "u.sign.in.page";
	}

	@RequestMapping(value = "/out", method = { RequestMethod.GET })
	public String signOut(HttpServletRequest request, Model model) {
		return "u.sign.out.page";
	}

}
