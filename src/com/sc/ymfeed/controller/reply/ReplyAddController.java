package com.sc.ymfeed.controller.reply;

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
import com.sc.ymfeed.mybatis.dto.CommentReply;

@Controller
public class ReplyAddController extends ReplyController {

	@RequestMapping(value = MAPPING.P.DATA_REPLY_ADD, method = { RequestMethod.POST })
	public @ResponseBody CommentReply replyAdd(HttpServletRequest request, @RequestParam("reply") String reply,
			@RequestParam("replyToUserAccountId") String replyToUserAccountId,
			@RequestParam("feedInfoId") String feedInfoId, @RequestParam("feedCommentId") String feedCommentId) {

		super.initSession(request);

		CommentReply commentReply = new CommentReply();
		commentReply.setId(UUIDUtil.getUUID());
		commentReply.setReply(reply);
		commentReply.setState(FeedCommentReplyState.STATE_0);
		commentReply.setUserAccountId(userAccountByCookie.getId());
		commentReply.setReplyToUserAccountId(replyToUserAccountId);
		commentReply.setFeedInfoId(feedInfoId);
		commentReply.setFeedCommentId(feedCommentId);
		commentReply.setCreateTime(new Date());

		int result = this.replyService.addCommentReply(commentReply);
		if (result == 1) {
			return commentReply;
		}

		return null;
	}

}
