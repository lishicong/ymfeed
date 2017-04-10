package com.sc.ymfeed.controller.demo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.ymfeed.mybatis.dto.Info;
import com.sc.ymfeed.service.SampleService;

/**
 * springmvc controller demo.
 * 
 * @author lishicong
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

	@Resource
	private SampleService testService;

	@RequestMapping("/getSampleData")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		List<Info> archivedate = this.testService.getSampleData();
		model.addAttribute("archivedate", archivedate.get(0));
		return "user.home2";
	}

}
