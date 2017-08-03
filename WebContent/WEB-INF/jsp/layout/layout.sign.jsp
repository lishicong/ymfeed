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

<style type="text/css">
body {
	background: #f8f8f8;
}
</style>

</head>

<body>

	<tiles:insertAttribute name="header" />

	<div id="sign-body" class="container">
		<div class="row">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
</html>
