package com.sc.ymfeed.common.email;

public class MailActive extends Mailer {

	/**
	 * 激活的URL
	 */
	private String activeUrl;

	public String getActiveUrl() {
		return activeUrl;
	}

	public void setActiveUrl(String activeUrl) {
		this.activeUrl = activeUrl;
	}

	public String getSubject() {
		return "薅羊毛 | 邮箱激活";
	}

	@Override
	public String getContent() {

		StringBuffer sbf = new StringBuffer();

		sbf.append("<html>");
		sbf.append("<head>");
		sbf.append("<meta http-equiv=Content-Type content=text/html; charset=gb2312>");
		sbf.append("</head>");

		sbf.append("<body>");
		sbf.append("<div style=\"color:#ff7f00;font-size:1.1rem;\">");
		sbf.append("亲爱的 " + getNickname() + ", 您好!</div><br>");
		sbf.append("<div style=\"color:#444444;font-size:0.85rem;\">");
		sbf.append("您距离成功注册账号只差一步了，点击链接完成激活，开启您的薅羊毛之旅！</div><br>");
		sbf.append("<div style=\"color:#0099cd;font-size:0.9rem;\">");
		sbf.append("<a href='" + getActiveUrl() + "'>" + getActiveUrl() + "</a></div><br>");
		sbf.append("<div style=\"color:#444444;font-size:0.85rem;\">");
		sbf.append("如果链接无法点击，请复制上面的地址，并粘贴到浏览器的地址栏中访问。(为了保障您帐号的安全性，请在 48小时内完成激活，此链接将在您激活过一次后失效！)</div>");
		sbf.append("<br><br>");
		sbf.append("<div style=\"color:#444444;font-size:0.85rem;\">");
		sbf.append("祝您使用愉快！</div>");
		sbf.append("</body>");
		sbf.append("</html>");

		String content = sbf.toString();

		return content;
	}

}
