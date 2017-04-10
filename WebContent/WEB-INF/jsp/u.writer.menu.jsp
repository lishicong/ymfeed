<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/simple-sidebar.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/u.writer.menu.js"></script>
<style type="text/css">
.ym-writer-top {
	width: 100%;
	text-align: center;
	margin-top: 32px;
	margin-bottom: 32px;
}

.ym-writer-gohome {
	padding-left: 32px;
	padding-right: 32px;
	padding-top: 6px;
	padding-bottom: 6px;
}
</style>
<!-- Sidebar -->
<div id="sidebar-wrapper">
	<ul class="sidebar-nav">
		<div class="ym-writer-top">
			<span class="ym-button-generic ym-writer-gohome"
				onclick="just2Home();"> 回首页 </span>
		</div>
		<li class="sidebar-brand"><a href="#">写文章</a></li>
		<li><a href="#">已发布</a></li>
		<li><a href="#">未发布</a></li>
		<li><a href="#">回收站</a></li>
	</ul>
</div>

<script type="text/javascript">
	function just2Home() {
		openwin(raptor.getRootPath() + '/');
	}

	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		$("#wrapper").toggleClass("toggled");
	});

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		$("#wrapper").toggleClass("toggled");

		$('#sidebar-wrapper li').click(function() {
			$('.active').removeClass('active');
			$(this).addClass("active");
			$('.sidebar-brand').removeClass('sidebar-brand');
			$(this).addClass("sidebar-brand");
		});
	});
</script>

