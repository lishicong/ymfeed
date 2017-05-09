<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
.sign .sign-up-msg {
	margin: 10px 0;
	padding: 0;
	text-align: center;
	font-size: 12px;
	line-height: 20px;
	color: #969696
}

.sign .sign-up-msg a, .sign .sign-up-msg a:hover {
	color: #3194d0
}
</style>

<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">注册</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="data/sign/up" method="post">
				<fieldset>
					<div class="form-group">
						<input class="form-control" placeholder="你的昵称" name="nickname"
							value="${nickname}" minlength="2" maxlength="16" required
							autofocus>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="邮箱地址" type="email"
							name="email" value="${email}" required>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="设置密码" type="password"
							name="password" value="${password}" minlength="6" maxlength="16"
							required>
					</div>
					<c:if test="${code == 1002}">
						<div id="error-msg" class="alert alert-danger">${message}</div>
					</c:if>
					<!-- Change this to a button or input when using this as a form -->
					<input type="submit" class="btn btn-lg btn-success btn-block"
						value="注册" />
					<div class="sign">
						<p class="sign-up-msg">
							点击 “注册” 即表示您同意并愿意遵守<br> <a target="_blank" href="#">用户协议</a>
							和 <a target="_blank" href="#">隐私政策</a> 。
						</p>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>