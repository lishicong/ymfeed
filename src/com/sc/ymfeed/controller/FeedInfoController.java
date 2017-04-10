package com.sc.ymfeed.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.ymfeed.service.UinfoService;

@Controller
@RequestMapping("/fi")
public class FeedInfoController {

	@Resource
	private UinfoService uinfoService;

	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public String detail(@PathVariable(value = "id") String id, HttpServletRequest request, Model model) {

		System.out.println("the request id value:" + id);
		// String param = request.getParameter("param");
		// System.out.println("param1:" + param);
		//
		// List<Archivedate> archivedate = this.testService.getSampleData();
		// model.addAttribute("archivedate", archivedate.get(0));

		return "u.info.detail";
	}

}
