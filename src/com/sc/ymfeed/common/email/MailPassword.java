package com.sc.ymfeed.common.email;

public class MailPassword extends Mailer {

	/**
	 * 新的密码
	 */
	private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getSubject() {
		return "薅羊毛 | 找回密码";
	}

	@Override
	public String getContent() {
		return "<html><head><meta http-equiv=" + "Content-Type" + " content=" + "text/html; charset=gb2312"
				+ "></head><body><h1>密码</h1>你的新书快递申请已推送新书，请到<a href=''>空间"
				+ "</a>中查看<br><img src='cid:myPicture'></body></html>";
	}
}
