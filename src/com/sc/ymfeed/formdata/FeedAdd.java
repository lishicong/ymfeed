package com.sc.ymfeed.formdata;

import com.sc.ymfeed.controller.BaseModel;

public class FeedAdd extends BaseModel {

	public String feedId;
	public String saveTime;

	public FeedAdd(int code) {
		this.code = code;
	}

	public FeedAdd(String feedId, String saveTime) {
		this.feedId = feedId;
		this.saveTime = saveTime;
	}
}
