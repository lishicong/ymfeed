package com.sc.ymfeed.controller.feed;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.FeedInfo;

/**
 * 查询Feed列表
 * 
 * @author lishicong
 *
 */
public class FeedListController extends FeedController {

	@RequestMapping(MAPPING.NP.DATA_FEED_LIST)
	public @ResponseBody List<FeedInfo> feedList(@RequestParam("param") String param) {

		List<FeedInfo> info = this.feedService.getFeedInfos();
		info.addAll(ExampleData.getExample());

		return info;
	}

}
