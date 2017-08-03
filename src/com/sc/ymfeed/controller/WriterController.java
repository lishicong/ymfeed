package com.sc.ymfeed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WriterController {

	@RequestMapping(value = MAPPING.P.DIRECT_WRITER, method = { RequestMethod.GET })
	public String home(HttpServletRequest request, Model model) {
		return "view.writer.editor" + MAPPING.TEMPLATE.TEMPLATE_B;
	}

}
