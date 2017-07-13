<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
.form-remember {
	margin-right: 6px;
}

.sign {
	text-align: center;
	font-size: 14px;
}

.sign .more-sign {
	margin-top: 20px
}

.sign .more-sign h6 {
	position: relative;
	margin: 0 0 20px;
	font-size: 12px;
	color: #b5b5b5
}

.sign .more-sign h6:before {
	left: 30px
}

.sign .more-sign h6:after, .sign .more-sign h6:before {
	content: "";
	border-top: 1px solid #b5b5b5;
	display: block;
	position: absolute;
	width: 60px;
	top: 5px
}

.sign .more-sign h6:after {
	right: 30px
}

.sign .more-sign ul {
	margin-bottom: 10px;
	margin-left: -45px;
	list-style: none;
}

.sign .more-sign ul li {
	margin: 0 8px;
	display: inline-block;
}

.sign .more-sign ul a {
	width: 50px;
	height: 50px;
	background-color: hsla(0, 0%, 71%, .2);
	border-radius: 50%;
	line-height: 50px;
	display: block
}

.sign .more-sign ul i {
	font-size: 24px
}

.sign .more-sign .weibo {
	background-color: #e05244
}

.sign .more-sign .weixin {
	background-color: #00bb29
}

.sign .more-sign .qq {
	background-color: #498ad5
}
</style>

<div class="col-sm-4">
	<!-- 左侧占位 -->
</div>

<div class="col-md-4 col-md-offset-4">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">登录</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="data/sign/in" method="post">
				<fieldset>
					<div class="form-group">
						<input class="form-control" placeholder="邮箱" name="email"
							type="email" value="${email}" required autofocus>
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="密码" name="password"
							type="password" value="${password}" required>
					</div>
					<div class="checkbox">
						<label> <input class="form-remember" name="remember"
							type="checkbox" <c:if test="${remember==true}">checked</c:if>>记住我
						</label><a href="signlost" style="float: right;">忘记密码？</a>
					</div>
					<c:if test="${code == 1002}">
						<div id="error-msg" class="alert alert-danger">${message}</div>
					</c:if>
					<!-- Change this to a button or input when using this as a form -->
					<input type="submit" class="btn btn-lg btn-info btn-block"
						value="登录" />
					<div style="margin-top: 16px; text-align: center;">
						还没有帐号？<a href="signup">免费注册</a>
					</div>
					<!-- 更多登录方式 -->
					<div class="sign">
						<div class="more-sign">
							<h6>社交帐号登录</h6>
							<ul>
								<li><a class="weibo" href="#"><i
										class="iconfont ic-weibo"></i></a></li>
								<li><a class="weixin" href="#"><i
										class="iconfont ic-wechat"></i></a></li>
								<li><a class="qq" href="#"><i
										class="iconfont ic-qq_connect"></i></a></li>
							</ul>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</div>