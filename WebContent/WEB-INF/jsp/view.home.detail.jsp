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
	<img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">

	<!-- Comments Form -->
	<div class="card my-4">
		<h5 class="card-header">发表评论:</h5>
		<div class="card-block">
			<form>
				<div class="form-group">
					<textarea class="form-control" rows="3"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
	<!-- Single Comment -->
	<div class="media mb-4">
		<img class="d-flex mr-3 rounded-circle"
			src="http://placehold.it/50x50" alt="">
		<div class="media-body">
			<h5 class="mt-0">我爱裸睡</h5>
			免运费买了买了！！
		</div>
	</div>
	<!-- Comment with nested comments -->
	<div class="media mb-4">
		<img class="d-flex mr-3 rounded-circle"
			src="http://placehold.it/50x50" alt="">
		<div class="media-body">
			<h5 class="mt-0">我爱裸睡</h5>
			免运费买了买了！！

			<div class="media mt-4">
				<img class="d-flex mr-3 rounded-circle"
					src="http://placehold.it/50x50" alt="">
				<div class="media-body">
					<h5 class="mt-0">托托侠</h5>
					好喝吗
				</div>
			</div>
			<div class="media mt-4">
				<img class="d-flex mr-3 rounded-circle"
					src="http://placehold.it/50x50" alt="">
				<div class="media-body">
					<h5 class="mt-0">托托侠</h5>
					好喝吗
				</div>
			</div>
		</div>
	</div>
</div>
