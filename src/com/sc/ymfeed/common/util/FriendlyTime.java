package com.sc.ymfeed.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendlyTime {

	public static String getFriendlytime(Date d) {
		long delta = (new Date().getTime() - d.getTime()) / 1000;
		if (delta <= 0) {
			return d.toString();
		}
		if (delta / (60 * 60 * 24 * 365) > 0) {
			return delta / (60 * 60 * 24 * 365) + "年前";
		}
		if (delta / (60 * 60 * 24 * 30) > 0) {
			return delta / (60 * 60 * 24 * 30) + "个月前";
		}
		if (delta / (60 * 60 * 24 * 7) > 0) {
			return delta / (60 * 60 * 24 * 7) + "周前";
		}
		if (delta / (60 * 60 * 24) > 0) {
			return delta / (60 * 60 * 24) + "天前";
		}
		if (delta / (60 * 60) > 0) {
			return delta / (60 * 60) + "小时前";
		}
		if (delta / (60) > 0) {
			return delta / (60) + "分钟前";
		}
		return "刚刚";
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
		Date date = format.parse("2017-07-20 16:08:00");
		System.out.println(getFriendlytime(date));
	}

}
