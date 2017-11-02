package com.sc.ymfeed.controller.feed;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.FeedInfo;

/**
 * Feed详情
 * 
 * @author lishicong
 *
 */
@Controller
public class FeedDetailController extends FeedController {

	@RequestMapping(value = MAPPING.NP.DIRECT_FEED_DETAIL + "/{feedId}", method = { RequestMethod.GET })
	public String f(HttpServletRequest request, Model model, @PathVariable(value = "feedId") String feedId) {
		FeedInfo feedInfo = feedService.getFeedInfoById(feedId);
		model.addAttribute("feedInfo", feedInfo);
		return "view.home.detail" + MAPPING.TEMPLATE.TEMPLATE_D;
	}
}
