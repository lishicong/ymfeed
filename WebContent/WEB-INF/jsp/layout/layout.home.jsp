<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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

<tiles:insertAttribute name="meta" />
<base href="<%=basePath%>">
<title><tiles:insertAttribute name="title" /></title>

<!-- Common CSS/JS -->
<script type="text/javascript" src="js/raptor-basic.js"></script>
</head>

<body>

	<!-- 头部 -->
	<tiles:insertAttribute name="header" />

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-sm-1">
				<!-- 左侧占位 -->
			</div>
			<!-- 广告 -->
			<tiles:insertAttribute name="advert" />
			<div class="col-sm-1">
				<!-- 右侧占位 -->
			</div>
		</div>
		<div class="row">
			<div class="col-sm-1">
				<!-- 左侧占位 -->
			</div>

			<!-- body -->
			<tiles:insertAttribute name="body" />

			<!-- 右部公共菜单 -->
			<tiles:insertAttribute name="menu" />

			<div class="col-sm-1">
				<!-- 右侧占位 -->
			</div>
		</div>
	</div>

	<!-- 底部 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>