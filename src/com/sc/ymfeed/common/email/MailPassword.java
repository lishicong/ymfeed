package com.sc.ymfeed.common.email;

public class MailPassword extends Mailer {

	/**
	 * 新的密码
	 */
	private String valideCode;

	public String getValideCode() {
		return valideCode;
	}

	public void setValideCode(String valideCode) {
		this.valideCode = valideCode;
	}

	public String getSubject() {
		return "薅羊毛 | 重置密码";
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
		sbf.append("您正在绑定预留邮箱，请输入验证码：");
		sbf.append("<span style=\"color:#0099cd;font-size:0.9rem;\">");
		sbf.append(getValideCode() + "</span>，以完成操作。</div><br><br>");
		sbf.append("<div style=\"color:#444444;font-size:0.85rem;\">");
		sbf.append("如此次修改非您本人操作，请及时登录网站并修改密码以保证账户安全。(为了保障您帐号的安全性，请在 10分钟内完成修改，此验证码将在您使用过一次后失效！)</div>");
		sbf.append("<br><br>");
		sbf.append("<div style=\"color:#444444;font-size:0.85rem;\">");
		sbf.append("祝您使用愉快！</div>");
		sbf.append("</body>");
		sbf.append("</html>");

		String content = sbf.toString();

		return content;
	}
}
