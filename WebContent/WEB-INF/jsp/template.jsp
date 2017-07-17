<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	var sec = 5; // 停留时间，单位秒
</script>
<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<!-- Post Content Column -->
<div class="col-sm-4">

	<!-- Title -->
	<h3 class="mt-4 ">密码重置成功</h3>
	<hr>

	<blockquote class="blockquote">
		<p>&nbsp;</p>
		<p class="mb-0">您可以使用新密码登录了。</p>
		<p>&nbsp;</p>
		<footer class="blockquote-footer">
			<sapn id="second"> <script type="text/javascript">
				document.write(sec)
			</script></sapn>
			<cite title="Source Title">秒后将会跳转到登录页</cite>
		</footer>
	</blockquote>
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