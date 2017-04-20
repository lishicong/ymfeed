package com.sc.ymfeed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主页
 * 
 * @author lishicong
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value = MAPPING.NP.DIRECT_HOME, method = { RequestMethod.GET })
	public String home(HttpServletRequest request, Model model) {
		return "view.home" + MAPPING.TEMPLATE.TEMPLATE_A;
	}

}
