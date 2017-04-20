package com.sc.ymfeed.common.cookie;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.sc.ymfeed.mybatis.dto.UserAccount;
import com.sc.ymfeed.mybatis.dto.UserPersistent;

public class CookieInfo {

	private String email;
	private String series; // UUID值
	private String token; // sha256加密用户信息
	private Date validTime; // 过期时间
	private String cookieValue; // Cookie值

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getValidTime() {
		return validTime;
	}

	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	public CookieInfo() {

	}

	public CookieInfo(UserAccount userAccount) {

		series = UUID.randomUUID().toString();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1); // 1个月有效期

		StringBuffer time = new StringBuffer();// 精确到分的时间字符串
		time.append(calendar.get(Calendar.YEAR)).append("-");
		time.append(calendar.get(Calendar.MONTH)).append("-");
		time.append(calendar.get(Calendar.DAY_OF_MONTH)).append("-");
		time.append(calendar.get(Calendar.HOUR_OF_DAY)).append("-");
		time.append(calendar.get(Calendar.MINUTE));

		token = EncryptionUtil.sha256Hex(userAccount.getEmail() + "_" + userAccount.getPassword() + "_"
				+ time.toString() + "_" + CookieConstant.SALT);

		validTime = calendar.getTime();

		cookieValue = createCookieValue(userAccount.getEmail(), series); // Cookie值
	}

	public void createAuthToken(UserAccount userAccount, UserPersistent userPersistent) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(userPersistent.getValidTime());

		StringBuffer time = new StringBuffer();// 精确到分的时间字符串
		time.append(calendar.get(Calendar.YEAR)).append("-");
		time.append(calendar.get(Calendar.MONTH)).append("-");
		time.append(calendar.get(Calendar.DAY_OF_MONTH)).append("-");
		time.append(calendar.get(Calendar.HOUR_OF_DAY)).append("-");
		time.append(calendar.get(Calendar.MINUTE));

		token = EncryptionUtil.sha256Hex(userAccount.getEmail() + "_" + userAccount.getPassword() + "_"
				+ time.toString() + "_" + CookieConstant.SALT);
	}

	/**
	 * 根据邮箱和UUID生成cookieValue
	 * 
	 * @param eamil
	 * @param series
	 *            UUID
	 * @return
	 */
	public static String createCookieValue(String eamil, String series) {
		return EncryptionUtil.base64Encode(eamil + ":" + series);
	}

}
