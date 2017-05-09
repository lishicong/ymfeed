package com.sc.ymfeed.mybatis.dto;

import com.sc.ymfeed.mybatis.support.BaseObject;
import java.util.Date;

public class FeedInfo extends BaseObject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.user_info_id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Long userInfoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.title
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.preview_img
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private String previewImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.browse_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Integer browseCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.comment_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.like_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.create_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.update_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column feed_info.content
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.id
     *
     * @return the value of feed_info.id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.id
     *
     * @param id the value for feed_info.id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.user_info_id
     *
     * @return the value of feed_info.user_info_id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Long getUserInfoId() {
        return userInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.user_info_id
     *
     * @param userInfoId the value for feed_info.user_info_id
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.title
     *
     * @return the value of feed_info.title
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.title
     *
     * @param title the value for feed_info.title
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.preview_img
     *
     * @return the value of feed_info.preview_img
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public String getPreviewImg() {
        return previewImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.preview_img
     *
     * @param previewImg the value for feed_info.preview_img
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setPreviewImg(String previewImg) {
        this.previewImg = previewImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.browse_count
     *
     * @return the value of feed_info.browse_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Integer getBrowseCount() {
        return browseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.browse_count
     *
     * @param browseCount the value for feed_info.browse_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.comment_count
     *
     * @return the value of feed_info.comment_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.comment_count
     *
     * @param commentCount the value for feed_info.comment_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.like_count
     *
     * @return the value of feed_info.like_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.like_count
     *
     * @param likeCount the value for feed_info.like_count
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.create_time
     *
     * @return the value of feed_info.create_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.create_time
     *
     * @param createTime the value for feed_info.create_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.update_time
     *
     * @return the value of feed_info.update_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.update_time
     *
     * @param updateTime the value for feed_info.update_time
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column feed_info.content
     *
     * @return the value of feed_info.content
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column feed_info.content
     *
     * @param content the value for feed_info.content
     *
     * @mbg.generated Thu Apr 27 12:53:04 CST 2017
     */
    public void setContent(String content) {
        this.content = content;
    }
}