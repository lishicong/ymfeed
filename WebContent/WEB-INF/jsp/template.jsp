<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.mt-5 {
	margin-top: 8rem !important;
}

@media ( max-width : 767px) {
	.mt-5 {
		margin-top: 3rem !important;
	}
}

.blockquote {
	font-size: 1rem;
}
</style>
<div class="col-sm-2">
	<!-- 左侧占位 -->
</div>

<!-- Post Content Column -->
<div class="col-sm-8">

	<!-- Title -->
	<p class="mt-5" style="color: #444444; font-size: 1.0rem;">
		<span class="text-primary"><strong>${nickname}</strong></span>
		，已发送验证邮件到 <span class="text-primary">${email}</span>
		，请立即点击验证链接激活账号，激活后您可以正常登录网站
	</p>
	<hr>

	<blockquote class="blockquote">
		<p>&nbsp;</p>
		<p class="mb-0 text-muted" style="font-size: 0.8rem;">验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证。若未收到邮件请先确认是否在垃圾邮件中，如果一直未收到验证邮件您可以通过ymfeed#126.com(#请替换成@）反馈我们。</p>
		<p>&nbsp;</p>
		<footer class="blockquote-footer">
			<input id="resend" type="submit" class="btn btn-sm btn-danger"
				style="width: 120px;" onclick="javascript:sendMail();return;"
				value="重新发送" /> <span id="send_message" class="text-muted"
				style="font-size: 0.8rem; margin-left: 8px;"></span>
		</footer>
	</blockquote>

	<input type="hidden" id="nickname" value="${nickname}" /> <input
		type="hidden" id="email" value="${email}" />
</div>

<script type="text/javascript">
	var sec = 30; // 停留时间，单位秒
	var s = 0;
	function showTime() {
		$('#resend').attr("disabled", true);
		if (s > sec - 1) {
			$("#send_message").html("");
			$('#resend').val("重新发送");
			$('#resend').attr("disabled", false);
			return;
		}
		$('#resend').val((sec - s) + "秒后重新发送");
		s = s + 1;
	}

	/**
	 * 发送激活邮件
	 */
	function sendMail() {

		// 每次发送前初使化数据
		s = 0;

		setInterval('showTime()', 1000);

		$.ajax({
			type : "post",
			url : "data/sign/reactive",
			data : {
				"nickname" : $("#nickname").val(),
				"email" : $("#email").val()
			},
			dataType : "json",
			success : function(data) {
				if (data.code == 1001) {
					$("#send_message").html("激活邮件已发送");
				} else {
					$("#send_message").html(data.msg);
				}
			}
		});
	}
	/**
	 * 页面加载完成后加载
	 */
	$(function() {
		sendMail();
	});
</script>