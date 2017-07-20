package com.sc.ymfeed.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static final String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_SHARE = "yyyy.MM.dd";
	public static final String DATE_FORMAT_STANDARD = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String DATE_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public static final String DATE_FORMAT_MMDDHHMMSS = "MMddHHmmss";
	public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
	public static final String DATE_FORMAT_HHMMSS = "HH:mm:ss";
	public static final String DATE_FORMAT_HHMM_CN = "HH点mm分";
	public static final String DATE_FORMAT_HHMM = "HH:mm";
	public static final String DATE_FORMAT_CHINESE_SHORT = "yyyy年M月d日";

	/**
	 * @param time
	 *            时间戳
	 * @param formatter
	 *
	 * @return
	 */
	public static String formatter(long time, String formatter) {

		SimpleDateFormat format = new SimpleDateFormat(formatter, Locale.US);
		return format.format(new Date(time));
	}

	/**
	 * @param date
	 * @param formatter
	 *
	 * @return
	 */
	public static String formatter(Date date, String formatter) {

		SimpleDateFormat format = new SimpleDateFormat(formatter, Locale.US);
		return format.format(date);
	}

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

		Date expiredDate = getPointDate(new Date(), Calendar.DAY_OF_MONTH, -1);
		if (activeDate.before(expiredDate)) {
			return true;
		}
		return false;
	}

	/**
	 * 重置密码验证码是否过期
	 * 
	 * @param sendCodeTime
	 * @return
	 */
	public static boolean isResetPasswordExpired(Date sendCodeTime) {
		Date date = getPointDate(new Date(), Calendar.MINUTE, -10); // 十分钟以前
		if (sendCodeTime.before(date)) {
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
