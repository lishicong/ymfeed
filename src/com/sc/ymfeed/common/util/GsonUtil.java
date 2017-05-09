package com.sc.ymfeed.common.util;

import com.google.gson.Gson;
import com.sc.ymfeed.controller.BaseModel;

public class GsonUtil {

	private GsonUtil() {
	}

	public static final String toJSONObject(BaseModel model) {
		Gson gson = new Gson();
		return gson.toJson(model);
	}

	public static final String toJSONSimple(int code, String msg) {
		return "{\"code\": " + code + ",\"msg\": \"" + msg + "\"}";
	}

	public static final String toJSONStr(String key, String value) {
		return "{\"" + key + "\":\"" + value + "\"}";
	}

}
