package com.sc.ymfeed.common.util;

import com.google.gson.Gson;
import com.sc.ymfeed.controller.BaseModel;

public class GsonUtil {

	private GsonUtil() {
	}

	public static final String toJSON(BaseModel model) {
		Gson gson = new Gson();
		return gson.toJson(model);
	}

}
