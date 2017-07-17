<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
</style>

<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">激活</h3>
		</div>
		<div class="panel-body">
			<p class="mt-1" style="color: #444444; font-size: 0.9rem;">
				<span class="text-primary"><strong>${nickname}</strong></span>
				，已发送验证邮件到 <span class="text-primary">${email}</span>
				，请立即点击验证链接激活账号，激活后您可以正常登录网站
			</p>
			<br>
			<blockquote class="blockquote">
				<p class="mb-0 text-muted" style="font-size: 0.8rem;">验证邮件24小时内有效，请尽快登录您的邮箱点击验证链接完成验证。若未收到邮件请先确认是否在垃圾邮件中，如果一直未收到验证邮件您可以通过ymfeed#126.com(#请替换成@）反馈我们。</p>
				<footer class="blockquote-footer">
					<span id="send_message" class="text-success"
						style="font-size: 0.8rem; margin-left: 8px;"></span>
				</footer>
			</blockquote>
			<br> <input type="hidden" id="nickname" value="${nickname}" />
			<input type="hidden" id="email" value="${email}" />
			<!-- Change this to a button or input when using this as a form -->
			<input id="resend" type="submit"
				class="btn btn-lg btn-danger btn-block"
				onclick="javascript:sendMail();return;" value="重新发送" />
		</div>
	</div>
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