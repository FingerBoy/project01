<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>666后台主页</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<%@ include file="top.jsp" %>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  	<%@ include file="left.jsp" %>
  <!-- sidebar end -->
	
  <!-- content start -->
	<h3 class="am-padding-center">操作成功!<a href="${pageContext.request.contextPath }/admin_adminShow.action?page=1">点这里返回</a></h3>

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
