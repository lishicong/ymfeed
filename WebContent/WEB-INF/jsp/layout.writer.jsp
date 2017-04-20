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
	padding-top: 0px;
}

@media ( max-width : 767px) {
	body {
		padding-top: 0px;
	}
}
</style>

</head>

<body>
	<div id="wrapper">

		<tiles:insertAttribute name="menu" />

		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<tiles:insertAttribute name="body" />

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
