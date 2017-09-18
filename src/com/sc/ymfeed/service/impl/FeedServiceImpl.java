package com.sc.ymfeed.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.mybatis.dao.FeedInfoMapper;
import com.sc.ymfeed.mybatis.dto.FeedInfo;
import com.sc.ymfeed.service.FeedService;

@Service("feedService")
public class FeedServiceImpl implements FeedService {

	@Resource
	private FeedInfoMapper mapper;

	@Override
	public List<FeedInfo> getFeedHomeByLimit(int start, int offset) {

		return mapper.selectFeedHomeByLimit(start, offset);
	}

	@Override
	public FeedInfo getFeedInfoById(String feedId) {
		return mapper.selectFeedById(feedId);
	}

	@Override
	public int addFeedInfo(FeedInfo feedInfo) {
		return mapper.insert(feedInfo);
	}

	public int modifyFeedInfoById(FeedInfo feedInfo) {
		return mapper.updateByPrimaryKeySelective(feedInfo);
	}

}
