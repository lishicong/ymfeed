package com.sc.ymfeed.common.util;

import javax.servlet.http.HttpServletRequest;

public class ContextUtil {

	private ContextUtil() {
	}

	/**
	 * 获取系统根目录
	 * 
	 * @param request
	 * @return
	 */
	public static String getRootPath(HttpServletRequest request) {

		// 基本路径
		StringBuffer basePath = new StringBuffer();
		basePath.append(request.getScheme()).append("://");
		basePath.append(request.getServerName()).append(":");
		basePath.append(request.getServerPort()).append(request.getContextPath());

		return basePath.toString();
	}

}
