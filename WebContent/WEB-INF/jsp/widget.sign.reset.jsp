<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	var sec = 10; // 停留时间，单位秒
</script>
<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">重置密码</h3>
		</div>
		<div class="panel-body">
			<p class="mt-1" style="color: #444444; font-size: 0.9rem;">
				<span class="text-primary"><strong>${nickname}</strong></span>
				重置密码成功，您可以使用新密码登录了。
			</p>
			<br>
			<blockquote class="blockquote">
				<p class="mb-0 text-muted" style="font-size: 0.8rem;">为了您的帐号安全，请劳记您的密码并妥善保管。</p>
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