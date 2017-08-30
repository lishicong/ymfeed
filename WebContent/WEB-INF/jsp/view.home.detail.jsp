<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.h-d-title {
	
}

.h-d-author {
	margin-top: 2rem !important;
	margin-bottom: 7rem !important;
}

@media ( max-width : 767px) {
	.h-d-author {
		margin-top: 0.8rem !important;
		margin-bottom: 4.5rem !important;
	}
}

.h-d-avator {
	width: 48px;
	height: 48px;
}

@media ( max-width : 767px) {
	.h-d-avator {
		width: 36px;
		height: 36px;
	}
}

.h-d-nickname {
	color: #333333;
	font-size: 1.0rem;
	font-weight: 500;
}

@media ( max-width : 767px) {
	.h-d-nickname {
		font-size: 0.9rem;
	}
}

.h-d-time {
	color: #969696;
	font-size: 0.85rem;
}

.h-d-content p {
	color: #333333;
	font-size: 1.1rem;
	line-height: 1.8;
	padding: 0.4rem 0.4rem !important;
}

@media ( max-width : 767px) {
	.h-d-title {
		font-size: 1.4em;
		font-weight: 800;
		line-height: 1.2;
		margin-top: 0.75rem !important;
		margin-bottom: 0.5rem !important;
	}
	.h-d-content p {
		font-size: 1.0rem;
		line-height: 1.6;
		padding: 0.0rem 0.0rem !important;
	}
}

.h-d-advert {
	width: 100%;
	height: 120px;
	object-fit: cover; /* 图片居中截剪*/
}

@media ( max-width : 767px) {
	.h-d-advert {
		height: 80px;
	}
}

/*实现左中右布局*/
.h-d-author-left, .h-d-author-center, .h-d-author-right {
	float: left;
	height: 48px;
}

.h-d-author-left {
	width: 72px;
	line-height: 48px;
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}

@media ( max-width : 767px) {
	.h-d-author-left {
		width: 52px;
	}
}

.h-d-author-center {
	/*width: 600px;*/
	
}

.h-d-author-center .h-d-author-ctop {
	height: 32px;
	line-height: 36px;
}

@media ( max-width : 767px) {
	.h-d-author-center .h-d-author-ctop {
		height: 32px;
		line-height: 38px;
	}
}

.h-d-author-center .h-d-author-cbottom {
	height: 32px;
	line-height: 12px;
}

@media ( max-width : 767px) {
	.h-d-author-center .h-d-author-cbottom {
		height: 32px;
		line-height: 8px;
	}
}

.h-d-author-right {
	width: 64px;
	height: 48px;
	line-height: 48px;
	float: right;
}

.h-d-comment-btn {
	cursor: pointer;
}

.h-d-comment-ta {
	height: 80px;
	background: #f8f8f8;
	color: #8a8a8a;
}

.h-d-comment-cancel {
	margin-top: 6px;
	margin-right: 42px;
	color: #8a8a8a;
	font-size: 1.1rem;
	cursor: pointer;
}

.h-d-comment-avator {
	width: 42px;
	height: 42px;
}

.h-d-comment-nickname {
	color: #000000;
	margin-top: 4px;
	font-size: 1.0rem;
	font-weight: 400;
}

.h-d-comment-content {
	margin-top: 1rem;
}

.h-d-comment-tool {
	margin-top: 1rem;
	float: left;
	font-size: 0.9em;
}

.h-d-comment-icon {
	width: 18px;
	height: 18px;
	margin-bottom: 4px;
	cursor: pointer;
	vertical-align: middle;
}

.h-d-comment-tool-txt {
	margin-left: 1px;
	margin-right: 12px;
	cursor: pointer;
}

.h-d-comment-like {
	color: #8a8a8a;
}

.h-d-comment-unlike {
	color: #8a8a8a;
}

.h-d-comment-reply {
	color: #8a8a8a;
}

.h-d-comment-unreply {
	color: #8a8a8a;
}

.h-d-comment-reply-nickname {
	font-size: 0.75em;
	color: #3194d0;
}

.h-d-comment-reply-content {
	font-size: 0.75em;
}

.h-d-comment-reply-time {
	color: #969696;
	font-size: 0.85rem;
}

.h-d-comment-reply-icon {
	margin-left: 12px;
	margin-right: 2px;
	width: 16px;
	height: 16px;
	margin-bottom: 3px;
	cursor: pointer;
	vertical-align: middle;
}
</style>
<!-- Post Content Column -->
<div class="col-lg-8">

	<!-- Title -->
	<h1 class="mt-5 mb-3 h-d-title">${feedInfo.title}</h1>

	<!-- Author -->
	<div class="h-d-author">
		<div class="h-d-author-left">
			<img
				src="http://img5.imgtn.bdimg.com/it/u=1160111643,2794362200&fm=26&gp=0.jpg"
				class="h-d-avator rounded-circle">
		</div>
		<div class="h-d-author-center">
			<div class="h-d-author-ctop h-d-nickname">思聪</div>
			<div class="h-d-author-cbottom h-d-time">2017.08.02 22:11* 字数</div>
		</div>
		<div class="h-d-author-right">关注</div>
	</div>
	<div class="clearfix"></div>

	<!-- Feed Content -->
	<div class="h-d-content">${feedInfo.content}</div>

	<!-- 推广 -->
	<img class="h-d-advert mb-4"
		src="http://img1.imgtn.bdimg.com/it/u=1794894692,1423685501&fm=26&gp=0.jpg"
		alt="">

	<!-- Comments Form -->
	<div class="media my-5">
		<img class="d-flex mt-1 mr-3 rounded-circle h-d-comment-avator"
			src="http://placehold.it/50x50" alt="">
		<div class="media-body">
			<div class="form-group">
				<textarea id="h-d-comment-textarea-id"
					class="form-control h-d-comment-ta"
					onfocus="if(value=='写下你的评论...'){value=''}"
					onblur="if(value==''){value='写下你的评论...'}">写下你的评论...</textarea>
			</div>
			<div id="h-d-comment-btn">
				<span class="btn btn-danger float-right h-d-comment-btn"
					onclick="javascript:writerCommentFunc();">发送</span> <span
					class="h-d-comment-cancel float-right">取消</span>
			</div>
		</div>
	</div>

	<h5>25条评论</h5>
	<hr class="my-4">

	<div id="v-h-d-comment">
		<!-- Single Comment -->
		<div class="media my-3">
			<img class="d-flex mt-1 mr-3 rounded-circle h-d-comment-avator"
				src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<div class="h-d-comment-nickname">思聪</div>
				<div class="h-d-time">2017.08.02 22:11</div>
				<div class="h-d-comment-content">免运费买了买了！！当时花了两节物理三节数学看完的，当时花了两节物理三节数学看完的，当时花了两节物理三节数学看完的</div>
				<div class="h-d-comment-tool">
					<img class="h-d-comment-icon" src="images/ic_comment_like.png"
						alt=""> <span class="h-d-comment-tool-txt h-d-comment-like">3人赞</span>
					<img class="h-d-comment-icon" src="images/ic_comment_reply.png"
						alt=""> <span class="h-d-comment-tool-txt h-d-comment-reply">回复</span>
				</div>
			</div>
		</div>
		<!-- Comment with nested comments -->
		<div class="media my-3">
			<img class="d-flex mt-1 mr-3 rounded-circle h-d-comment-avator"
				src="http://placehold.it/50x50" alt="">
			<div class="media-body">
				<div class="h-d-comment-nickname">思聪</div>
				<div class="h-d-time">2017.08.02 22:11</div>
				<div class="h-d-comment-content">免运费买了买了！！当时花了两节物理三节数学看完的，当时花了两节物理三节数学看完的，当时花了两节物理三节数学看完的</div>
				<div class="h-d-comment-tool">
					<img class="h-d-comment-icon" src="images/ic_comment_like.png"
						alt=""> <span class="h-d-comment-tool-txt h-d-comment-like">3人赞</span>
					<img class="h-d-comment-icon" src="images/ic_comment_reply.png"
						alt=""> <span class="h-d-comment-tool-txt h-d-comment-reply">回复</span>
				</div>
				<div class="clearfix"></div>
				<blockquote id="v-h-d-comment-reply" class="blockquote my-2">
					<div class="my-3">
						<span class="mt-0 h-d-comment-reply-nickname">托托侠：@苏苏123</span> <span
							class="h-d-comment-reply-content">好喝吗，当时花了两节物理三节数学看完的，当时花了两节物理三节数学看完的</span>
						<div class="mt-1 h-d-comment-reply-time">
							2017.08.02 22:11<img class="h-d-comment-reply-icon"
								src="images/ic_comment_reply.png" alt=""><span
								class="h-d-comment-tool-txt h-d-comment-reply">回复</span>
						</div>
					</div>
					<div class="media my-3">
						<div class="media-body">
							<span class="mt-0 h-d-comment-reply-nickname">托托侠</span> <span
								class="h-d-comment-reply-content">好喝吗，当时花了两节物理三节数学看完的</span>
						</div>
					</div>
					<form id="v-h-d-comment-input" class="my-4">
						<div class="form-group">
							<textarea class="form-control h-d-comment-ta"
								onfocus="if(value=='写下你的评论...'){value=''}"
								onblur="if(value==''){value='写下你的评论...'}">写下你的评论...</textarea>
						</div>
						<button type="submit" class="btn btn-danger float-right">发送</button>
						<span class="h-d-comment-cancel float-right">取消</span>
					</form>
				</blockquote>
			</div>
		</div>
	</div>
</div>

<script>
	/**
	 * 添加一条评论
	 */
	function writerCommentFunc() {
		var fid = "${feedInfo.id}";
		var comment = $("#h-d-comment-textarea-id").val();
		$.ajax({
			type : "post",
			url : "p/data/comment/add",
			data : {
				"fid" : fid,
				"comment" : comment
			},
			dataType : "json",
			success : function(data) {
				$("#v-h-d-comment").prepend(createFeedComment(data));
			},
			error : function(request, textStatus, errorThrown) {
				if (request.getResponseHeader('session') == "null") {
					ymSignInWin();
				}
			}
		});
	}

	/**
	 * 获取feed评论列表
	 */
	function getFeedCommentListFunc() {
		var fid = "${feedInfo.id}";
		$.ajax({
			type : "get",
			url : "data/comment/list?fid=" + fid,
			dataType : "json",
			success : function(data) {
				createFeedCommentHtml(data);
			}
		});
		//createFeedCommentReplayInput();
	}

	/**
	 * 创建评论列表数据
	 */
	function createFeedCommentHtml(data) {
		for (var i = 0; i < data.length; i++) {
			var comment = data[i];
			$("#v-h-d-comment").append(createFeedComment(comment));
		}
	}

	/**
	 * 创建评论列表数据
	 */
	function createFeedComment(data) {
		var div = document.createElement("div");
		div.className = "media my-3";
		div.appendChild(createFeedCommentAvatar("http://placehold.it/50x50"));
		div.appendChild(createFeedCommentInfo(data));
		return div;
	}

	/**
	 * 创建feed评论头像
	 */
	function createFeedCommentAvatar(data) {
		var image = document.createElement("img");
		image.src = data;
		image.className = "d-flex mt-1 mr-3 rounded-circle h-d-comment-avator";
		return image;
	}

	/**
	 * 创建评论信息
	 */
	function createFeedCommentInfo(data) {
		var div = document.createElement("div");
		div.className = "media-body";
		div.appendChild(createFeedCommentNickname("小呀么小二狼"));
		div.appendChild(createFeedCommentTime(data));
		div.appendChild(createFeedCommentContent(data));
		div.appendChild(createFeedCommentTool(data));
		div.appendChild(createFeedCommentClearfix());
		if (data.commentReply != null && data.commentReply.length > 0) {
			div.appendChild(createFeedCommentReplyInfo(data.commentReply));
		}
		return div;
	}

	/**
	 * 创建评论者昵称
	 */
	function createFeedCommentNickname(data) {
		var div = document.createElement("div");
		div.className = "h-d-comment-nickname";
		div.innerHTML = data;
		return div;
	}

	/**
	 * 创建评论时间
	 */
	function createFeedCommentTime(data) {
		var div = document.createElement("div");
		div.className = "h-d-time";
		div.innerHTML = getLocalTime(data.createTime);
		return div;
	}

	/**
	 * 创建评论内容
	 */
	function createFeedCommentContent(data) {
		var div = document.createElement("div");
		div.className = "h-d-comment-content";
		div.innerHTML = data.comment;
		return div;
	}

	/**
	 * 创建评论工具栏
	 */
	function createFeedCommentTool(data) {
		var div = document.createElement("div");
		div.className = "h-d-comment-tool";
		div.appendChild(createFeedCommentToolLike("images/ic_comment_like.png"));
		var likeCount = data.likeCount != null ? data.likeCount : 0;
		div.appendChild(createFeedCommentToolLikeTxt(likeCount + "人赞"));
		div.appendChild(createFeedCommentToolReply("images/ic_comment_reply.png"));
		div.appendChild(createFeedCommentToolReplyTxt());
		return div;
	}

	/**
	 * 创建评论工具栏-赞图
	 */
	function createFeedCommentToolLike(data) {
		var img = document.createElement("img");
		img.className = "h-d-comment-icon";
		img.src = data;
		return img;
	}

	/**
	 * 创建评论工具栏-赞文本
	 */
	function createFeedCommentToolLikeTxt(data) {
		var span = document.createElement("span");
		span.innerHTML = data;
		span.className = "h-d-comment-tool-txt h-d-comment-like";
		return span;
	}

	/**
	 * 创建评论工具栏-回复图
	 */
	function createFeedCommentToolReply(data) {
		var img = document.createElement("img");
		img.className = "h-d-comment-icon";
		img.src = data;
		return img;
	}

	/**
	 * 创建评论工具栏-回复文本
	 */
	function createFeedCommentToolReplyTxt() {
		var span = document.createElement("span");
		span.innerHTML = "回复";
		span.className = "h-d-comment-tool-txt h-d-comment-reply";
		return span;
	}

	/**
	 * clear fix
	 */
	function createFeedCommentClearfix() {
		var div = document.createElement("div");
		div.className = "clearfix";
		return div;
	}

	/**
	 * 创建评论回复信息
	 */
	function createFeedCommentReplyInfo(commentReply) {
		var blockquote = document.createElement("blockquote");
		blockquote.className = "blockquote my-2";
		for (var i = 0; i < commentReply.length; i++) {
			var reply = commentReply[i];
			blockquote.appendChild(createFeedCommentReply(reply));
		}
		return blockquote;
	}

	/**
	 * 创建评论回复
	 */
	function createFeedCommentReply(reply) {
		var div = document.createElement("div");
		div.className = "my-3";
		div.appendChild(createFeedCommentReplayNickname(reply.nickname));
		div.appendChild(createFeedCommentReplayContent(reply.reply));
		div.appendChild(createFeedCommentReplayTime(getLocalTime(reply.createTime)));
		return div;
	}

	/**
	 * 创建评论回复者昵称
	 */
	function createFeedCommentReplayNickname(data) {
		var span = document.createElement("span");
		span.className = "mt-0 h-d-comment-reply-nickname";
		span.innerHTML = data;
		return span;
	}

	/**
	 * 创建评论回复内容
	 */
	function createFeedCommentReplayContent(data) {
		var span = document.createElement("span");
		span.className = "h-d-comment-reply-content";
		span.innerHTML = data;
		return span;
	}

	/**
	 * 创建评论回复时间
	 */
	function createFeedCommentReplayTime(data) {
		var span = document.createElement("div");
		span.className = "mt-1 h-d-comment-reply-time";
		span.innerHTML = data;
		span.appendChild(createFeedCommentReplayIcon("images/ic_comment_reply.png"));
		span.appendChild(createFeedCommentReplayIconTxt());
		return span;
	}

	/**
	 * 创建评论回复ICON
	 */
	function createFeedCommentReplayIcon(data) {
		var img = document.createElement("img");
		img.className = "h-d-comment-reply-icon";
		img.src = data;
		return img;
	}

	/**
	 * 创建评论回复ICON方案
	 */
	function createFeedCommentReplayIconTxt() {
		var span = document.createElement("span");
		span.className = "h-d-comment-tool-txt h-d-comment-reply";
		span.innerHTML = "回复";
		return span;
	}

	/**
	 * 创建评论回复输入框
	 */
	function createFeedCommentReplayInput() {

		$("#v-h-d-comment-reply")
				.append(
						'<form class="my-4"><div class="form-group"><textarea class="form-control h-d-comment-ta" onfocus="if(value==&quot;写下你的评论...&quot;){value=&quot;&quot;}" onblur="if(value==&quot;&quot;){value=&quot;写下你的评论...&quot;}">写下你的评论...</textarea></div><button type="submit" class="btn btn-danger float-right">发送</button><span class="h-d-comment-cancel float-right">取消</span></form>');
	}

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		getFeedCommentListFunc();
	});
</script>

