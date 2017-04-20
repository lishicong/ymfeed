package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.FeedInfoMapper;
import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.mybatis.dto.FeedInfoExample;
import com.sc.ymfeed.service.FeedService;

@Service("feedService")
public class FeedServiceImpl implements FeedService {

	@Resource
	private FeedInfoMapper mapper;

	@Override
	public List<FeedInfo> getFeedInfos() {
		FeedInfoExample example = new FeedInfoExample();
		return mapper.selectByExample(example);
	}

	@Override
	public int addFeedInfo(FeedInfo info) {
		return mapper.insert(info);
	}

}
