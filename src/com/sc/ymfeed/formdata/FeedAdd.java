package com.sc.ymfeed.formdata;

import com.sc.ymfeed.controller.BaseModel;

public class FeedAdd extends BaseModel {

	public String feedId;
	public String saveTime;
	public int saveMode;

	public FeedAdd(int code, String feedId, String saveTime, int saveMode) {
		this.code = code;
		this.feedId = feedId;
		this.saveTime = saveTime;
		this.saveMode = saveMode;
	}
}
