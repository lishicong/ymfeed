package com.sc.ymfeed.common.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public abstract class Mailer {

	private static final String MAIL_HOST = "smtp.126.com"; // 邮件服务主机
	private static final String MAIL_USERNAME = "ymfeed"; // 邮箱账号
	private static final String MAIL_PASSWORD = "ymfeed888899"; // 邮箱密码
	private static final String MAIL_FROM = "ymfeed@126.com"; // 发件人帐号
	private static final String MAIL_PERSONAL = "薅羊毛"; // 发件人

	/**
	 * 创建邮件发送类，用于发送多元化邮件，包括附件，图片，html等
	 */
	private JavaMailSender mimeMailSender;

	/**
	 * 创建多元化邮件
	 */
	private MimeMessage mimeMessage;

	/**
	 * 收件人邮箱
	 */
	private String mailTo;
	/**
	 * 收件人昵称
	 */
	private String nickname;

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public abstract String getSubject();

	public abstract String getContent();

	protected Mailer() {

		mimeMailSender = new JavaMailSenderImpl();
		((JavaMailSenderImpl) mimeMailSender).setHost(MAIL_HOST);
		((JavaMailSenderImpl) mimeMailSender).setUsername(MAIL_USERNAME);
		((JavaMailSenderImpl) mimeMailSender).setPassword(MAIL_PASSWORD);

		// 配置文件，用于实例化java.mail.session
		Properties pro = System.getProperties();

		// 登录SMTP服务器,需要获得授权
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.socketFactory.port", "25");
		pro.put("mail.smtp.socketFactory.fallback", "false");

		((JavaMailSenderImpl) mimeMailSender).setJavaMailProperties(pro);
		mimeMessage = ((JavaMailSenderImpl) mimeMailSender).createMimeMessage();

	}

	public void send() throws MessagingException {

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "GBK");

		try {
			helper.setFrom(MAIL_FROM, MAIL_PERSONAL);
		} catch (UnsupportedEncodingException e) {
			helper.setFrom(MAIL_FROM);
			e.printStackTrace();
		}
		// helper.setTo(getMailTo());
		helper.setTo("lishicong@126.com");// TODO测试使用
		helper.setSubject(getSubject());
		helper.setText(getContent(), true);

		mimeMailSender.send(mimeMessage);
	}

}
