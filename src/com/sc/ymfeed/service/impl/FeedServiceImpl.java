package com.sc.ymfeed.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sc.ymfeed.common.enums.FeedInfoSaveEnum;
import com.sc.ymfeed.common.enums.FeedInfoStateEnum;
import com.sc.ymfeed.common.util.UUIDUtil;
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
	public long addFeedInfo(String userInfoId, String title, String content, FeedInfoSaveEnum save) {

		FeedInfo feedInfo = new FeedInfo();
		feedInfo.setId(UUIDUtil.getUUID());
		feedInfo.setUserInfoId(userInfoId); // 用户ID
		feedInfo.setTitle(title); // 标题
		feedInfo.setContent(content); // 内容

		if (save == FeedInfoSaveEnum.AUTO_SAVE) {
			// 系统自动保存的feed为未发布状态
			feedInfo.setState(FeedInfoStateEnum.UNRELEASED.ordinal()); // feed状态为未发布
		} else {
			// 用户手动发布
			feedInfo.setState(FeedInfoStateEnum.RELEASED.ordinal()); // feed状态为已发布
			feedInfo.setPublishTime(new Date()); // 发布时间
		}

		feedInfo.setCreateTime(new Date()); // 创建时间

		return mapper.insert(feedInfo);
	}

	public long modifyFeedInfoById(String id, String title, String content, FeedInfoSaveEnum save) {

		FeedInfo feedInfo = mapper.selectByPrimaryKey(id);
		if (feedInfo != null) {
			feedInfo.setTitle(title);
			feedInfo.setContent(content);

			if (save != FeedInfoSaveEnum.AUTO_SAVE) {
				feedInfo.setState(FeedInfoStateEnum.RELEASED.ordinal()); // feed状态为已发布
				feedInfo.setPublishTime(new Date()); // 发布时间
			}
		}
		return 0;
	}

}
