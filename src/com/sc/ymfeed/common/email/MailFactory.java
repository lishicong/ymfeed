package com.sc.ymfeed.common.email;

public class MailFactory {

	private MailFactory() {
	}

	public static Mailer createMailer(MailType mailType) {
		switch (mailType) {
		case MAIL_ACTIVE:
			return new MailActive();
		case MAIL_PASSWORD:
			return new MailValidateCode();
		default:
			return null;
		}
	}

}
