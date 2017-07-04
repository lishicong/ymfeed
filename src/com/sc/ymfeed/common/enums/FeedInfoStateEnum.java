package com.sc.ymfeed.common.enums;

/**
 * Feed信息状态值
 * 
 * @author lishicong
 *
 */
public enum FeedInfoStateEnum {

	UNRELEASED, // 0未发布
	RELEASED, // 1已发布未审核
	REVIEWED, // 2审核通过
	REVIEWED_FAIL, // 3审核未通过
	HIDDEN, // 4用户隐藏
	DELETE, // 5用户删除
	REMOVE; // 6管理员删除

}
