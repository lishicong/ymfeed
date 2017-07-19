<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	var sec = 10; // 停留时间，单位秒
</script>

<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">激活</h3>
		</div>
		<div class="panel-body">
			<c:if test="${code == 1001}">
				<p class="mt-1" style="color: #444444; font-size: 0.9rem;">
					<span class="text-primary"><strong>${nickname}</strong></span>
					，帐号已成功激活，现在可以使用帐号 <span class="text-primary">${email}</span> 登录了。
				</p>
			</c:if>
			<c:if test="${code != 1001}">
				<p class="mt-1" style="color: #444444; font-size: 0.9rem;">
					帐号激活失败<br>
				<p class="mb-0 text-muted" style="font-size: 0.8rem;">请进入登录页重新发送验证码</p>
				</p>
			</c:if>

			<br>
			<blockquote class="blockquote">
				<footer class="blockquote-footer">
					<sapn id="second"> <script type="text/javascript">
						document.write(sec)
					</script></sapn>
					<cite title="Source Title">秒后将会跳转到登录页</cite>
				</footer>
			</blockquote>
		</div>
	</div>
</div>

<script type="text/javascript">
	function signIn() {
		location.href = "signin";
	}
	var s = 0;
	function showTime() {
		s = s + 1;
		if (s > sec)
			return;
		o = document.getElementById('second');
		o.innerHTML = (sec - s);
	}
	setTimeout('signIn()', sec * 1000);
	setInterval('showTime()', 1000);
</script>