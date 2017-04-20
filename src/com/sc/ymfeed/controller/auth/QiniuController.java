package com.sc.ymfeed.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qiniu.util.Auth;
import com.sc.ymfeed.controller.MAPPING;

@Controller
public class QiniuController {

	private static String ACCESS_KEY = "rUFDaqLIvuzm68lvLsm_I9ik22aE_EcyGtKwbu4f";
	private static String SECRET_KEY = "I6IUCHuLiYUvvd4A_oSlqS8D9vHO519xXvLrU1HA";
	private static String BUCKET = "ymfeed";

	@RequestMapping(value = MAPPING.P.DATA_QINIU_TOKEN, method = { RequestMethod.GET })
	public @ResponseBody String qiniuToken() {

		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String token = auth.uploadToken(BUCKET);
		return "{\"uptoken\":\"" + token + "\"}";
	}

}
