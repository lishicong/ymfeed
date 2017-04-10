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

.ym_c_h_container {
	padding-right: 0px;
	padding-left: 0px;
}

.ym_ic_logo {
	width: 36px;
	height: 36px;
	margin-right: 4px;
}

.ym_v_align_middle {
	vertical-align: middle;
}

.ym_label_write {
	cursor: pointer;
	background: #f05858;
	color: #ffffff;
	text-align: center;
	border-color: #f05858;
	border-radius: 3px;
	padding-top: 8px;
	width: 100px;
	float: right;
	margin-left: 24px;
}
</style>

<!-- Navigation -->
<nav
	class="navbar fixed-top navbar-toggleable-md navbar-inverse bg-inverse">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarExample"
		aria-controls="navbarExample" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="container ym_c_h_container">
		<img src="${pageContext.request.contextPath}/images/ic_logo.png"
			class="ym_ic_logo"> <a class="navbar-brand ym_v_align_middle"
			href="#">薅羊毛</a>
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
				<li class="nav-item"><a class="nav-link" href="#">登录/注册</a></li>
			</ul>
			<span class="ym_label_write" onclick="javascript:headerWriteFunc();">写文章</span>
		</div>
	</div>
</nav>

<script type="text/javascript">
	function headerWriteFunc() {
		openwin(raptor.getRootPath() + '/uw/editor');
	}
</script>