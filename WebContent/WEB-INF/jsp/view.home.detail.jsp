<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
/****************** 通用设置开始 ******************/
/* 评论图标 */
.vhd-comment-icon-size {
	width: 18px;
	height: 18px;
	margin-bottom: 2px;
	cursor: pointer;
	vertical-align: middle;
}
/* 评论图标文案 */
.vhd-comment-icon-text {
	font-size: 0.9em;
	color: #8a8a8a;
	cursor: pointer;
	margin-left: 4px;
	margin-right: 16px;
}
/* 回复图标 */
.vhd-reply-icon-size {
	width: 16px;
	height: 16px;
	cursor: pointer;
	margin-right: 4px;
	vertical-align: middle;
}
/* 回复图标文案 */
.hvd-reply-icon-text {
	font-size: 0.68em;
	color: #8a8a8a;
	cursor: pointer;
	margin-right: 16px;
}
/* 评论文字大小 */
.vhd-comment-font-size {
	font-size: 1.06em;
}

@media ( max-width : 767px) {
	.vhd-comment-font-size {
		font-size: 0.98em;
	}
}
/* 回复文字大小 */
.vhd-reply-font-size {
	font-size: 0.78em;
}

@media ( max-width : 767px) {
	.vhd-reply-font-size {
		font-size: 0.74em;
	}
}
/****************** 通用设置结束 ******************/
/* 文章标题 */
.h-d-title {
	margin-top: 3rem !important;
	margin-bottom: 1rem !important;
}

@media ( max-width : 767px) {
	.h-d-title {
		font-size: 1.4em;
		font-weight: 800;
		line-height: 1.2;
		margin-top: 0.75rem !important;
		margin-bottom: 0.5rem !important;
	}
}
/* 评论作者、头像、发布时间等 */
.h-d-comment-author {
	margin-top: 0rem !important;
	margin-bottom: 3rem !important;
}

.h-d-comment-author-left, .h-d-author-center, .h-d-author-right {
	float: left;
	height: 42px;
	margin-right: 12px !important;
}

.h-d-comment-author-left {
	width: 42px;
	line-height: 42px;
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}

.h-d-comment-tool {
	padding-left: 8px;
}

@media ( max-width : 767px) {
	.h-d-comment-author-left {
		width: 36px;
	}
}
/* 文章作者、头像、发布时间等 */
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
	.h-d-content p {
		font-size: 1.0rem;
		line-height: 1.6;
		padding: 0.0rem 0.0rem !important;
	}
}
/* 实现左中右布局 */
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
/* 推广 */
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
/* 评论和取消评论 */
.vhd-comment-textarea {
	height: 80px;
	background: #f8f8f8;
	color: #8a8a8a;
}

.vhd-comment-avator {
	width: 42px;
	height: 42px;
}

.vhd-comment-btn {
	cursor: pointer;
}

.vhd-comment-cancel-btn {
	margin-top: 6px;
	color: #8a8a8a;
	font-size: 1.1rem;
	cursor: pointer;
	margin-right: 38px;
}
/** 评论列表 **/
.vhd-comment-body {
	margin-top: 16px;
	margin-bottom: 16px;
}

@media ( max-width : 767px) {
	.vhd-comment-body {
		margin-top: 8px;
		margin-bottom: 8px;
	}
}

.vhd-comment-nickname {
	color: #000000;
	margin-top: 4px;
	font-size: 1.0rem;
	font-weight: 400;
}

.vhd-comment-content {
	margin-top: 1rem;
	margin-bottom: 1rem;
	line-height: 1.8rem;
	padding-left: 8px;
}

@media ( max-width : 767px) {
	.vhd-comment-content {
		padding-top: 8px;
		margin-bottom: 0.2rem;
	}
}

/** 回复列表 **/
.vhd-reply-nickname {
	color: #3194d0;
}

.vhd-reply-content {
	line-height: 1.6rem;
}

.hvd-reply-tool {
	line-height: 1.4rem;
}

@media ( max-width : 767px) {
	.hvd-reply-tool {
		line-height: 1.4rem;
	}
}

.blockquote {
	margin: 1.4rem 0 1.6rem 0.6rem;
	padding: 0 0 0 16px;
	border-left: 2px #ddd solid;
}

@media ( max-width : 767px) {
	.blockquote {
		margin: 1rem 0 1rem 0;
	}
}
/** 回复 **/
.vhd-comment-add {
	margin: 0 0 12px 0;
}

.vhd-comment-write {
	font-size: 0.75em;
	color: #8a8a8a;
	cursor: pointer;
	margin-left: 4px;
}

.vhd-comment-expand {
	font-size: 0.75em;
	color: #3194d0;
	cursor: pointer;
	margin-left: 4px;
}

.vhd-reply-textarea {
	height: 80px;
	background: #f8f8f8;
	color: #8a8a8a;
}

.vhd-reply-btn {
	margin-top: 16px;
	margin-bottom: 16px;
	margin-right: 8px;
}

.vhd-reply-cancel-btn {
	margin-top: 22px;
	margin-right: 38px;
	color: #8a8a8a;
	font-size: 1.1rem;
	cursor: pointer;
}
</style>
<!-- Post Content Column -->
<div class="col-lg-8">

	<!-- Title -->
	<h1 class="h-d-title">${feedInfo.title}</h1>

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

		<!-- 用户头像 -->
		<img class="d-flex mt-1 mr-3 rounded-circle vhd-comment-avator"
			src="http://placehold.it/50x50" alt="">

		<div class="media-body">
			<div class="form-group">

				<!-- 评论输入框 -->
				<textarea id="h-d-comment-textarea-id"
					class="form-control vhd-comment-textarea"
					onfocus="if(value=='写下你的评论...'){value=''}"
					onblur="if(value==''){value='写下你的评论...'}">写下你的评论...</textarea>

			</div>
			<div>
				<!-- 发送评论按钮 -->
				<span class="btn btn-danger float-right vhd-comment-btn"
					onclick="javascript:writerCommentFunc();">发送</span>

				<!-- 取消评论按钮 -->
				<span class="float-right vhd-comment-cancel-btn"
					onclick="javascript:document.getElementById('h-d-comment-textarea-id').value = '写下你的评论...'">取消</span>
			</div>
		</div>
	</div>

	<h5>
		<span id="vhd-comment-count-id"></span>
	</h5>
	<hr class="my-4">

	<div id="v-h-d-comment">
		<!-- comment -->
	</div>

	<jsp:include page="include/pagination.jsp" flush="true" />
</div>

<script>
	// ------------------------------------------- comment -------------------------------------------
	/**
	 * 创建评论列表数据
	 */
	var YmfeedComment = function(comment) {
		var me = this;

		var commentBody;
		var commentHeader;

		var imageCommentAvatar; // 评论者头像
		var divCommentNickname; // 评论者昵称
		var divCommentCreateTime; // 评论时间

		var divCommentContent; // 评论内容

		var divCommentTool; // 评论工具
		var imageLike; // 评论点赞图片
		var spanLike; // 评论点赞文本
		var imageReply; // 评论回复图片
		var aReply; // 评论回复文本

		var blockquoteReply; // 评论回复

		me.init = function() {

			var commentContent = document.createElement("div");
			commentContent.className = "media-body";

			me.initComment();
			me.initCommentTool();
			me.initReply();

			commentContent.appendChild(commentHeader);
			commentContent.appendChild(me.clearFix());

			commentContent.appendChild(divCommentContent);
			commentContent.appendChild(divCommentTool);
			commentContent.appendChild(blockquoteReply);

			commentBody = document.createElement("div");
			commentBody.style.display = "none";
			commentBody.className = "media panel vhd-comment-body";
			commentBody.appendChild(commentContent);
		}

		me.initComment = function() {

			// 创建feed评论头像
			imageCommentAvatar = document.createElement("img");
			imageCommentAvatar.src = comment.avatar;
			imageCommentAvatar.src = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1762973822,121126736&fm=27&gp=0.jpg";
			imageCommentAvatar.className = "rounded-circle vhd-comment-avator";

			var divHeaderLeft = document.createElement("div");
			divHeaderLeft.className = "h-d-comment-author-left";
			divHeaderLeft.appendChild(imageCommentAvatar);

			// 创建feed评论昵称
			var divName = document.createElement("div");
			divName.className = "h-d-author-ctop h-d-nickname";
			divName.innerHTML = comment.userAccount.nickname;
			// 创建评论时间
			var divTime = document.createElement("div");
			divTime.className = "h-d-author-cbottom h-d-time";
			divTime.innerHTML = getLocalTime(comment.createTime);

			var divCenter = document.createElement("div");
			divCenter.className = "h-d-author-center";
			divCenter.appendChild(divName);
			divCenter.appendChild(divTime);

			commentHeader = document.createElement("div");
			commentHeader.className = "h-d-comment-author";
			commentHeader.appendChild(divHeaderLeft);
			commentHeader.appendChild(divCenter);

			// 创建评论内容
			divCommentContent = document.createElement("div");
			divCommentContent.className = "vhd-comment-content vhd-comment-font-size";
			divCommentContent.innerHTML = comment.comment;
		}

		me.initCommentTool = function() {
			// 创建评论工具栏-赞图
			imageLike = document.createElement("img");
			imageLike.className = "vhd-comment-icon-size";
			imageLike.src = "images/ic_comment_like.png";
			imageLike.onclick = function() {
				alert("赞");
			}

			// 创建评论工具栏-赞文本
			spanLike = document.createElement("span");
			spanLike.innerHTML = comment.likeCount != null ? comment.likeCount : 0 + "人赞";
			spanLike.className = "vhd-comment-icon-text";
			spanLike.onclick = function() {
				alert("赞");
			}

			// 创建评论工具栏-回复图
			imageReply = document.createElement("img");
			imageReply.className = "vhd-comment-icon-size";
			imageReply.src = "images/ic_comment_reply.png";
			imageReply.onclick = function() {
				alert("回复1");
			}

			// 创建评论工具栏-回复文本
			aReply = document.createElement("span");
			aReply.className = "vhd-comment-icon-text";
			aReply.innerHTML = "回复";
			aReply.onclick = function() {
				activeReplyInput(comment.id, comment.userAccountId, comment.userAccount.nickname);
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
			var input = new YmfeedInput(comment.id);
			blockquoteReply.appendChild(me.addNewReply());
			blockquoteReply.appendChild(input);
		}

		/**
		 * 在评论后添加新评论文案
		 */
		me.addNewReply = function() {

			// 添加新评论图标
			var imageWrite = document.createElement("img");
			imageWrite.className = "vhd-comment-icon-size";
			imageWrite.src = "images/ic_reply_write.png";
			imageWrite.onclick = function() {
				activeReplyInput(comment.id, comment.userAccountId, comment.userAccount.nickname);
			}

			// 添加新评论按钮
			var spanWirte = document.createElement("span");
			spanWirte.className = "vhd-comment-write";
			spanWirte.innerHTML = "添加新评论";
			spanWirte.onclick = function() {
				activeReplyInput(comment.id, comment.userAccountId, comment.userAccount.nickname);
			}

			var spanHasMore = document.createElement("span");
			spanHasMore.className = "vhd-comment-write";
			spanHasMore.innerHTML = "&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;还有条3评论，";

			var spanExpandMore = document.createElement("span");
			spanExpandMore.className = "vhd-comment-expand link-color";
			spanExpandMore.innerHTML = "展开查看更多";

			var addNewReplyBody = document.createElement("div");
			addNewReplyBody.className = "vhd-comment-add";
			addNewReplyBody.style.display = "none";
			addNewReplyBody.id = mCommentReplyControl.getCommentReplyAddId(comment.id);
			addNewReplyBody.appendChild(imageWrite);
			addNewReplyBody.appendChild(spanWirte);
			addNewReplyBody.appendChild(spanHasMore);
			addNewReplyBody.appendChild(spanExpandMore);

			return addNewReplyBody;
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
		var spanReplyTime; // 评论回复时间
		var imageReplyIcon; // 评论回复icon
		var aReplyIconText; // 评论回复icon文本
		var divReplyTool;

		me.init = function() {
			// 评论回复者昵称
			spanReplyNickname = document.createElement("span");
			spanReplyNickname.className = "mr-1 vhd-reply-nickname";
			spanReplyNickname.innerHTML = reply.userAccount.nickname;
			// 评论回复者内容
			spanReplyContent = document.createElement("div");
			spanReplyContent.className = "vhd-reply-content vhd-reply-font-size";

			spanReplyContent.append(spanReplyNickname);
			spanReplyContent.innerHTML += reply.reply;

			// 评论回复时间
			spanReplyTime = document.createElement("span");
			spanReplyTime.className = "hvd-reply-icon-text";
			spanReplyTime.innerHTML = getLocalTime(reply.createTime);
			// 评论回复ICON
			imageReplyIcon = document.createElement("img");
			imageReplyIcon.className = "vhd-reply-icon-size";
			imageReplyIcon.src = "images/ic_comment_reply.png";
			// 评论回复文本
			aReplyIconText = document.createElement("span");
			aReplyIconText.className = "hvd-reply-icon-text";
			aReplyIconText.dataset.parent = "#v-h-d-comment";
			aReplyIconText.innerHTML = "回复";
			aReplyIconText.onclick = function() {
				activeReplyInput(reply.feedCommentId, reply.userAccountId, reply.userAccount.nickname);
			}

			divReplyTool = document.createElement("div");
			divReplyTool.className = "hvd-reply-tool";

			divReplyTool.append(spanReplyTime);
			divReplyTool.append(imageReplyIcon);
			divReplyTool.append(aReplyIconText);

			replyBody = document.createElement("div");
			replyBody.id = mCommentReplyControl.getCommentReplyId(reply.id);
			replyBody.style.display = "none";
			replyBody.className = "my-2";
			replyBody.append(spanReplyContent);
			replyBody.append(divReplyTool);
			replyBody.append(me.dashed());
		}

		me.dashed = function() {
			var hrDashed = document.createElement("div");
			hrDashed.className = "hr-dashed";
			return hrDashed;
		}

		me.init();

		return replyBody;
	}
	// ------------------------------------------- input -------------------------------------------
	/**
	 * 激活评论回复输入框
	 */
	function activeReplyInput(commentId, replyToUserId, replyToUserNickname) {

		$("#" + mCommentReplyControl.getCommentReplyTextareaId(commentId)).val("@" + replyToUserNickname + " ");
		$("#" + mCommentReplyControl.getCommentReplyInputId(commentId)).attr("replyToId", replyToUserId);
		$("#" + mCommentReplyControl.getCommentReplyInputId(commentId)).attr("replyToNickname", replyToUserNickname);

		var replyInput = $("#" + mCommentReplyControl.getCommentReplyInputId(commentId));
		if (replyInput.css("display") == "none") {
			replyInput.fadeIn(1000);
		} else {
			replyInput.fadeOut(500);
		}
	}
	/**
	 * 评论回复输入组件
	 */
	var YmfeedInput = function(commentId) {
		var me = this;

		var inputBody;

		var textareaContent; // 输入框
		var buttonSubmit; // 提交按钮
		var buttonCancel; // 取消按钮

		me.init = function() {

			// ---------------------------------------------------
			textareaContent = document.createElement("textarea");
			textareaContent.id = mCommentReplyControl.getCommentReplyTextareaId(commentId);
			textareaContent.className = "form-control vhd-reply-textarea";
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
			buttonSubmit.className = "btn btn-danger float-right vhd-reply-btn";
			buttonSubmit.onclick = function() {
				me.createReplyFunc(commentId);
			}
			buttonSubmit.innerHTML = "发送";

			// ---------------------------------------------------
			buttonCancel = document.createElement("span");
			buttonCancel.className = "float-right vhd-reply-cancel-btn";
			buttonCancel.innerHTML = "取消";
			buttonCancel.onclick = function() {
				$(textareaContent).val("");
				$(inputBody).fadeOut(500);
			}

			// ---------------------------------------------------
			inputBody = document.createElement("div");
			inputBody.id = mCommentReplyControl.getCommentReplyInputId(commentId);
			inputBody.className = "h-d-reply-input-body";
			inputBody.style.display = "none";
			inputBody.appendChild(textareaContent);
			inputBody.appendChild(buttonSubmit);
			inputBody.appendChild(buttonCancel);
		}

		/**
		 * 写一条评论
		 */
		me.createReplyFunc = function(commentId) {

			var replyToId = $("#" + mCommentReplyControl.getCommentReplyInputId(commentId)).attr("replyToId");
			var replyToNickname = $("#" + mCommentReplyControl.getCommentReplyInputId(commentId)).attr(
					"replyToNickname");
			var reply = textareaContent.value;
			var fid = "${feedInfo.id}";

			$.ajax({
				type : "post",
				async : false,
				url : "p/data/reply/add",
				data : {
					"reply" : reply,
					"replyToUserAccountId" : replyToId,
					"feedInfoId" : fid,
					"feedCommentId" : commentId
				},
				dataType : "json",
				success : function(data) {
					mCommentReplyControl.appendCommentReply(data);
				},
				error : function(request, textStatus, errorThrown) {
					if (request.getResponseHeader('session') == "null") {
						ymSignInWin();
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
			$("#h-d-comment-textarea-id").val("");
			var commentDiv = new YmfeedComment(comment);
			$("#v-h-d-comment").prepend(commentDiv);
			$(commentDiv).fadeIn(1000);
		}

		/**
		 * 在底部添加一条评论
		 */
		me.appendComment = function(comment) {
			$("#" + mCommentReplyControl.getCommentReplyTextareaId(comment.id)).val("");
			var commentDiv = new YmfeedComment(comment);
			$("#v-h-d-comment").append(commentDiv);
			$(commentDiv).fadeIn(1000);
		}

		/**
		 * 添加一条评论回复
		 */
		me.appendCommentReply = function(reply) {
			$("#" + mCommentReplyControl.getCommentReplyTextareaId(reply.feedCommentId)).val(""); // 清空输入框
			var replyDiv = new YmfeedReply(reply);
			$("#" + mCommentReplyControl.getCommentReplyAddId(reply.feedCommentId)).before(replyDiv); // 评论添加到"添加新评论"前面
			$("#" + mCommentReplyControl.getCommentReplyAddId(reply.feedCommentId)).fadeIn(1); // 有评论时显示添加新评论
			$("#" + mCommentReplyControl.getCommentReplyInputId(reply.feedCommentId)).fadeOut(1); // 添加评论后隐藏输入评论框
			$(replyDiv).fadeIn(1000); // 显示新评论内容
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
		 * 第一次获取feed评论回复列表，最多返回3条
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
		 * 获取feed评论回复列表，分页返回添加
		 */
		me.getFeedReplyListMoreFunc = function(commentId) {
			$.ajax({
				type : "get",
				url : "data/reply/listmore?cid=" + commentId + "&start=" + 3,
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
		me.getFeedCommentListFunc = function(isPage) {
			var fid = "${feedInfo.id}";
			$.ajax({
				type : "get",
				url : "data/comment/list?fid=" + fid + "&isPage" + isPage,
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

			$.ajax({
				type : "post",
				async : false,
				url : "p/data/comment/add",
				data : {
					"fid" : fid,
					"comment" : comment
				},
				dataType : "json",
				success : function(data) {
					me.prependComment(data);
				},
				error : function(request, textStatus, errorThrown) {
					if (request.getResponseHeader('session') == "null") {
						w.location = "signin";
					}
				}
			});
		}

		/**
		 * 输入文本框ID
		 */
		me.getCommentReplyAddId = function(commentId) {
			return "comment-reply-add-" + commentId;
		}

		/**
		 * 输入文本框ID
		 */
		me.getCommentReplyTextareaId = function(commentId) {
			return "comment-reply-textarea-" + commentId;
		}

		/**
		 * 输入区域ID
		 */
		me.getCommentReplyInputId = function(commentId) {
			return "comment-reply-input-" + commentId;
		}

		/**
		 * 一条回复ID
		 */
		me.getCommentReplyId = function(replyId) {
			return "comment-reply-" + replyId;
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
		mCommentReplyControl.getFeedCommentListFunc(true);
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