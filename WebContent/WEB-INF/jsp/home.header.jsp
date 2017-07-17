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
	font-weight: bold;
	font-size: 1.2rem;
	color: #000000;
	vertical-align: middle;
}

.ym_logo_title:focus, .ym_logo_title:hover {
	text-decoration: none;
	color: #000000;
}

.navbar-toggler {
	padding: 0.16rem 0.75rem;
}

.ym_header_write {
	cursor: pointer;
	background: #f05858;
	color: #ffffff;
	text-align: center;
	border-color: #f05858;
	border-radius: 3px;
	padding-top: 4px;
	width: 120px;
	float: right;
	margin-left: 30px;
}

.nav-item {
	margin-right: 2em;
}

@media ( max-width : 767px) {
	.nav-item {
		margin-top: 0.3em;
		margin-bottom: 0.3em;
		margin-left: 2.5em;
	}
}

.nav-link {
	font-weight: 500;
	font-size: 1.2rem;
	padding: 0.2em 0em 0em 0em;
}

.navbar-inverse .navbar-nav .nav-link {
	color: rgba(255, 255, 255, 0.75);
}

.navbar-inverse .navbar-nav .nav-link:focus, .navbar-inverse .navbar-nav .nav-link:hover
	{
	color: rgba(255, 255, 255, 0.1);
}
</style>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-toggleable-md navbar-light bg-faded">

	<!-- header -->
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarExample"
		aria-controls="navbarExample" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- logo -->
	<div class="ym_logo">
		<img src="images/logo_200x200.png" class="ym_logo_ic"> <a
			class="ym_logo_title" href="index">薅羊毛</a>
	</div>

	<!-- menu -->
	<div class="container">
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="nav navbar-nav" id="navbar_tab">
			</ul>
			<ul class="nav navbar-nav ml-auto" id="navbar_login">
			</ul>
			<span class="ym_header_write hidden-sm-down"
				onclick="javascript:headerWriterFunc();">写文章</span>
		</div>
	</div>
</nav>

<script type="text/javascript">
	/**
	 * 退出登录
	 */
	function singOut() {
		$.ajax({
			type : "post",
			url : "data/sign/out",
			dataType : "json",
			success : function(data) {
				alert(data);
			}
		});
	}
	/**
	 * 写笔记
	 */
	function headerWriterFunc() {
		openWin('p/writer');
	}
	/**
	 * 打开用户菜单
	 */
	function openUserMenu() {
		singOut();
	}
	/**
	 * 导航栏推荐点击事件
	 */
	function navRecommendTabClick(obj) {
		document.getElementById("nav_recommend").className = "nav-item active";
		document.getElementById("nav_follow").className = "nav-item";
		document.getElementById("nav_message").className = "nav-item";
		alert("recommend");
	}
	function navFollowTabClick() {
		document.getElementById("nav_recommend").className = "nav-item";
		document.getElementById("nav_follow").className = "nav-item active";
		document.getElementById("nav_message").className = "nav-item";
		alert("follow");
	}
	function navMessageTabClick() {
		document.getElementById("nav_recommend").className = "nav-item";
		document.getElementById("nav_follow").className = "nav-item";
		document.getElementById("nav_message").className = "nav-item active";
		alert("message");
	}
	$(function() {

		var tabHtml = '<div class="dropdown-divider hidden-lg-up"></div>';
		var loginHtml = '<div class="dropdown-divider hidden-lg-up"></div>';

		if (_hasCookie()) {

			tabHtml += '<li id="nav_recommend" class="nav-item active">';
			tabHtml += '<a class="nav-link" href="javascript:navRecommendTabClick();">推荐</a>';
			tabHtml += '</li>';
			tabHtml += '<div class="dropdown-divider hidden-lg-up"></div>';

			tabHtml += '<li id="nav_follow" class="nav-item">';
			tabHtml += '<a class="nav-link" href="javascript:navFollowTabClick();">关注</a>';
			tabHtml += '</li>';
			tabHtml += '<div class="dropdown-divider hidden-lg-up"></div>';

			tabHtml += '<li id="nav_message" class="nav-item">';
			tabHtml += '<a class="nav-link" href="javascript:navMessageTabClick();">';
			tabHtml += '消息&nbsp;<span class="badge badge-pill badge-danger" style="font-size: 0.7rem;vertical-align: middle; margin-bottom:5px;">2</span>';
			tabHtml += '</a>';
			tabHtml += '</li>';

			loginHtml += '<li class="nav-item"><a class="nav-link" href="#">个人中心</a></li>';
			loginHtml += '<div class="dropdown-divider hidden-lg-up"></div>';
			loginHtml += '<li class="nav-item"><a class="nav-link" href="signout">退出</a></li>';
		} else {
			tabHtml += '<li class="nav-item active"><a class="nav-link" href="#">首页</a></li>';

			loginHtml += '<li class="nav-item"><a class="nav-link" href="javascript:ymSignInWin();">登录/注册</a></li>';
		}

		loginHtml += '<div class="dropdown-divider hidden-lg-up"></div>';
		loginHtml += '<a href="" class="btn btn-lg btn-info hidden-lg-up">下载手机APP</a>';

		$('#navbar_tab').append(tabHtml);
		$('#navbar_login').append(loginHtml);
	});
</script>