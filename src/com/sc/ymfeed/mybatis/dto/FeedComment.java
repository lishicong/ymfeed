package com.sc.ymfeed.mybatis.dto;

import java.util.Date;

import com.sc.ymfeed.mybatis.support.BaseObject;

public class FeedComment extends BaseObject {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.comment
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private String comment;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.reply_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private Integer replyCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.like_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private Integer likeCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.state
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private Integer state;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.user_account_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private String userAccountId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.feed_info_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private String feedInfoId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.create_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column feed_comment.update_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	private Date updateTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.id
	 * @return  the value of feed_comment.id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.id
	 * @param id  the value for feed_comment.id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.comment
	 * @return  the value of feed_comment.comment
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.comment
	 * @param comment  the value for feed_comment.comment
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.reply_count
	 * @return  the value of feed_comment.reply_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public Integer getReplyCount() {
		return replyCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.reply_count
	 * @param replyCount  the value for feed_comment.reply_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.like_count
	 * @return  the value of feed_comment.like_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public Integer getLikeCount() {
		return likeCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.like_count
	 * @param likeCount  the value for feed_comment.like_count
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.state
	 * @return  the value of feed_comment.state
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.state
	 * @param state  the value for feed_comment.state
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.user_account_id
	 * @return  the value of feed_comment.user_account_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public String getUserAccountId() {
		return userAccountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.user_account_id
	 * @param userAccountId  the value for feed_comment.user_account_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setUserAccountId(String userAccountId) {
		this.userAccountId = userAccountId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.feed_info_id
	 * @return  the value of feed_comment.feed_info_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public String getFeedInfoId() {
		return feedInfoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.feed_info_id
	 * @param feedInfoId  the value for feed_comment.feed_info_id
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setFeedInfoId(String feedInfoId) {
		this.feedInfoId = feedInfoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.create_time
	 * @return  the value of feed_comment.create_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.create_time
	 * @param createTime  the value for feed_comment.create_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column feed_comment.update_time
	 * @return  the value of feed_comment.update_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column feed_comment.update_time
	 * @param updateTime  the value for feed_comment.update_time
	 * @mbg.generated  Thu Sep 14 23:56:43 CST 2017
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	private UserAccount userAccount;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}