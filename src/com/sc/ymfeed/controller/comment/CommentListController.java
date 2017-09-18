package com.sc.ymfeed.controller.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.Constants;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.FeedComment;

/**
 * 查询评论列表
 * 
 * @author lishicong
 *
 */
@Controller
public class CommentListController extends CommentController {

	@RequestMapping(value = MAPPING.NP.DATA_COMMENT_LISTCOUNT, method = { RequestMethod.GET })
	public @ResponseBody int commentListCount(HttpServletRequest request, @RequestParam("fid") String fid) {

		int count = this.commentService.getFeedCommentCount(fid);
		return count;
	}

	@RequestMapping(value = MAPPING.NP.DATA_COMMENT_LIST, method = { RequestMethod.GET })
	public @ResponseBody List<FeedComment> commentList(HttpServletRequest request, @RequestParam("fid") String fid,
			@RequestParam("page") int page) {

		int start = page > 0 ? (page - 1) * Constants.OFFSET : 0;
		List<FeedComment> list = this.commentService.getFeedCommentByLimit(fid, start, Constants.OFFSET);
		return list;
	}

}
