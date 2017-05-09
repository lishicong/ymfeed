package com.sc.ymfeed.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取指定时间点的时间
	 * 
	 * @param date
	 * @param calendarType
	 * @param num
	 * @return
	 */
	public static Date getPointDate(Date date, int calendarType, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendarType, num);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 激活时间是否过期
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isActiveExpired(String activeTime) {

		long lTime = Long.valueOf(activeTime);
		Date activeDate = new Date(lTime);

		Date expiredDate = getPointDate(new Date(), Calendar.DAY_OF_MONTH, -2);
		if (activeDate.before(expiredDate)) {
			return true;
		}
		return false;
	}

	/**
	 * 发送邮件的间隔时间比较
	 * 
	 * @param d
	 * @return
	 */
	public static boolean isAllowSendMail(Date d) {

		Date date = getPointDate(new Date(), Calendar.MINUTE, -1); // 一分钟以前
		if (d.before(date)) {
			return true;
		}
		return false;
	}

}
