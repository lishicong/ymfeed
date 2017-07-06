package com.sc.ymfeed.controller.feed;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Controller
public class FeedListController extends FeedController {

	@RequestMapping(value = MAPPING.NP.DATA_FEED_LIST, method = { RequestMethod.GET })
	public @ResponseBody List<FeedInfo> feedList(HttpServletRequest request, @RequestParam("param") String param) {
		System.out.println("param:" + param);
		List<FeedInfo> info = this.feedService.getFeedInfos();
		
		for(FeedInfo i:info){
			System.out.println("info:"+i.getContent());
		}
		info.addAll(ExampleData.getExample());
		
		

		return info;
	}

}
