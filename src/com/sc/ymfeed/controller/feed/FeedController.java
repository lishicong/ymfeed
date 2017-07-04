package com.sc.ymfeed.controller.feed;

import javax.annotation.Resource;

import com.sc.ymfeed.controller.BaseController;
import com.sc.ymfeed.service.FeedService;

public abstract class FeedController extends BaseController {

	@Resource
	FeedService feedService;
}
