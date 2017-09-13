<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.h-d-navi {
	font-size: 1.2rem;
	padding-left: 9rem;
	padding-right: 3rem;
}

.ym_logo_ic {
	width: 32px;
	height: 32px;
}

.h-d-menu-home {
	position: absolute;
	top: 50%;
	transform: translate(0, -50%);
}

.h-d-menu-item {
	padding: 6px;
	cursor: pointer;
	color: #999999;
	margin-left: 1rem;
	margin-right: 1rem;
}

.h-d-menu-item:hover {
	color: #f17c67;
	text-decoration: none;
}

.h-d-menu-item-active {
	color: #f17c67;
}

.ym_header_write {
	cursor: pointer;
	background: #f05858;
	color: #ffffff;
	text-align: center;
	border-color: #f05858;
	border-radius: 3px;
	padding: 4px;
	width: 120px;
	float: right;
	margin-left: 30px;
	margin-right: 30px;
}
</style>

<!-- Navigation -->
<nav class="navbar d-inline fixed-top bg-light">

	<a class="d-inline" href="#"> <img src="images/logo_200x200.png"
		class="ym_logo_ic" alt="">
	</a>

	<div class="h-d-navi d-none d-md-inline">
		<div id="h-d-menu-id" class="d-inline h-d-menu-home">
			<!-- tab1 -->
			<span class="h-d-menu-item h-d-menu-item-active"
				onclick="ymHeadMenu.tabClick(this);">推荐</span>
			<!-- tab2 -->
			<span id="h-d-menu-like" class="d-none h-d-menu-item"
				onclick="ymHeadMenu.tabClick(this);">关注</span>
			<!-- tab3 -->
			<span id="h-d-menu-msg" class="d-none h-d-menu-item"
				onclick="ymHeadMenu.tabClick(this);">消息&nbsp;<span
				class="badge badge-pill badge-danger"
				style="font-size: 0.7rem; vertical-align: middle; margin-bottom: 5px;">2</span></span>
		</div>

		<!-- 写文章 -->
		<span class="ym_header_write float-right"
			onclick="javascript:headerWriterFunc();">写文章</span>

		<!-- 登录 -->
		<span id="h-d-menu-login" class="d-none h-d-menu-item float-right"
			onclick="javascript:ymSignInWin();">登录/注册</span>
		<!-- 退出 -->
		<a id="h-d-menu-logout" class="d-none h-d-menu-item float-right"
			href="signout">退出</a>
		<!-- 个人中心 -->
		<span id="h-d-menu-account" class="d-none h-d-menu-item float-right"
			onclick="ymHeadMenu.accountClick();">个人中心</span>
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

	var YmHeadMenu = function() {
		var me = this;

		me.init = function() {
		}

		me.tabClick = function(span) {
			$("div#h-d-menu-id span").each(function() {
				$(this).removeClass("h-d-menu-item-active");
			});
			$(span).addClass("h-d-menu-item-active");
		}

		me.nologin = function() {
			$("#h-d-menu-login").removeClass("d-none");
			$("#h-d-menu-login").addClass("d-inline");
		}

		me.logon = function() {
			$("#h-d-menu-like").removeClass("d-none");
			$("#h-d-menu-msg").removeClass("d-none");
			$("#h-d-menu-account").removeClass("d-none");
			$("#h-d-menu-logout").removeClass("d-none");

			$("#h-d-menu-like").addClass("d-inline");
			$("#h-d-menu-msg").addClass("d-inline");
			$("#h-d-menu-account").addClass("d-inline");
			$("#h-d-menu-logout").addClass("d-inline");
		}

		me.init();
		return me;
	}

	var ymHeadMenu = new YmHeadMenu();

	$(function() {
		if (_hasCookie()) {
			ymHeadMenu.logon();
		} else {
			ymHeadMenu.nologin();
		}
	});
</script>

