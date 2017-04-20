package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.mybatis.dto.FeedInfo;

public interface FeedService {

	public List<FeedInfo> getFeedInfos();

	public int addFeedInfo(FeedInfo info);

}
