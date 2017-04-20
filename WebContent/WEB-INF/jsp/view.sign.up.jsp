<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/jquery.validate.css" type="text/css"
	charset="utf-8">

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
			<form role="form" id="sign-up-form">
				<fieldset>
					<div class="form-group">
						<input class="form-control" placeholder="你的昵称" id="nickname"
							name="nickname" minlength="2" autofocus>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="邮箱地址" id="email"
							title="请填写邮箱地址" name="email" type="email">
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="设置密码" id="password"
							title="请填写密码" name="password" type="password">
					</div>
					<div id="error-msg" class="alert alert-danger"
						style="display: none;"></div>
					<!-- Change this to a button or input when using this as a form -->
					<input type="submit" class="btn btn-lg btn-success btn-block"
						onclick="javascritp:ajaxSignUp();return;" value="注册" />
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
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	function ajaxSignUp() {

		var nickname = $("#nickname").val();
		if (!checkNicknameLen(nickname)) {
			$("#nickname").rzAlertTips({
				flagInfo : '昵称长度2~16'
			});
			return;
		}

		jQuery('#sign-body').showLoading();
		$.ajax({
			type : "post",
			url : "data/sign/up",
			data : {
				"nickname" : $("#nickname").val(),
				"email" : $("#email").val(),
				"password" : $("#password").val()
			},
			dataType : "json",
			success : function(data) {
				jQuery('#sign-body').hideLoading();
				if (data.code == 1001) {
					// success
					openSelf("active");
				} else if (data.code == 1002) {
					$("#error-msg").text(data.message);
					$("#error-msg").show();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				jQuery('#sign-body').hideLoading();
				Lobibox.notify('info', {
					size : 'mini',
					//delay : 3000,
					msg : textStatus
				});
			}
		});
	}
</script>