package com.sc.ymfeed.mybatis.dto;

import com.sc.ymfeed.mybatis.support.BaseObject;
import java.util.Date;

public class UserInfo extends BaseObject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.user_account_id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String userAccountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.avatar
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.profile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String profile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.sex
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.birthday
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_account_id
     *
     * @return the value of user_info.user_account_id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getUserAccountId() {
        return userAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_account_id
     *
     * @param userAccountId the value for user_info.user_account_id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.avatar
     *
     * @return the value of user_info.avatar
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.avatar
     *
     * @param avatar the value for user_info.avatar
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.profile
     *
     * @return the value of user_info.profile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getProfile() {
        return profile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.profile
     *
     * @param profile the value for user_info.profile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.sex
     *
     * @return the value of user_info.sex
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.sex
     *
     * @param sex the value for user_info.sex
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.birthday
     *
     * @return the value of user_info.birthday
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.birthday
     *
     * @param birthday the value for user_info.birthday
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.create_time
     *
     * @return the value of user_info.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.create_time
     *
     * @param createTime the value for user_info.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.update_time
     *
     * @return the value of user_info.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.update_time
     *
     * @param updateTime the value for user_info.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}