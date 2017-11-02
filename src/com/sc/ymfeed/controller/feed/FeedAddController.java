package com.sc.ymfeed.controller.feed;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.ymfeed.common.Constants;
import com.sc.ymfeed.common.enums.FeedInfoSaveMode;
import com.sc.ymfeed.common.enums.FeedInfoState;
import com.sc.ymfeed.common.util.DateUtil;
import com.sc.ymfeed.common.util.GsonUtil;
import com.sc.ymfeed.common.util.HtmlUtil;
import com.sc.ymfeed.common.util.UUIDUtil;
import com.sc.ymfeed.controller.MAPPING;
import com.sc.ymfeed.controller.Messages;
import com.sc.ymfeed.formdata.FeedAdd;
import com.sc.ymfeed.mybatis.dto.FeedInfo;

/**
 * 添加一个Feed
 * 
 * @author lishicong
 *
 */
@Controller
public class FeedAddController extends FeedController {

	@RequestMapping(value = MAPPING.P.DATA_FEED_ADD, method = {
			RequestMethod.POST }, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String feedAdd(@RequestParam("feedId") String feedId, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("saveMode") int saveMode,
			HttpServletRequest request) {

		super.initSession(request);

		if (title == null || title.trim().length() == 0) {
			return GsonUtil.toJSONObject(new FeedAdd(1004, feedId, "", saveMode));
		}

		if (feedId == null || feedId.trim().length() == 0) {
			// feedId为空，创建新的feed
			FeedInfo feedInfo = createFeedInfo(title, content, saveMode);

			boolean isTooLarge = isContentTooLarge(feedInfo);

			int result = feedService.addFeedInfo(feedInfo);
			if (result == 1) {
				return getJson(feedInfo, isTooLarge, saveMode);
			}
		} else {
			FeedInfo feedInfo = feedService.getFeedInfoById(feedId);
			if (feedInfo == null) {
				// 有feedId，但没有找到数据，创建新的feed，正常情况下不会出现
				feedInfo = createFeedInfo(title, content, saveMode);

				boolean isTooLarge = isContentTooLarge(feedInfo);

				int result = feedService.addFeedInfo(feedInfo);
				if (result == 1) {
					return getJson(feedInfo, isTooLarge, saveMode);
				}
			} else if (feedInfo.getUserAccountId().equals(userAccountByCookie.getId())) {
				// 找到feed，并且用户id匹配，更新
				feedInfo = setFeedInfo(feedInfo, title, content, saveMode);

				boolean isTooLarge = isContentTooLarge(feedInfo);

				int result = feedService.modifyFeedInfoById(feedInfo);
				if (result == 1) {
					return getJson(feedInfo, isTooLarge, saveMode);
				}
			}
		}
		return GsonUtil.toJSONObject(new FeedAdd(Messages.CODE_FAILURE, feedId, "", saveMode));
	}

	private String getJson(FeedInfo feedInfo, boolean isTooLarge, int saveMode) {
		String saveTime = DateUtil.formatter(feedInfo.getUpdateTime(), DateUtil.DATE_FORMAT_HHMM_CN);
		FeedAdd feedAdd = null;
		if (!isTooLarge) {
			feedAdd = new FeedAdd(Messages.CODE_SUCCESS, feedInfo.getId(), saveTime, saveMode);
		} else {
			feedAdd = new FeedAdd(1003, feedInfo.getId(), saveTime, saveMode);
		}
		return GsonUtil.toJSONObject(feedAdd);
	}

	/**
	 * 创建feed
	 * 
	 * @param title
	 * @param content
	 * @param saveMode
	 * @return
	 */
	private FeedInfo createFeedInfo(String title, String content, int saveMode) {
		FeedInfo feedInfo = new FeedInfo();
		feedInfo.setId(UUIDUtil.getUUID());
		feedInfo.setUserAccountId(userAccountByCookie.getId()); // 用户ID

		if (saveMode == FeedInfoSaveMode.AUTO_SAVE) {
			// 系统自动保存的feed为未发布状态
			feedInfo.setState(FeedInfoState.STATE_0); // feed状态为未发布
		} else {
			// 用户手动发布
			feedInfo.setState(FeedInfoState.STATE_1); // feed状态为已发布
			feedInfo.setPublishTime(new Date()); // 发布时间
		}
		feedInfo.setUpdateTime(new Date());
		feedInfo.setCreateTime(new Date());
		return setFeedInfo(feedInfo, title, content, saveMode);
	}

	/**
	 * 封装数据
	 * 
	 * @param feedInfo
	 * @param title
	 * @param content
	 * @param saveMode
	 * @return
	 */
	private FeedInfo setFeedInfo(FeedInfo feedInfo, String title, String content, int saveMode) {
		feedInfo.setTitle(title); // 标题
		feedInfo.setContent(content); // 内容

		feedInfo.setPreviewImg(HtmlUtil.getFirstImgSrc(content));
		feedInfo.setPreviewContent(
				HtmlUtil.subTextString(HtmlUtil.getFilterHtml(content), Constants.PREVIEW_CONTENT_LENGTH));
		feedInfo.setUpdateTime(new Date());
		if (saveMode == FeedInfoSaveMode.MANUAL_SAVE) {
			// 用户手动发布
			feedInfo.setState(FeedInfoState.STATE_1); // feed状态为已发布
			feedInfo.setPublishTime(new Date()); // 发布时间
		}
		return feedInfo;
	}

	/**
	 * 内容超出长度限制
	 * 
	 * @param feedInfo
	 * @return
	 */
	private boolean isContentTooLarge(FeedInfo feedInfo) {
		String content = feedInfo.getContent();
		if (content.length() <= Constants.FEED_ADD_CONTENT_MAX) {
			return false;
		}
		feedInfo.setContent(HtmlUtil.subTextString(content, Constants.FEED_ADD_CONTENT_MAX));
		return true;
	}

}
