<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>666商城-便宜实惠go！</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
<script src="${pageContext.request.contextPath }/js/respond.js"></script>
<link type="image/x-icon"
	href="${pageContext.request.contextPath }/images/icon.ico"
	rel="shortcut icon" />
<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
<script type="text/javascript">
	$(function() {
		$("#userNiName").blur(function() {

			var val = $(this).val().trim();
			//val = $.trim(val);

			var $this = $(this);

			if (val != "") {
				//把当前节点后面的所有 font 兄弟节点删除
				$this.nextAll("font").remove();

				var url = "user_checkName";
				var args = {
					"userNiName" : val,
					"time" : new Date()
				};
				$.post(url, args, function(data) {
					//表示可用
					if (data == "1") {
						$this.after("<font color='green'>用户名可用!</font>");
					}
					//不可用
					else if (data == "0") {
						$this.after("<font color='red'>用户名已被注册!</font>");
					}
					//服务器错误
					else {
						alert("服务器错误!");
					}
				});
			} else {

				$(this).val("");
				$this.focus();
			}
		});
	})
</script>
</head>

<body>
	<%@ include file="main.jsp"%>


	<!--内容-->
	<div class="container">
		<div class="line-small">
			<div>
				<h2 class="border-bottom padding-bottom text-main">
					<span class="float-right hidden-l">
						<ul class="bread">
							<li><a href="../index.html" class="icon-home"
								herf="http://a.pintuer.com/index.html"> 首页</a></li>
							<li><a href="../about/channel-1.html"
								herf="http://a.pintuer.com/about/channel-1.html">注册</a></li>
						</ul>
					</span><span class="icon-caret-right"></span> 注册
				</h2>
			</div>

			<br />
			<div class="x6 x3-move">
				<form
					action="${pageContext.request.contextPath }/user_regist.action"
					class="form-x" method="post">
					<br>
					<div class="alert alert-yellow">
						<span class="close rotate-hover"></span><strong>注意：</strong>请按照要求填写内容。
					</div>
					<br>
					<div class="form-group">
						<div class="label">
							<label for="f_username_txt">用户昵称</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="userNiName"
								name="userNiName" maxlength="50" value=""
								data-validate="required:必填" placeholder="请输入用户昵称">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_username_txt">用户名</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="f_username_txt"
								name="username" maxlength="50" value=""
								data-validate="required:必填" placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_password_txt">密码</label>
						</div>
						<div class="field">
							<input type="password" class="input" id="f_password_txt"
								name="password" maxlength="50" value=""
								data-validate="required:请填写密码,username:请输入英文字母开头的字母、下划线、数字,length#<50:字数在0-50个"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_passwordok_txt">确认密码</label>
						</div>
						<div class="field">
							<input type="password" class="input" id="f_passwordok_txt"
								name="passwordok" maxlength="50" value=""
								data-validate="required:请填写密码,username:请输入英文字母开头的字母、下划线、数字,repeat#password:两次输入的密码不一致，请检查,length#<50:字数在0-50个"
								placeholder="请重复输入密码">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_email_txt">电子邮箱</label>
						</div>
						<div class="field">
							<input type="email" class="input" id="f_email_txt" name="email"
								maxlength="50" value=""
								data-validate="required:请填写密码,email:请输入Email,如：1979788761@qq.com,length#<50:字数在0-50个"
								placeholder="请输入电子邮箱">
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_mobile_txt">手机号</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="f_mobile_txt" name="mobile"
								maxlength="11" value="" data-validate="required:请填写内容"
								placeholder="请输入手机号码">
						</div>
					</div>

					<br />
					<div class="line">
						<div class="x3 x2-move">
							<input type="submit" value="注册账号" class="button bg-main">
						</div>
						<div class="x3 x3-move">
							<input type="reset" value="重置资料" class="button bg-gray">
						</div>
					</div>
				</form>

			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
	</div>

	<div class="layout bg-black bg-inverse">
		<div class="container">
			<div class="navbar">
				<div class="navbar-head">
					<button class="button bg-gray icon-navicon"
						data-target="#navbar-footer"></button>
					<a href="http://www.pintuer.com" target="_blank"><img
						class="logo"
						src="${pageContext.request.contextPath }/images/logo-white.png" /></a>
				</div>
				<div class="navbar-body nav-navicon" id="navbar-footer">
					<div class="navbar-text navbar-left hidden-s hidden-l">
						版权所有 &copy; <a href="#">666网上商城</a> All Rights Reserved.
					</div>
					<ul class="nav nav-inline navbar-right">
						<li><a href="http://www.pintuer.com">首页</a></li>
						<li><a href="http://www.pintuer.com">联系我们</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>