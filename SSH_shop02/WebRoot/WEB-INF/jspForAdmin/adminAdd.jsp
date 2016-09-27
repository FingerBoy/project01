<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>666后台主页</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin.css">
</head>
<body>


	<%@ include file="top.jsp"%>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<%@ include file="left.jsp"%>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">添加</strong> / <small>添加管理员账号及信息</small>
				</div>
			</div>

			<hr />

			<div class="am-g">
				<form class="am-form am-form-horizontal" action="${pageContext.request.contextPath }/admin_add.action" method="post">
					

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员姓名 / UserName</label>
						<div class="am-u-sm-9">
							<input type="text" id="adminName" name="name"
								placeholder="输入你的管理员姓名 / adminName">
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员密码 / UserPwd</label>
						<div class="am-u-sm-9">
							<input type="password" id="adminPwd" name="password"
								placeholder="输入你的管理员密码，请牢记 / adminPwd">
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员身份证 / UserName</label>
						<div class="am-u-sm-9">
							<input type="number" id="adminCard" name="idCard"
								placeholder="输入你的管理员身份证 / adminCard">
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员电子邮箱</label>
						<div class="am-u-sm-9">
							<input type="email" id="adminEmail" name="email"
								placeholder="输入你的管理员电子邮箱 / adminEmail">
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员联系电话</label>
						<div class="am-u-sm-9">
							<input type="number" id="adminPhone" name="phone"
								placeholder="输入你的管理员联系电话 / adminPhone">
						</div>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 am-form-label">管理员权限</label>
						<div class="am-u-sm-9">
							<select name="role" >
								<option value="0">普通管理员</option>
								<option value="1">超级管理员</option>
							</select>
						</div>
					</div>

					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<input type="submit" class="am-btn am-btn-primary" value="新增管理员">
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- content end -->

	</div>

	<footer>
		<hr>
		<p class="am-padding-left">时光静好，与君语；细水流年，与君同。</p>
	</footer>

	<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath }/assets/js/jquery1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/modernizr.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/polyfill/rem.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/polyfill/respond.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
</body>
</html>

