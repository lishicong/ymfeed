package com.sc.ymfeed.controller.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc controller demo.
 * 
 * @author lishicong
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("/getSampleData")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		return "user.home2";
	}

}
