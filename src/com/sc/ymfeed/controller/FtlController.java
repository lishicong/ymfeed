package com.sc.ymfeed.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.ymfeed.mybatis.dto.Archivedate;
import com.sc.ymfeed.service.SampleService;

@Controller
@RequestMapping("/page")
public class FtlController {

	@Resource
	private SampleService testService;

	@RequestMapping(value = "/welcome", method = { RequestMethod.GET })
	public ModelAndView getWelcome(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("name", "My First Spring Mvc");
		return mv;
	}

	@RequestMapping(value = "/rest/{rest}", method = RequestMethod.GET)
	public @ResponseBody List<Archivedate> getRest(@PathVariable(value = "rest") String rest) {
		System.out.println("the rest value:" + rest);
		List<Archivedate> archivedate = this.testService.getSampleData();
		return archivedate;
	}

	@RequestMapping(value = "/rest/{rest}/welcome/{rest2}", method = RequestMethod.GET)
	public @ResponseBody List<Archivedate> getRest2(@PathVariable(value = "rest") String rest,
			@PathVariable(value = "rest2") String rest2) {
		System.out.println("the rest value:" + rest + ", rest2 value:" + rest2);
		List<Archivedate> archivedate = this.testService.getSampleData();
		return archivedate;
	}

	/**
	 * 正则表达式
	 * 
	 * 比如如下的URL：/sometext.123，则输出： Textual part: sometext, numeric part: 123.
	 * 
	 * @param textualPart
	 * @param numericPart
	 * @return
	 */
	@RequestMapping(value = "/{textualPart:[a-z-]+}.{numericPart:[\\d]+}")
	public @ResponseBody List<Archivedate> getRestRegular(@PathVariable String textualPart,
			@PathVariable String numericPart) {

		System.out.println("Textual part: " + textualPart + ", numeric part: " + numericPart);
		List<Archivedate> archivedate = this.testService.getSampleData();
		return archivedate;
	}

	@RequestMapping(value = "/welcomebyparam", method = RequestMethod.GET)
	public @ResponseBody List<Archivedate> getWelcomeByParam(@RequestParam("param") String param) {
		System.out.println("the request param value:" + param);
		List<Archivedate> archivedate = this.testService.getSampleData();
		return archivedate;

	}

	@RequestMapping(value = "/welcomebyparam2", method = RequestMethod.GET)
	public @ResponseBody List<Archivedate> getWelcomeByParam2(@RequestParam("param") String param,
			@RequestParam("param2") String param2) {
		System.out.println("the request param value:" + param + ", param2 value:" + param2);
		List<Archivedate> archivedate = this.testService.getSampleData();
		return archivedate;

	}

}
