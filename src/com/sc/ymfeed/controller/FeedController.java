package com.sc.ymfeed.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.service.FeedService;

@Controller
public class FeedController {

	@Resource
	private FeedService feedService;

	@RequestMapping(MAPPING.NP.DATA_FEED_LIST)
	public @ResponseBody List<FeedInfo> feedList(@RequestParam("param") String param) {

		List<FeedInfo> info = this.feedService.getFeedInfos();
		info.addAll(ExampleData.getExample());

		return info;
	}

	@RequestMapping(value = MAPPING.P.DATA_FEED_ADD, method = { RequestMethod.POST })
	public @ResponseBody String feedAdd(@RequestParam("title") String title, @RequestParam("content") String content) {

		FeedInfo info = new FeedInfo();
		info.setId(3L);
		info.setTitle(title);
		info.setContent(content);
		feedService.addFeedInfo(info);

		System.out.println(title);
		System.out.println(content);

		return "13:58";
	}
}
