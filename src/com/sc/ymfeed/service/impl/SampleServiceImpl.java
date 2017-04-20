package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.FeedInfoMapper;
import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.mybatis.dto.FeedInfoExample;
import com.sc.ymfeed.service.SampleService;

/**
 * spring service implement demo.
 * 
 * @author lishicong
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	@Resource
	private FeedInfoMapper mapper;

	@Override
	public List<FeedInfo> getSampleData() {
		FeedInfoExample example = new FeedInfoExample();
		return mapper.selectByExample(example);
	}
}
