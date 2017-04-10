<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.ym-home-row {
	
}

.ym-home-row .mb-4 {
	margin-top: 1.0rem !important;
	margin-bottom: 0.5rem !important;
}

.ym-home-row .feed-item {
	
}

.ym-home-row .feed-img {
	cursor: pointer;
	width: 140px;
	height: 110px;
	float: right;
	margin-top: 50px;
	margin-left: 12px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-img {
		width: 64px;
		height: 64px;
		margin-top: 30px;
	}
}

.ym-home-row .feed-user-header {
	cursor: pointer;
	width: 30px;
	height: 30px;
	margin-left: 4px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-user-header {
		width: 18px;
		height: 18px;
	}
}

.ym-home-row .feed-user-name {
	cursor: pointer;
	margin-left: 10px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-user-name {
		margin-left: 4px;
	}
}

.ym-home-row .feed-datetime {
	margin-left: 10px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-datetime {
		margin-left: 4px;
	}
}

.ym-home-row .feed-title {
	cursor: pointer;
	margin-top: 8px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-title {
		margin-top: 8px;
	}
}

.ym-home-row .feed-content {
	margin-top: 16px;
}

.ym-home-row .ym_label_feed {
	padding-left: 6px;
	padding-right: 6px;
	padding-top: 2px;
	padding-bottom: 2px;
	font-size: 0.8rem;
}

.ym-home-row .feed-tools {
	margin-top: 16px;
	vertical-align: middle;
}

.ym-home-row .feed-tools img {
	width: 16px;
	height: 16px;
	margin-left: 20px;
	margin-right: 4px;
	margin-bottom: 3px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-tools img {
		width: 12px;
		height: 12px;
		margin-left: 10px;
		margin-right: 3px;
		margin-bottom: 3px;
	}
}
</style>

<div id="u-home-feed-list" class="col-sm-7 ym-home-row">
	<!-- feed流 -->
</div>

<script type="text/javascript">
	/**
	 * 
	 */
	function feedItemClick(id) {
		if (!isPC()) {
			alert(id);
		}
	}
	function feedItemClickTitle(id) {
		alert(id);
		event.cancelBubble = true;
		// window.location.href='${pageContext.request.contextPath}/info/detail/123';
	}

	/**
	 * 获取home页feed流列表数据
	 * 
	 * @returns
	 */
	function getFeedListFunc() {
		$.ajax({
			type : "get",
			url : raptor.getRootPath() + "/getFeedList?param=1",
			dataType : "json",
			success : function(data) {
				createFeedHtml(data);
			}
		});
	}

	/**
	 * 创建Feed流数据
	 * 
	 * @param data
	 * @returns
	 */
	function createFeedHtml(data) {
		for (var i = 0; i < data.length; i++) {
			var info = data[i];
			var item = '<div class="mb-4" onclick="feedItemClick(' + info.id + ');">';
			item += createFeedPreviewImage(info.previewImg);
			item += createFeedHeaderImage(info.header);
			item += createFeedAuthorName(info.authorId);
			item += createFeedCreateTime(info.createTime);
			item += createFeedTitle(info.id, info.title);
			item += createFeedContent(info.content);
			item += createFeedTools("电子产品", 1, 2, 3);
			item += '</div>';
			item += '<div class="clearfix"></div>';
			item += '<hr />';
			$("#u-home-feed-list").append(item);
		}
	}

	function createFeedPreviewImage(data) {
		var html = "";
		if (data != null) {
			html += '<image src="' + data + '" class="feed-img rounded" />';
		}
		return html;
	}

	function createFeedHeaderImage(data) {
		var html = '<image src="' + data + '" class="feed-user-header rounded-circle" />';
		return html;
	}

	function createFeedAuthorName(data) {
		var html = '<span class="feed-user-name ym_text">' + data + '</span>';
		return html;
	}

	function createFeedCreateTime(data) {
		var html = '<span class="feed-datetime ym-text-minor">' + data + '</span>';
		return html;
	}

	function createFeedTitle(id, title) {
		var html = '<div class="feed-title">';
		html += '<a onclick="feedItemClickTitle(' + id + ')" class="ym-title-middle">';
		html += title;
		html += "</a>";
		html += "</div>";
		return html;
	}

	function createFeedContent(data) {
		var html = '<div class="feed-content ym-text hidden-sm-down">' + data + '</div>';
		return html;
	}

	function createFeedTools(label, browseCount, commentCount, likeCount) {
		var html = '<div class="feed-tools ym-text-minor-small">';
		html += '<span class="ym-label-generic ym_label_feed" style="margin-right: 8px;">' + label + '</span>';
		html += '<img src="' + raptor.getRootPath() + '/images/ic_feed_browse.png">' + browseCount;
		html += '<img src="' + raptor.getRootPath() + '/images/ic_feed_comment.png">' + commentCount;
		html += '<img src="' + raptor.getRootPath() + '/images/ic_feed_like.png">' + likeCount;
		html += '</div>';
		return html;
	}

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		getFeedListFunc();
	});
</script>