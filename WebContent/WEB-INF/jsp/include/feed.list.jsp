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
			gotoFeedDetail(id);
		}
	}
	function feedItemClickTitle(id) {
		gotoFeedDetail(id);
		event.cancelBubble = true;
	}

	/**
	 * 进入feed详情
	 */
	function gotoFeedDetail(feedId) {
		openWin('f/' + feedId);
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

			var feedDiv = createFeedDiv(feedinfo.id);

			if (feedinfo.previewImg != null) {
				feedDiv.appendChild(createFeedPreviewImage(feedinfo.previewImg));
			}

			feedDiv
					.appendChild(createFeedHeaderImage("http://img5.imgtn.bdimg.com/it/u=1160111643,2794362200&fm=26&gp=0.jpg"));
			feedDiv.appendChild(createFeedAuthorName(feedinfo.userAccount.nickname));

			feedDiv.appendChild(createFeedCreateTime(feedinfo.publishTime));

			feedDiv.appendChild(createFeedTitle(feedinfo.id, feedinfo.title));

			feedDiv.appendChild(createFeedContent(feedinfo.previewContent));
			feedDiv.appendChild(createFeedTools("电子产品", feedinfo));

			$("#u-home-feed-list").append('<hr>');
			$("#u-home-feed-list").append(feedDiv);
			$("#u-home-feed-list").append('<div class="clearfix"></div>');
		}
	}

	/**
	 * 创建DIV
	 */
	function createFeedDiv(id) {
		var div = document.createElement("div");
		div.className = "mb-4";
		div.onclick = function() {
			feedItemClick(id)
		};
		return div;
	}

	/**
	 * 预览图片
	 */
	function createFeedPreviewImage(data) {
		var image = document.createElement("img");
		image.src = data;
		image.className = "feed-img";
		return image;
	}

	/**
	 * 头像
	 */
	function createFeedHeaderImage(data) {
		var image = document.createElement("img");
		image.src = data;
		image.className = "ym-feed-user-avator rounded-circle";
		return image;
	}

	/**
	 * 作者名
	 */
	function createFeedAuthorName(data) {
		var span = document.createElement("span");
		span.innerHTML = data;
		span.className = "ym-feed-user-name";
		return span;
	}

	/**
	 * 发布时间
	 */
	function createFeedCreateTime(data) {
		var span = document.createElement("span");
		span.innerHTML = data;
		span.className = "feed-datetime ym-text-minor";
		return span;
	}

	/**
	 * 标题
	 */
	function createFeedTitle(id, title) {
		var div = document.createElement("div");
		div.className = "feed-title";
		var a = document.createElement("a");
		a.onclick = function() {
			feedItemClickTitle(id)
		};
		a.className = "ym-title-middle";
		a.innerText = title;
		div.appendChild(a);
		return div;
	}

	/**
	 * 预览内容
	 */
	function createFeedContent(data) {
		var div = document.createElement("div");
		div.className = "feed-content ym-text";
		div.innerHTML = data;
		return div;
	}

	/**
	 * 工具栏
	 */
	function createFeedTools(label, feedinfo) {

		var div = document.createElement("div");
		div.className = "ym-feed-tools ym-text-minor-small";

		var spanLabel = document.createElement("span");
		spanLabel.className = "ym-label-generic ym-feed-label";
		spanLabel.style = "margin-right: 8px;"
		spanLabel.innerHTML = label;

		var span = document.createElement("span");
		span.className = "ym-tools-info";

		var browseCount = feedinfo.browseCount != null ? browseCount : 0;
		var commentCount = feedinfo.commentCount != null ? commentCount : 0;
		var likeCount = feedinfo.likeCount != null ? likeCount : 0;
		span.innerHTML = browseCount + " 浏览 · " + commentCount + " 评论 · " + likeCount + " 喜欢";

		div.appendChild(spanLabel);
		div.appendChild(span);

		return div;
	}
</script>