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
<jsp:include page="../jsp/common/home.meta.jsp" flush="true" />
<title>薅羊毛 | 404</title>

<!-- Common CSS/JS -->
<script type="text/javascript" src="js/raptor-basic.js"></script>
<script type="text/javascript">
	var sec = 10; // 停留时间，单位秒
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

			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">404</h3>
					</div>
					<div class="panel-body">
						<p class="mt-1" style="color: #444444; font-size: 0.9rem;">
							<strong>您要找的页面不存在</strong>
						</p>
						<br>
						<blockquote class="blockquote">
							<p class="mb-0 text-muted" style="font-size: 0.8rem;">可能是因为您的链接地址有误、该文章已经被作者删除或转为私密状态。</p>
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
