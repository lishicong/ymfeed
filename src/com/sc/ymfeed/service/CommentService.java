package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.FeedComment;

public interface CommentService {

	public FeedComment getFeedCommentById(String commentId);

	public int getFeedCommentCount(String feedId);

	public List<FeedComment> getFeedCommentByLimit(String feedId, int start, int offset);

	public FeedComment addFeedComment(FeedComment feedComment);

}
