package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.FeedInfo;

/**
 * spring service interface demo.
 * 
 * @author lishicong
 */
public interface SampleService {

	public List<FeedInfo> getSampleData();
}
