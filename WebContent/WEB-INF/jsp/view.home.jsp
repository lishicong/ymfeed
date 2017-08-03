<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="include/feed.list.jsp" flush="true" />

<script type="text/javascript">
	/**
	 * 获取home页feed流列表数据
	 * 
	 * @returns
	 */
	function getFeedListFunc() {
		$.ajax({
			type : "get",
			url : "data/feed/home?param=1",
			dataType : "json",
			success : function(data) {
				createFeedHtml(data);
			}
		});
	}

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		getFeedListFunc();
	});
</script>