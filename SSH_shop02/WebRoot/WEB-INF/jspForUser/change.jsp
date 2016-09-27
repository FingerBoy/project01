<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>666商城-便宜实惠go！</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/respond.js"></script>
<link type="image/x-icon" href="images/icon.ico" rel="shortcut icon" />
<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>
	<%@ include file="main.jsp" %>

	<!--内容-->
	<div class="container">
		<div class="line-small">
			<div>
				<h2 class="border-bottom padding-bottom text-main">
					<span class="float-right hidden-l">
						<ul class="bread">
							<li><a href="index.html" class="icon-home"> 首页</a></li>
							<li><a href="../about/channel-1.html">我的资料</a></li>
						</ul>
					</span><span class="icon-caret-right"></span> 修改资料
				</h2>
			</div>

			<br />
			<div class="x6 x3-move">
				<form action="${pageContext.request.contextPath }/user_changeUser.action" class="form-x" method="post">
					<br> <br>
					<div class="form-group">
						<input type="hidden" " 
								name="id" value='<s:property value="#request.user.id"/>'>
								<input type="hidden" " 
								name="password" value='<s:property value="#request.user.password"/>'>
						<div class="label">
							<label for="f_username_txt">用户昵称</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="userNiName"
								name="userNiName" data-validate="required:必填"
								placeholder="请输入用户昵称" value='<s:property value="#request.user.userNiName"/>'>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_username_txt">用户名</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="f_username_txt"
								name="username" data-validate="required:必填"
								placeholder="请输入用户名" value='<s:property value="#request.user.username"/>'>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_email_txt">电子邮箱</label>
						</div>
						<div class="field">
							<input type="email" class="input" id="f_email_txt"
								name="email"
								data-validate="required:请填写密码,email:请输入Email,如：1979788761@qq.com,length#<50:字数在0-50个"
								placeholder="请输入电子邮箱" value='<s:property value="#request.user.email"/>'>
						</div>
					</div>
					<div class="form-group">
						<div class="label">
							<label for="f_mobile_txt">手机号</label>
						</div>
						<div class="field">
							<input type="text" class="input" id="f_mobile_txt"
								name="mobile"
								data-validate="required:请填写内容"
								placeholder="请输入手机号码" value='<s:property value="#request.user.mobile"/>'>
						</div>
					</div>
					
					<br />
					<div class="line">
						<div class="x3 x2-move">
							<input type="submit" value="确认修改" class="button bg-main">
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
						class="logo" src="images/logo-white.png" /></a>
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
