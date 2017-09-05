<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.blockquote {
	margin: 0 0 0 0;
	padding: 0 0 0 1rem;
}

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
		<!-- comment -->
	</div>
</div>

<script>
	// ------------------------------------------- comment -------------------------------------------
	/**
	 * 创建评论列表数据
	 */
	var YmfeedComment = function(comment) {
		var me = this;

		var commentBody;

		var imageCommentAvatar; // 评论者头像
		var divCommentNickname; // 评论者昵称
		var divCommentCreateTime; // 评论时间
		var divCommentContent; // 评论时间

		var divCommentTool; // 评论工具
		var imageLike; // 评论点赞图片
		var spanLike; // 评论点赞文本
		var imageReply; // 评论回复图片
		var aReply; // 评论回复文本

		var blockquoteReply; // 评论回复

		me.init = function() {

			// 创建feed评论头像
			imageCommentAvatar = document.createElement("img");
			imageCommentAvatar.src = comment.avatar;
			imageCommentAvatar.className = "d-flex mt-1 mr-3 rounded-circle h-d-comment-avator";

			var commentContent = document.createElement("div");
			commentContent.className = "media-body";

			me.initComment();
			me.initCommentTool();
			me.initReply();

			commentContent.appendChild(divCommentNickname);
			commentContent.appendChild(divCommentCreateTime);
			commentContent.appendChild(divCommentContent);
			commentContent.appendChild(divCommentTool);

			commentContent.appendChild(me.clearFix());
			commentContent.appendChild(blockquoteReply);

			commentBody = document.createElement("div");
			commentBody.className = "media panel my-3";
			commentBody.appendChild(imageCommentAvatar);
			commentBody.appendChild(commentContent);
		}

		me.initComment = function() {
			// 创建feed评论昵称
			divCommentNickname = document.createElement("div");
			divCommentNickname.className = "h-d-comment-nickname";
			divCommentNickname.innerHTML = comment.userAccount.nickname;
			// 创建评论时间
			divCommentCreateTime = document.createElement("div");
			divCommentCreateTime.className = "h-d-time";
			divCommentCreateTime.innerHTML = getLocalTime(comment.createTime);
			// 创建评论内容
			divCommentContent = document.createElement("div");
			divCommentContent.className = "h-d-comment-content";
			divCommentContent.innerHTML = comment.comment;
		}

		me.initCommentTool = function() {
			// 创建评论工具栏-赞图
			imageLike = document.createElement("img");
			imageLike.className = "h-d-comment-icon";
			imageLike.src = "images/ic_comment_like.png";

			// 创建评论工具栏-赞文本
			//var likeCount = data.likeCount != null ? data.likeCount : 0;
			spanLike = document.createElement("span");
			spanLike.innerHTML = comment.likeCount != null ? comment.likeCount : 0 + "人赞";
			spanLike.className = "h-d-comment-tool-txt h-d-comment-like";

			// 创建评论工具栏-回复图
			imageReply = document.createElement("img");
			imageReply.className = "h-d-comment-icon";
			imageReply.src = "images/ic_comment_reply.png";
			imageReply.onclick = function() {
				alert("回复1");
			}

			// 创建评论工具栏-回复文本
			aReply = document.createElement("a");
			aReply.className = "h-d-comment-tool-txt h-d-comment-reply";
			aReply.innerText = "回复";
			aReply.onclick = function() {
				if ($("#comment-reply-input-" + comment.id).css("display") == "none") {
					$("#comment-reply-input-" + comment.id).fadeIn(300);
				} else {
					$("#comment-reply-input-" + comment.id).fadeOut(300);
				}
			}

			divCommentTool = document.createElement("div");
			divCommentTool.className = "h-d-comment-tool";
			divCommentTool.appendChild(imageLike);
			divCommentTool.appendChild(spanLike);
			divCommentTool.appendChild(imageReply);
			divCommentTool.appendChild(aReply);
		}

		me.initReply = function() {
			blockquoteReply = document.createElement("blockquote");
			blockquoteReply.id = "comment-" + comment.id;
			blockquoteReply.className = "blockquote";
			var input = new YmfeedInput(comment.id, comment.userAccountId, comment.userAccount.nickname);
			blockquoteReply.appendChild(input);
		}

		me.clearFix = function() {
			var div = document.createElement("div");
			div.className = "clearfix";
			return div;
		}

		me.init();

		return commentBody;
	}

	// ------------------------------------------- reply -------------------------------------------
	var YmfeedReply = function(reply) {
		var me = this;

		var replyBody;

		var spanReplyNickname; // 评论回复者昵称
		var spanReplyContent; // 评论回复内容
		var imageReplyIcon; // 评论回复icon
		var aReplyIconText; // 评论回复icon文本
		var divReplyTool;

		me.init = function() {
			// 评论回复者昵称
			spanReplyNickname = document.createElement("span");
			spanReplyNickname.className = "mr-1 h-d-comment-reply-nickname";
			spanReplyNickname.innerHTML = reply.nickname;
			// 评论回复者内容
			spanReplyContent = document.createElement("span");
			spanReplyContent.className = "h-d-comment-reply-content";
			spanReplyContent.innerHTML = reply.reply;

			// 评论回复ICON
			imageReplyIcon = document.createElement("img");
			imageReplyIcon.className = "h-d-comment-reply-icon";
			imageReplyIcon.src = "images/ic_comment_reply.png";
			// 评论回复文本
			aReplyIconText = document.createElement("a");
			aReplyIconText.className = "h-d-comment-tool-txt h-d-comment-reply";
			aReplyIconText.dataset.parent = "#v-h-d-comment";
			aReplyIconText.innerHTML = "回复";

			divReplyTool = document.createElement("div");
			divReplyTool.className = "mt-1 h-d-comment-reply-time";
			divReplyTool.innerHTML = getLocalTime(reply.createTime);

			divReplyTool.append(imageReplyIcon);
			divReplyTool.append(aReplyIconText);

			replyBody = document.createElement("div");
			replyBody.className = "my-3";
			replyBody.append(spanReplyNickname);
			replyBody.append(spanReplyContent);
			replyBody.append(divReplyTool);
		}

		me.init();

		return replyBody;
	}
	// ------------------------------------------- input -------------------------------------------
	/**
	 * 评论回复输入组件
	 */
	var YmfeedInput = function(commentId, userAccountId, nickname) {
		var me = this;

		var inputBody;

		var textareaContent; // 输入框
		var buttonSubmit; // 提交按钮
		var buttonCancel; // 取消按钮

		me.init = function() {

			// ---------------------------------------------------
			textareaContent = document.createElement("textarea");
			textareaContent.className = "form-control h-d-comment-ta";
			textareaContent.onfocus = function() {
				if (this.value == '写下你的评论...') {
					this.value = ''
				}
			};
			textareaContent.onblur = function() {
				if (this.value == '') {
					this.value = '写下你的评论...'
				}
			};
			textareaContent.innerHTML = "写下你的评论...";

			// ---------------------------------------------------
			buttonSubmit = document.createElement("button");
			buttonSubmit.className = "btn btn-danger float-right";
			buttonSubmit.onclick = function() {
				//alert(commentId + "," + userAccountId + "," + nickname);
				me.createReplyFunc(commentId, userAccountId);
			}
			buttonSubmit.innerHTML = "发送";

			// ---------------------------------------------------
			buttonCancel = document.createElement("span");
			buttonCancel.className = "h-d-comment-cancel float-right";
			buttonCancel.innerHTML = "取消";

			// ---------------------------------------------------
			inputBody = document.createElement("div");
			inputBody.id = "comment-reply-input-" + commentId;
			inputBody.style.display = "none";
			inputBody.appendChild(textareaContent);
			inputBody.appendChild(buttonSubmit);
			inputBody.appendChild(buttonCancel);
		}

		/**
		 * 写一条评论
		 */
		me.createReplyFunc = function(commentId, userAccountId) {

			var reply = textareaContent.value;
			var fid = "${feedInfo.id}";

			var w = window.open();

			$.ajax({
				type : "post",
				url : "p/data/reply/add",
				data : {
					"reply" : reply,
					"replyToUserAccountId" : userAccountId,
					"feedInfoId" : fid,
					"feedCommentId" : commentId
				},
				dataType : "json",
				success : function(data) {
					alert(data.reply);
					w.close();
				},
				error : function(request, textStatus, errorThrown) {
					if (request.getResponseHeader('session') == "null") {
						w.location = "signin";
					} else {
						w.close();
					}
				}
			});
		}

		me.init();

		return inputBody;
	}
	// --------------------------------------------------------------------------------

	// ------------------------------------------- control -------------------------------------------
	var CommentReplyControl = function() {
		var me = this;

		var ymfeedReply; // 回复数据
		var ymfeedComment; // 评论数据
		var ymfeedCommentIds;

		me.setComment = function(comments) {
			ymfeedComment = comments;
			me.createCommentIds();
		}

		me.setReply = function(replys) {
			ymfeedReply = replys;
		}

		/**
		 * 生成评论ids
		 */
		me.createCommentIds = function() {
			if (ymfeedComment != null && ymfeedComment.length > 0) {
				ymfeedCommentIds = "";
				for (var i = 0; i < ymfeedComment.length; i++) {
					var comment = ymfeedComment[i];
					ymfeedCommentIds += comment.id;
					if (i < ymfeedComment.length - 1) {
						ymfeedCommentIds += ",";
					}
				}
			}
		}

		/**
		 * 在顶部添加一条评论
		 */
		me.prependComment = function(comment) {
			var commentDiv = new YmfeedComment(comment);
			$("#v-h-d-comment").prepend(commentDiv);
		}

		/**
		 * 在底部添加一条评论
		 */
		me.appendComment = function(comment) {
			var commentDiv = new YmfeedComment(comment);
			$("#v-h-d-comment").append(commentDiv);
		}

		/**
		 * 添加一条评论回复
		 */
		me.appendCommentReply = function(reply) {
			var replyDiv = new YmfeedReply(reply);
			$("#comment-reply-input-" + reply.feedCommentId).before(replyDiv);
		}

		/**
		 * 更新评论
		 */
		me.refreshCommentView = function() {
			if (ymfeedComment != null && ymfeedComment.length > 0) {
				for (var i = 0; i < ymfeedComment.length; i++) {
					var comment = ymfeedComment[i];
					me.appendComment(comment);
				}
				// 请求评论数据
				me.getFeedReplyListFunc(ymfeedCommentIds);
			}
		}

		/**
		 * 更新评论回复
		 */
		me.refreshReplyView = function() {
			if (ymfeedReply != null && ymfeedReply.length > 0) {
				for (var i = 0; i < ymfeedReply.length; i++) {
					var reply = ymfeedReply[i];
					me.appendCommentReply(reply);
				}
			}
		}

		/**
		 * 获取feed评论回复列表
		 */
		me.getFeedReplyListFunc = function(commentIds) {
			$.ajax({
				type : "get",
				url : "data/reply/list?cids=" + commentIds,
				dataType : "json",
				success : function(data) {
					me.setReply(data);
					me.refreshReplyView();
				}
			});
		}

		/**
		 * 获取feed评论列表
		 */
		me.getFeedCommentListFunc = function() {
			var fid = "${feedInfo.id}";
			$.ajax({
				type : "get",
				url : "data/comment/list?fid=" + fid,
				dataType : "json",
				success : function(data) {
					me.setComment(data);
					me.refreshCommentView();
				}
			});
		}

		/**
		 * 写一条评论
		 */
		me.createCommentFunc = function() {

			var fid = "${feedInfo.id}";
			var comment = $("#h-d-comment-textarea-id").val();

			var w = window.open();

			$.ajax({
				type : "post",
				url : "p/data/comment/add",
				data : {
					"fid" : fid,
					"comment" : comment
				},
				dataType : "json",
				success : function(data) {
					me.prependComment(data);
					w.close();
				},
				error : function(request, textStatus, errorThrown) {
					if (request.getResponseHeader('session') == "null") {
						w.location = "signin";
					} else {
						w.close();
					}
				}
			});
		}

		return me;
	}
	var mCommentReplyControl = new CommentReplyControl();

	// ------------------------------------------- other -------------------------------------------
	/**
	 * 创建评论回复信息
	 */
	function createFeedCommentReplyInfo(comment) {
		var commentReply = comment.commentReply;
		var div = document.createElement("div");
		if (commentReply != null && commentReply.length > 0) {
			for (var i = 0; i < commentReply.length; i++) {
				var reply = commentReply[i];
				div.appendChild(createFeedCommentReply(comment, reply));
			}
		}
		return div;
	}
	/**
	 * 添加一条评论
	 */
	function writerCommentFunc() {
		mCommentReplyControl.createCommentFunc();
	}

	/**
	 * 页面加载完成后执行
	 */
	$(function() {
		mCommentReplyControl.getFeedCommentListFunc();
	});

	/**
	 * scroll滚动位置监听
	 */
	$(document).ready(function() {
		$(window).scroll(function() {

			if ($(document).scrollTop() <= 0) {
				// alert("top");
			}

			if ($(document).scrollTop() + 200 >= $(document).height() - $(window).height()) {
				// alert("bottom");
			}
		});
	});
</script>