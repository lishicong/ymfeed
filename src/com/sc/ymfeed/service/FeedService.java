package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.FeedInfo;

public interface FeedService {

	public int getFeedCount();

	public List<FeedInfo> getFeedHomeByLimit(int start, int offset);

	public FeedInfo getFeedInfoById(String feedId);

	public int addFeedInfo(FeedInfo feedInfo);

	public int modifyFeedInfoById(FeedInfo feedInfo);

}
