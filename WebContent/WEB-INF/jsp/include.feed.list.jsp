<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.ym-home-row {
	
}

.ym-home-row .mb-4 {
	margin-top: 0rem !important;
	margin-bottom: 0.5rem !important;
}

.ym-home-row .feed-item {
	
}

.ym-home-row .feed-img {
	cursor: pointer;
	width: 150px;
	height: 120px;
	float: right;
	margin-top: 38px;
	margin-left: 16px;
	border-radius: 0.25rem;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-img {
		width: 100%;
		height: 120px;
		object-fit: cover; /* 图片居中截剪*/
		float: left;
		margin-top: 10px;
		margin-bottom: 6px;
		margin-left: 0px;
		border-radius: 0rem;
	}
}
/* 用户头像 */
.ym-feed-user-avator {
	margin-left: 10px;
	margin-top: 0px;
}

@media ( max-width : 767px) {
	.ym-feed-user-avator {
		margin-left: 10px;
	}
}

/* 用户昵称 */
.ym-feed-user-name {
	margin-left: 16px;
	line-height: 4rem;
}

@media ( max-width : 767px) {
	.ym-feed-user-name {
		margin-left: 16px;
		line-height: 3rem;
	}
}

.ym-home-row .feed-datetime {
	margin-left: 24px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-datetime {
		margin-left: 12px;
	}
}

.ym-home-row .feed-title {
	cursor: pointer;
	margin-top: 0px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-title {
		margin-top: 0px;
	}
}

.ym-home-row .feed-content {
	margin-top: 16px;
}

@media ( max-width : 767px) {
	.ym-home-row .feed-content {
		margin-top: 8px;
	}
}

.ym-home-row .ym-feed-tools {
	margin-top: 16px;
	margin-bottom: 12px;
	vertical-align: middle;
}

@media ( max-width : 767px) {
	.ym-home-row .ym-feed-tools {
		margin-top: 8px;
		margin-bottom: 8px;
	}
}

.ym-home-row .ym-feed-label {
	padding-left: 6px;
	padding-right: 6px;
	padding-top: 2px;
	padding-bottom: 2px;
	font-size: 0.8rem;
}

.ym-tools-info {
	margin-left: 16px;
}

@media ( max-width : 767px) {
	.ym-tools-info {
		float: right;
		margin-top: 6px;
		margin-right: 16px;
	}
}
</style>

<div id="u-home-feed-list" class="col-sm-7 ym-home-row">
	<!-- feed流 -->
</div>

<script type="text/javascript">
	/**
	 * 每行点击事件
	 */
	function feedItemClick(id) {
		if (!isPC()) {
			alert(id);
		}
	}
	function feedItemClickTitle(id) {
		alert(id);
		event.cancelBubble = true;
		// window.location.href='info/detail/123';
	}

	/**
	 * 创建Feed流数据
	 * 
	 * @param data
	 * @returns
	 */
	function createFeedHtml(data) {
		for (var i = 0; i < data.length; i++) {
			var feedinfo = data[i];
			var item = '<hr />';
			item += '<div class="mb-4" onclick="feedItemClick(' + feedinfo.id + ');">';
			item += createFeedPreviewImage(feedinfo.previewImg);
			//item += createFeedHeaderImage(feedinfo.header);
			item += createFeedHeaderImage("http://img5.imgtn.bdimg.com/it/u=1160111643,2794362200&fm=26&gp=0.jpg");
			item += createFeedAuthorName(feedinfo.userAccount.nickname);
			item += createFeedCreateTime(feedinfo.publishTime);
			item += createFeedTitle(feedinfo.id, feedinfo.title);
			item += createFeedContent(feedinfo.previewContent);
			item += createFeedTools("电子产品", feedinfo.browseCount, feedinfo.commentCount, feedinfo.likeCount);
			item += '</div>';
			item += '<div class="clearfix"></div>';
			$("#u-home-feed-list").append(item);
		}
	}

	/**
	 * 预览图片
	 */
	function createFeedPreviewImage(data) {
		var html = "";
		if (data != null) {
			html += '<image src="' + data + '" class="feed-img" />';
		}
		return html;
	}

	/**
	 * 头像
	 */
	function createFeedHeaderImage(data) {
		var html = '<image src="' + data + '" class="ym-feed-user-avator rounded-circle" />';
		return html;
	}

	/**
	 * 作者名
	 */
	function createFeedAuthorName(data) {
		var html = '<span class="ym-feed-user-name">' + data + '</span>';
		return html;
	}

	/**
	 * 发布时间
	 */
	function createFeedCreateTime(data) {
		var html = '<span class="feed-datetime ym-text-minor">' + data + '</span>';
		return html;
	}

	/**
	 * 标题
	 */
	function createFeedTitle(id, title) {
		var html = '<div class="feed-title">';
		html += '<a onclick="feedItemClickTitle(' + id + ')" class="ym-title-middle">';
		html += title;
		html += "</a>";
		html += "</div>";
		return html;
	}

	/**
	 * 预览内容
	 */
	function createFeedContent(data) {
		var html = '<div class="feed-content ym-text">' + data + '</div>';
		return html;
	}

	/**
	 * 工具栏
	 */
	function createFeedTools(label, browseCount, commentCount, likeCount) {
		var html = '<div class="ym-feed-tools ym-text-minor-small">';
		html += '<span class="ym-label-generic ym-feed-label" style="margin-right: 8px;">' + label + '</span>';
		html += '<span class="ym-tools-info">';
		html += browseCount + " 浏览";
		html += " · " + commentCount + " 评论";
		html += " · " + likeCount + ' 喜欢';
		html += '</span></div>';
		return html;
	}
</script>