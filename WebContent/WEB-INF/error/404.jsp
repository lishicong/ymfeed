<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
<base href="<%=basePath%>">
<jsp:include page="../jsp/home.meta.jsp" flush="true" />
<title>薅羊毛 | 404</title>

<!-- Common CSS/JS -->
<script type="text/javascript" src="js/raptor-basic.js"></script>
<script type="text/javascript">
	var sec = 50; // 停留时间，单位秒
</script>
</head>
<body>

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-sm-4">
				<!-- 左侧占位 -->
			</div>

			<!-- Post Content Column -->
			<div class="col-sm-4">

				<!-- Title -->
				<h3 class="mt-4 ">您要找的页面不存在</h3>
				<hr>

				<blockquote class="blockquote">
					<p>&nbsp;</p>
					<p class="mb-0">可能是因为您的链接地址有误、该文章已经被作者删除或转为私密状态。</p>
					<p>&nbsp;</p>
					<footer class="blockquote-footer">
						<sapn id="second"> <script type="text/javascript">
							document.write(sec)
						</script></sapn>
						<cite title="Source Title">秒后将会跳转到首页</cite>
					</footer>
				</blockquote>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<script type="text/javascript">
		function goHome() {
			location.href = "index";
		}
		var s = 0;
		function showTime() {
			s = s + 1;
			if (s > sec)
				return;
			o = document.getElementById('second');
			o.innerHTML = (sec - s);
		}
		setTimeout('goHome()', sec * 1000);
		setInterval('showTime()', 1000);
	</script>
</body>
</html>
