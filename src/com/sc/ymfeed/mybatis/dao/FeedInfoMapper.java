package com.sc.ymfeed.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.ymfeed.mybatis.dto.FeedInfo;

public interface FeedInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	int insert(FeedInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	int insertSelective(FeedInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	FeedInfo selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	int updateByPrimaryKeySelective(FeedInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table feed_info
	 * 
	 * @mbg.generated Thu Sep 14 23:56:43 CST 2017
	 */
	int updateByPrimaryKey(FeedInfo record);

	FeedInfo selectFeedById(@Param("feedId") String feedId);

	List<FeedInfo> selectFeedHomeByLimit(@Param("start") int start, @Param("offset") int offset);

}