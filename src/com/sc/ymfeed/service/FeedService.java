package com.sc.ymfeed.service;

import java.util.List;

import com.sc.ymfeed.common.enums.FeedInfoSaveEnum;
import com.sc.ymfeed.mybatis.dto.FeedInfo;

public interface FeedService {

	public List<FeedInfo> getFeedInfos();

	public long addFeedInfo(String userInfoId, String title, String content, FeedInfoSaveEnum save);

	public long modifyFeedInfoById(String id, String title, String content, FeedInfoSaveEnum save);

}
