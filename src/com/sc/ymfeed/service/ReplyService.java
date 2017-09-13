package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.CommentReply;

public interface ReplyService {

	public List<CommentReply> getCommentReplyByLimit(List<String> commentIds, int start, int offset);

	public CommentReply getCommentReplyById(String commentId);

	public int addCommentReply(CommentReply commentReply);

}
