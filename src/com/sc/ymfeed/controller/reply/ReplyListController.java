package com.sc.ymfeed.controller.reply;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.mybatis.dto.CommentReply;

/**
 * 回复列表
 * 
 * @author lishicong
 *
 */
@Controller
public class ReplyListController extends ReplyController {

	@RequestMapping(value = MAPPING.NP.DATA_REPLY_LIST, method = { RequestMethod.GET })
	public @ResponseBody List<CommentReply> replyList(HttpServletRequest request, @RequestParam("cids") String cids) {

		List<String> commentIds = Arrays.asList(cids.split(","));
		List<CommentReply> replys = this.replyService.getCommentReplyByLimit3(commentIds);

		return replys;
	}

	@RequestMapping(value = MAPPING.NP.DATA_REPLY_LISTMORE, method = { RequestMethod.GET })
	public @ResponseBody List<CommentReply> replyListMore(HttpServletRequest request, @RequestParam("cid") String cid) {

		List<CommentReply> replys = this.replyService.getCommentReplyByLimit(cid, 3, 100); // 最多取100条

		return replys;
	}

}
