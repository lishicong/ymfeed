package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.FeedCommentMapper;
import com.sc.ymfeed.mybatis.dao.FeedInfoMapper;
import com.sc.ymfeed.mybatis.dto.FeedComment;
import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private FeedInfoMapper feedMapper;
	@Resource
	private FeedCommentMapper commentMapper;

	@Override
	public FeedComment getFeedCommentById(String commentId) {

		return commentMapper.selectFeedCommentById(commentId);
	}

	@Override
	public int getFeedCommentCount(String feedId) {
		return commentMapper.selectFeedCommentCountById(feedId);
	}

	@Override
	public List<FeedComment> getFeedCommentByLimit(String feedId, int start, int offset) {
		return commentMapper.selectFeedCommentByLimit(feedId, start, offset);
	}

	@Override
	public FeedComment addFeedComment(FeedComment feedComment) {

		int result = commentMapper.insertSelective(feedComment);
		if (result == 1) {
			// 添加评论成功后，修改Feed评论数量
			FeedInfo feedInfo = feedMapper.selectByPrimaryKey(feedComment.getFeedInfoId());
			int commentCount = feedInfo.getCommentCount() == null ? 0 : feedInfo.getCommentCount();
			commentCount = commentCount + 1;
			feedInfo.setCommentCount(commentCount);
			feedMapper.updateByPrimaryKeySelective(feedInfo);

			return commentMapper.selectFeedCommentById(feedComment.getId());
		}
		return null;
	}

}
