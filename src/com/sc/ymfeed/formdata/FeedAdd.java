package com.sc.ymfeed.formdata;

import com.sc.ymfeed.controller.BaseModel;

public class FeedAdd extends BaseModel {

	public String feedId;
	public String saveTime;

	public FeedAdd(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public FeedAdd(int code, String feedId, String saveTime) {
		this.code = code;
		this.feedId = feedId;
		this.saveTime = saveTime;
	}
}
