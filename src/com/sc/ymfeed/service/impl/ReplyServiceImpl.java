package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.CommentReplyMapper;
import com.sc.ymfeed.mybatis.dao.FeedCommentMapper;
import com.sc.ymfeed.mybatis.dao.FeedInfoMapper;
import com.sc.ymfeed.mybatis.dto.CommentReply;
import com.sc.ymfeed.mybatis.dto.FeedComment;
import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private FeedInfoMapper feedMapper;
	@Resource
	private FeedCommentMapper commentMapper;
	@Resource
	private CommentReplyMapper replyMapper;

	public List<CommentReply> getCommentReplyByLimit3(List<String> commentIds) {
		return replyMapper.selectCommentReplyByLimit3(commentIds);
	}

	public List<CommentReply> getCommentReplyByLimit(String commentId, int start, int offset) {
		return replyMapper.selectCommentReplyByLimit(commentId, start, offset);
	}

	/**
	 * 添加一条评论回复
	 */
	public CommentReply addCommentReply(CommentReply commentReply) {
		int result = replyMapper.insertSelective(commentReply);
		if (result == 1) {

			// 添加回复成功后，修改Feed回复数量
			FeedInfo feedInfo = feedMapper.selectByPrimaryKey(commentReply.getFeedInfoId());
			int replyFeedCount = feedInfo.getReplyCount() == null ? 0 : feedInfo.getReplyCount();
			replyFeedCount = replyFeedCount + 1;
			feedInfo.setReplyCount(replyFeedCount);
			feedMapper.updateByPrimaryKeySelective(feedInfo);

			// 添加回复成功后，修改评论回复数量
			FeedComment feedComment = commentMapper.selectByPrimaryKey(commentReply.getFeedCommentId());
			int replyCommentCount = feedComment.getReplyCount() == null ? 0 : feedComment.getReplyCount();
			replyCommentCount = replyCommentCount + 1;
			feedComment.setReplyCount(replyCommentCount);
			commentMapper.updateByPrimaryKeySelective(feedComment);

			// 添加成功后返回回复的详细信息
			return replyMapper.selectCommentReplyById(commentReply.getId());
		}
		return null;
	}

}
