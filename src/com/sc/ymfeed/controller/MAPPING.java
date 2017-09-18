package com.sc.ymfeed.controller;

public class MAPPING {

	private MAPPING() {
	}

	/**
	 * need't permission
	 */
	public static class NP {
		public static final String DIRECT_HOME = "/index"; // 主页面
		public static final String DIRECT_SIGN_IN = "/signin"; // 登录页面
		public static final String DIRECT_SIGN_UP = "/signup"; // 注册页面
		public static final String DIRECT_SIGN_OUT = "/signout"; // 登出数据
		public static final String DIRECT_SIGN_LOST = "/signlost"; // 找回密码页面
		public static final String DIRECT_SIGN_RESET = "/signreset"; // 找回密码页面
		public static final String DIRECT_SIGN_ACTIVE = "/active"; // 激活页面
		public static final String DIRECT_SIGN_ACTIVED = "/actived"; // 已激活页面
		public static final String DIRECT_FEED_DETAIL = "/f"; // 已激活页面

		public static final String DATA_FEED_HOME = "/data/feed/home"; // feed流
		public static final String DATA_COMMENT_LIST = "/data/comment/list"; // 评论列表
		public static final String DATA_COMMENT_LISTCOUNT = "/data/comment/listcount"; // 评论列表总数
		public static final String DATA_REPLY_LIST = "/data/reply/list"; // 评论回复列表-3条
		public static final String DATA_REPLY_LISTMORE = "/data/reply/listmore"; // 评论回复列表
		public static final String DATA_SIGN_IN = "/data/sign/in"; // 登录数据
		public static final String DATA_SIGN_UP = "/data/sign/up"; // 注册数据
		public static final String DATA_SIGN_LOST = "/data/sign/lost"; // 找回密码数据
		public static final String DATA_SIGN_LOSTCode = "/data/sign/lostcode"; // 找回密码数据
		public static final String DATA_SIGN_VALIDATE = "/data/sign/validate"; // 找回密码发送验证码
		public static final String DATA_SIGN_REACTIVE = "/data/sign/reactive"; // 重复发送激活页面
	}

	/**
	 * need permission
	 */
	public static class P {

		public static final String DIRECT_WRITER = "/p/writer"; // 写文章页面

		public static final String DATA_COMMENT_ADD = "/p/data/comment/add"; // 添加评论数据
		public static final String DATA_REPLY_ADD = "/p/data/reply/add"; // 添加评论回复数据
		public static final String DATA_FEED_ADD = "/p/data/feed/add"; // 添加文章数据
		public static final String DATA_QINIU_TOKEN = "/p/data/qiniu/token"; // 获取七牛token数据
	}

	/**
	 * 对应tiles的模板
	 */
	public static class TEMPLATE {
		public static final String TEMPLATE_A = ".aaa"; // 登录注册
		public static final String TEMPLATE_B = ".bbb"; // 编辑
		public static final String TEMPLATE_C = ".ccc"; // 首页
		public static final String TEMPLATE_D = ".ddd"; // 详情
	}

}
