<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
.navbar-toggler {
	z-index: 1;
}

@media ( max-width : 767px) {
	nav>.container {
		width: 100%;
	}
}

.ym_logo {
	width: 146px;
}

.ym_logo_ic {
	width: 36px;
	height: 36px;
	margin-left: 12px;
}

@media ( max-width : 767px) {
	.ym_logo_ic {
		margin-left: 0px;
	}
}

.ym_logo_title {
	font-size: 1.25rem;
	white-space: nowrap;
	color: white;
	vertical-align: middle;
}

.ym_logo_title:focus, .ym_logo_title:hover {
	text-decoration: none;
	color: white;
}

.ym_header_write {
	cursor: pointer;
	background: #f05858;
	color: #ffffff;
	text-align: center;
	border-color: #f05858;
	border-radius: 3px;
	padding-top: 8px;
	width: 120px;
	float: right;
	margin-left: 30px;
}
</style>

<!-- Navigation -->
<nav
	class="navbar fixed-top navbar-toggleable-md navbar-inverse bg-inverse">

	<!-- header -->
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarExample"
		aria-controls="navbarExample" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- logo -->
	<div class="ym_logo">
		<img src="images/ic_logo.png" class="ym_logo_ic"> <a
			class="ym_logo_title" href="index">薅羊毛</a>
	</div>

	<!-- menu -->
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="nav navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">热门
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">精选</a></li>
				<li class="nav-item"><a class="nav-link" href="#">消息</a></li>
				<li class="nav-item"><a class="nav-link" href="#">我的</a></li>
			</ul>
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#">APP下载</a></li>
				<li class="nav-item"><a class="nav-link"
					href="javascript:ymSignInWin();">登录/注册</a></li>
			</ul>
			<span class="ym_header_write"
				onclick="javascript:headerWriterFunc();">写文章</span>
		</div>
	</div>
</nav>

<script type="text/javascript">
	function headerWriterFunc() {
		openWin('p/writer');
	}
</script>