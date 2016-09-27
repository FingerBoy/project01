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
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
<script src="${pageContext.request.contextPath }/js/respond.js"></script>
<link type="image/x-icon"
	href="${pageContext.request.contextPath }/images/icon.ico"
	rel="shortcut icon" />
<link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
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
								herf="http://a.pintuer.com/about/channel-1.html">商品分类</a></li>
							<li><a href="../about/channel-1.html"
								herf="http://a.pintuer.com/about/channel-1.html"><s:property value="#request.goodsType.goodsTypeName"/></a></li>
						</ul>
					</span><span class="icon-caret-right"></span> <s:property value="#request.goodsType.goodsTypeName"/>
				</h2>
			</div>
			<br />
			<div class="grid-table clearfix">
			<s:iterator value="#request.goodsType.goodsList" var="goods">
				<div class="space xm6">
					<div class="cell ipro">
						<div class="media">
							<div class="xs6">
								<a href="${pageContext.request.contextPath}/goods_showGoods.action?goodsId=<s:property value="#goods.goodsId"/>"><img src="images/<s:property value="#goods.goodsPicture"/>"
									height="250"></a>
							</div>
							<div class="xs6">
								<br>
								<h2 class="text-main">
									<a class="text-main" href="${pageContext.request.contextPath}/goods_showGoods.action?goodsId=<s:property value="#goods.goodsId"/>"><s:property value="#goods.goodsName"/></a>
								</h2>
								<br>
								<p class="subtitle"><s:property value="#goods.goodsName"/></p>
								<br>
								<br>
								<p class="text-main text-large padding-bottom">￥<s:property value="#goods.goodsPrice"/></p>
								<p>
									<a class="button bg-main" href="${pageContext.request.contextPath}/goods_showGoods.action?goodsId=<s:property value="#goods.goodsId"/>"><span
										class="icon-shopping-cart"> 立即抢购</span></a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>


			</div>
			<br />
		</div>
	</div>

	<div class="layout bg footer">
		<div class="container">
			<div class="grid-big">
				<br />
				<br />
				<div class="xs3">
					<div class="media media-y">
						<div class="txt radius-circle bg-main text-main text-large">正</div>
						<div class="media-body">
							<strong>100%行货正品</strong>
						</div>
					</div>
				</div>
				<div class="xs3">
					<div class="media media-y">
						<div class="txt radius-circle bg-main text-main text-large">7</div>
						<div class="media-body">
							<strong>7天无理由退货</strong>
						</div>
					</div>
				</div>
				<div class="xs3">
					<div class="media media-y">
						<div class="txt radius-circle bg-main text-main text-large">30</div>
						<div class="media-body">
							<strong>30天免费换货</strong>
						</div>
					</div>
				</div>
				<div class="xs3">
					<div class="media media-y">
						<div
							class="txt radius-circle bg-main text-main text-large icon-truck"></div>
						<div class="media-body">
							<strong>168元起包邮</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>
		<br>
	</div>


	<!--footer 开始了-->
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
