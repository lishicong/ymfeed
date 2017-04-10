package com.sc.ymfeed.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.Auth;
import com.sc.ymfeed.mybatis.dto.Info;
import com.sc.ymfeed.service.UinfoService;

@Controller
@RequestMapping("/uw")
public class UserWriterController {

	private static String ACCESS_KEY = "rUFDaqLIvuzm68lvLsm_I9ik22aE_EcyGtKwbu4f";
	private static String SECRET_KEY = "I6IUCHuLiYUvvd4A_oSlqS8D9vHO519xXvLrU1HA";
	private static String BUCKET = "ymfeed";

	@Resource
	private UinfoService uinfoService;

	@RequestMapping(value = "/editor", method = { RequestMethod.GET })
	public String jump2UwriterHome(HttpServletRequest request, Model model) {

		System.out.println("123");
		return "u.writer.editor.b";
	}

	@RequestMapping(value = "/publish", method = { RequestMethod.POST })
	public @ResponseBody String publish(@RequestParam("title") String title, @RequestParam("content") String content) {

		Info info = new Info();
		info.setId(3L);
		info.setTitle(title);
		info.setContent(content);
		uinfoService.addInfo(info);

		System.out.println(title);
		System.out.println(content);

		return "13:58";
	}

	@RequestMapping(value = "/qntok", method = { RequestMethod.GET })
	public @ResponseBody String qiniuToken() {

		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String token = auth.uploadToken(BUCKET);
		return "{\"uptoken\":\"" + token + "\"}";
	}

}
