<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	var _cookie = '${sessionScope["ymfeed-cookie"]}';
	function _hasCookie() {
		return (typeof (_cookie) != "undefined") && (_cookie != null) && (_cookie != "");
	}
	var v = '${sessionScope["JSESSIONID"]}' + " - " + '${sessionScope["ymfeed-remember-me"]}' + " - "
			+ '${sessionScope["ymfeed-cookie"]}';
	//alert(v);
</script>
<meta name="save" content="history">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">