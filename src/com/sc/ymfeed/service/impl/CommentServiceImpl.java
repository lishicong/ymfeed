package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.common.enums.FeedCommentReplyState;
import com.sc.ymfeed.mybatis.dao.FeedCommentMapper;
import com.sc.ymfeed.mybatis.dto.FeedComment;
import com.sc.ymfeed.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private FeedCommentMapper mapper;

	@Override
	public FeedComment getFeedCommentById(String commentId) {

		return mapper.selectFeedCommentById(commentId);
	}

	@Override
	public List<FeedComment> getFeedCommentByLimit(String feedId, int start, int offset) {
		return mapper.selectFeedCommentByLimit(feedId, FeedCommentReplyState.STATE_1, start, offset);
	}

	@Override
	public int addFeedComment(FeedComment feedComment) {
		return mapper.insertSelective(feedComment);
	}

}
