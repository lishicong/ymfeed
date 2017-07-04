package com.sc.ymfeed.controller.feed;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.enums.FeedInfoSaveEnum;
import com.sc.ymfeed.controller.MAPPING;

/**
 * 添加一个Feed
 * 
 * @author lishicong
 *
 */
public class FeedAddController extends FeedController {

	@RequestMapping(value = MAPPING.P.DATA_FEED_ADD, method = { RequestMethod.POST })
	public @ResponseBody String feedAdd(@RequestParam("title") String title, @RequestParam("content") String content,
			HttpServletRequest request) {

		super.initSession(request);

		feedService.addFeedInfo(userAccountByCookie.getId(), title, content, FeedInfoSaveEnum.AUTO_SAVE);

		return "13:58";
	}

}
