package com.sc.ymfeed.mybatis.dto;

import com.sc.ymfeed.mybatis.support.BaseObject;
import java.util.Date;

public class UserAccount extends BaseObject {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.email
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.mobile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.password
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.nickname
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.auth_level
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Integer authLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.gag
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Boolean gag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.blocked
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Boolean blocked;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.active
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Boolean active;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.active_code
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private String activeCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.active_code_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date activeCodeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.active_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date activeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_account.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.id
     *
     * @return the value of user_account.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.id
     *
     * @param id the value for user_account.id
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.email
     *
     * @return the value of user_account.email
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.email
     *
     * @param email the value for user_account.email
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.mobile
     *
     * @return the value of user_account.mobile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.mobile
     *
     * @param mobile the value for user_account.mobile
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.password
     *
     * @return the value of user_account.password
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.password
     *
     * @param password the value for user_account.password
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.nickname
     *
     * @return the value of user_account.nickname
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.nickname
     *
     * @param nickname the value for user_account.nickname
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.auth_level
     *
     * @return the value of user_account.auth_level
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Integer getAuthLevel() {
        return authLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.auth_level
     *
     * @param authLevel the value for user_account.auth_level
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setAuthLevel(Integer authLevel) {
        this.authLevel = authLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.gag
     *
     * @return the value of user_account.gag
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Boolean getGag() {
        return gag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.gag
     *
     * @param gag the value for user_account.gag
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setGag(Boolean gag) {
        this.gag = gag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.blocked
     *
     * @return the value of user_account.blocked
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Boolean getBlocked() {
        return blocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.blocked
     *
     * @param blocked the value for user_account.blocked
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.active
     *
     * @return the value of user_account.active
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.active
     *
     * @param active the value for user_account.active
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.active_code
     *
     * @return the value of user_account.active_code
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public String getActiveCode() {
        return activeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.active_code
     *
     * @param activeCode the value for user_account.active_code
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.active_code_time
     *
     * @return the value of user_account.active_code_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getActiveCodeTime() {
        return activeCodeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.active_code_time
     *
     * @param activeCodeTime the value for user_account.active_code_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setActiveCodeTime(Date activeCodeTime) {
        this.activeCodeTime = activeCodeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.active_time
     *
     * @return the value of user_account.active_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getActiveTime() {
        return activeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.active_time
     *
     * @param activeTime the value for user_account.active_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.create_time
     *
     * @return the value of user_account.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.create_time
     *
     * @param createTime the value for user_account.create_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_account.update_time
     *
     * @return the value of user_account.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_account.update_time
     *
     * @param updateTime the value for user_account.update_time
     *
     * @mbg.generated Wed Jul 05 17:35:32 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}