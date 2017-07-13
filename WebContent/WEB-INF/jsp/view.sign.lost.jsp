<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
.sign .sign-lost-msg {
	margin: 10px 0;
	padding: 0;
	text-align: center;
	font-size: 12px;
	line-height: 20px;
	color: #969696
}

.sign .sign-lost-msg a, .sign .sign-lost-msg a:hover {
	color: #969696
}

.input-group-addon {
	height: 34px;
	cursor: pointer;
	width: 100px;
}
</style>

<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">重置密码</h3>
		</div>
		<div class="panel-body">
			<form id="lost-form" role="form" action="data/sign/lost"
				method="post">
				<fieldset>
					<div class="form-group">
						<input id="email" class="form-control" placeholder="输入注册的邮箱地址"
							type="email" name="email" value="${email}" required autofocus>
					</div>
					<div class="form-group">
						<div class="input-group">
							<input class="form-control" placeholder="邮箱验证码" name="validate"
								value="${validate}" minlength="1" maxlength="8" required>
							<input id="sign-lost-code" class="input-group-addon"
								type="button" onClick="javascript:sendValidateCode();"
								value="发送验证码" />
						</div>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="设置一个新密码" type="password"
							name="password" value="${password}" minlength="6" maxlength="16"
							required>
					</div>
					<c:if test="${code == 1002}">
						<div id="error-msg" class="alert alert-danger">${message}</div>
					</c:if>
					<div id="validate-msg-error" class="alert alert-danger"
						style="display: none;"></div>
					<div id="validate-msg-succ" class="alert alert-success"
						style="display: none;"></div>
					<!-- Change this to a button or input when using this as a form -->
					<input id="sign-lost-submit" type="submit"
						class="btn btn-lg btn-success btn-block" value="重置密码" />
					<div class="sign">
						<p class="sign-lost-msg">
							<a target="_blank" href="#">登录</a> - <a target="_blank" href="#">注册</a>
						</p>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>

<script>
	/**
	 * 发送验证码
	 */
	function sendValidateCode() {
		$.ajax({
			type : "post",
			url : "data/sign/validate",
			data : {
				"email" : $("#email").val()
			},
			dataType : "json",
			success : function(data) {
				$("#validate-msg-succ").hide();
				$("#validate-msg-error").hide();
				if (data.code == 1001) {
					$("#validate-msg-succ").html("验证码已发送到邮箱");
					$("#validate-msg-succ").show();
				} else {
					$("#validate-msg-error").html(data.msg);
					$("#validate-msg-error").show();
				}
			}
		});
	}
</script>
