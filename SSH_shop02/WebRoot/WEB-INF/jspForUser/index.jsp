<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>666商城-便宜实惠go！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.js"></script>
    <link type="image/x-icon" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/images/icon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>
   <%@ include file="main.jsp" %>
    
    
    <!--banner-->
    <div class="banner" data-style="border-white">
      <div class="carousel">
        <div class="item"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/banner1.jpg" width="100%" /></a></div>
        <div class="item"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/banner2.jpg" width="100%" /></a></div>
        <div class="item"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/banner3.jpg" width="100%" /></a></div>
      </div>
    </div>
  	<br />
    
  	<!--内容-->
    <div class="container">
      <div class="line-small">
      	<div class="xl12 xm6 margin-small-bottom"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/product1.jpg" width="100%" /></a></div>
        <div class="xl6 xm3"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/product2.jpg" width="100%" /></a></div>
        <div class="xl6 xm3"><a href="goods.html"><img src="${pageContext.request.contextPath}/images/product3.jpg" width="100%" /></a></div>
      </div>
      <br />

      <div class="line-big">
        <div class="xl12 xm12">
        	<div class="line-small">
                <div class="xs4">
                  <a href="goods.html"><img src="${pageContext.request.contextPath}/images/1.jpg" width="100%" /></a>
                </div>
                <div class="xs4">
                  <a href="goods.html"><img src="${pageContext.request.contextPath}/images/2.jpg" width="100%" /></a>
                </div>
                <div class="xs4">
                  <a href="goods.html"><img src="${pageContext.request.contextPath}/images/1.jpg" width="100%" /></a>
                </div>
            </div>
        </div>
      </div>
    </div>
    
    
    <!--底部-->
    <br /><br />

    <div class="layout bg-black bg-inverse">
      <div class="container">
        <div class="navbar">
          <div class="navbar-head"><button class="button bg-gray icon-navicon" data-target="#navbar-footer"></button><a href="http://www.pintuer.com" target="_blank"><img class="logo" src="${pageContext.request.contextPath}/images/logo-white.png" alt="拼图前端CSS框架" /></a></div>
          <div class="navbar-body nav-navicon" id="navbar-footer">
            <div class="navbar-text navbar-left hidden-s hidden-l">版权所有 &copy; <a href="#">666网上商城</a> All Rights Reserved.</div>
            <ul class="nav nav-inline navbar-right"><li><a href="http://www.pintuer.com">首页</a></li><li><a href="http://www.pintuer.com">联系我们</a></li></ul>
          </div>
        </div>
      </div>
    </div>
</body>
</html>