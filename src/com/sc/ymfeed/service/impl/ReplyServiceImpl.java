package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.common.enums.FeedCommentReplyState;
import com.sc.ymfeed.mybatis.dao.CommentReplyMapper;
import com.sc.ymfeed.mybatis.dto.CommentReply;
import com.sc.ymfeed.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private CommentReplyMapper mapper;

	public CommentReply getCommentReplyById(String commentId) {
		return mapper.selectCommentReplyById(commentId, FeedCommentReplyState.STATE_1);
	}

	public List<CommentReply> getCommentReplyByLimit(List<String> commentIds, int start, int offset) {
		return mapper.selectCommentReplyByLimit(commentIds, FeedCommentReplyState.STATE_1, start, offset);
	}

	public int addCommentReply(CommentReply commentReply) {
		return mapper.insertSelective(commentReply);
	}

}
