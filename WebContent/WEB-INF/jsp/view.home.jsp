<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="css/feedLoading.css" rel="stylesheet" />
<div class="col-sm-7">
	<jsp:include page="include/feed.list.jsp" flush="true" />

	<div class="notes-placeholder ">
		<div class="img"></div>
		<div class="content">
			<div class="author">
				<div class="avatar"></div>
				<div class="name"></div>
			</div>
			<div class="title"></div>
			<div class="text"></div>
			<div class="text animation-delay"></div>
			<div class="text short-text"></div>
			<div class="meta">
				<div class="tag"></div>
				<i class="iconfont ic-list-read"></i>
				<div class="read"></div>
				<i class="iconfont ic-list-comments"></i>
				<div class="small"></div>
				<i class="iconfont ic-list-like"></i>
				<div class="small"></div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var currentPage = 1; // 当前页
	var isLoadingMore = false; // 是否正在加载更多
	var noMore = false; //是否没有更多
	/**
	 * 获取home页feed流列表数据
	 * 
	 * @returns
	 */
	function getFeedListFunc(page) {
		isLoadingMore = true;
		$.ajax({
			type : "get",
			url : "data/feed/home?label=all&page=" + page,
			dataType : "json",
			success : function(data) {
				createFeedHtml(data);
				if (data == "") {
					noMore = true;
				}
				finishLoadMore(true);
			},
			error : function(request, textStatus, errorThrown) {
				finishLoadMore(false);
			}
		});
	}

	/**
	 * 完成加载更多
	 */
	function finishLoadMore(isSuccess) {
		isLoadingMore = false;
		if (isSuccess) {
			currentPage = currentPage + 1;
		}
	}

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		getFeedListFunc(currentPage);

		$(window).scroll(function() {

			if ($(document).scrollTop() <= 0) {
				// 滚动到顶部
			}

			if ($(document).scrollTop() + 200 >= $(document).height() - $(window).height()) {
				// 滚动到底部
				if (!isLoadingMore && !noMore) {
					getFeedListFunc(currentPage);
				}
			}
		});
	});
</script>