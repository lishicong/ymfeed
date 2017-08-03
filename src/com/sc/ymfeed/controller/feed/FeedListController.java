package com.sc.ymfeed.controller.feed;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.Constants;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.FeedInfo;

/**
 * 查询Feed列表
 * 
 * @author lishicong
 *
 */
@Controller
public class FeedListController extends FeedController {

	@RequestMapping(value = MAPPING.NP.DATA_FEED_HOME, method = { RequestMethod.GET })
	public @ResponseBody List<FeedInfo> feedHome(HttpServletRequest request, @RequestParam("param") String param) {

		List<FeedInfo> info = this.feedService.getFeedHomeByLimit(0, Constants.OFFSET);
		info.addAll(ExampleData.getExample());

		return info;
	}

}
