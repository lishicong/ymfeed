package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.CommentReply;

public interface ReplyService {

	public List<CommentReply> getCommentReplyByLimit3(List<String> commentIds);

	public List<CommentReply> getCommentReplyByLimit(String commentId, int start, int offset);

	public CommentReply addCommentReply(CommentReply commentReply);

}
