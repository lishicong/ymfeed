package com.sc.ymfeed.controller.comment;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.enums.FeedCommentReplyState;
import com.sc.ymfeed.common.util.UUIDUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.FeedComment;

/**
 * 添加评论列表
 * 
 * @author lishicong
 *
 */
@Controller
public class CommentAddController extends CommentController {

	@RequestMapping(value = MAPPING.P.DATA_COMMENT_ADD, method = { RequestMethod.POST })
	public @ResponseBody FeedComment addComment(HttpServletRequest request, @RequestParam("comment") String comment,
			@RequestParam("fid") String feedInfoId) {

		super.initSession(request);

		FeedComment feedComment = new FeedComment();
		feedComment.setUserAccountId(userAccountByCookie.getId());
		feedComment.setId(UUIDUtil.getUUID());
		feedComment.setComment(comment);
		feedComment.setState(FeedCommentReplyState.STATE_0);
		feedComment.setFeedInfoId(feedInfoId);
		feedComment.setCreateTime(new Date());
		int result = this.commentService.addFeedComment(feedComment);

		if (result == 1) {
			// 评论成功
			return feedComment;
		}
		return null;
	}
}
