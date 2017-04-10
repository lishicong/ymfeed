<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>CSDN | 错误 jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
html, body {
	margin: 0;
	text-align: center;
	background: #fff;
}

body {
	font-size: 12px;
}

#wrap {
	width: 500px;
	margin: auto;
	text-align: left;
	padding: 20px;
	padding-top: 50px;
}

#logo {
	position: relative;
	width: 90px;
	padding: 65px 0 65px 0;
}

#content {
	position: absolute;
	padding: 20px;
	margin-left: 110px;
	margin-top: -180px;
	height: 140px;
	border-left: solid 1px #999;
}

h2 {
	font-size: 16px;
}

a:link, a:visited, a:hover, a:active {
	text-decoration: none;
	color: #900;
}

a:hover {
	text-decoration: underline;
}

li {
	line-height: 22px;
}
</style>
</head>
<body>
	<div id="wrap">

		<script type="text/javascript">
			var sec = 3;
		</script>

		<div id="logo">
			<img src="http://c.csdn.net/bbs/t/5/i/pic_logo.gif"
				style="border: 0;" width="90" height="50" alt="CSDN Logo" />
		</div>
		<div id="content">
			<h2>噢！在你访问时发生了错误 ！</h2>
			<p>可能是你要访问的页面不存在，请确认再重试。</p>
			<p>你还可以…</p>
			<ul>
				<li><a href="http://www.csdn.net/"
					onclick="history.back();return false;">返回上一页</a></li>
				<li><a id="second" href="http://www.csdn.net/"> <script
							type="text/javascript">
					document.write(sec)
				</script> 秒钟后将返回首页
				</a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		function jump() {
			location.href = getYmFeedRootPath();
		}
		var s = 0;
		function show() {
			s = s + 1;
			if (s > sec)
				return;
			o = document.getElementById('second');
			o.innerHTML = (sec - s) + '秒钟后将会跳转到首页';
		}
		setTimeout('jump()', sec * 1000);
		setInterval('show()', 1000);

		/**
		 * 获取系统根路径
		 */
		function getYmFeedRootPath() {
			// 获取当前网址，如： http://localhost:8080/xxx/xx/x.jsp
			var curWwwPath = window.document.location.href;
			// 获取主机地址之后的目录，如： xxx/xx/x.jsp
			var pathName = window.document.location.pathname;
			var pos = curWwwPath.indexOf(pathName);
			// 获取主机地址，如： http://localhost:8080
			var localhostPaht = curWwwPath.substring(0, pos);
			// 获取带"/"的项目名，如：/xxx
			var projectName = pathName.substring(0, pathName.substr(1).indexOf(
					'/') + 1);
			return (localhostPaht + projectName);
		}
	</script>

</body>
</html>