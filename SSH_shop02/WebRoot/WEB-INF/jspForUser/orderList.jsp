<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>666商城-便宜实惠go！</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/pintuer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css"
	type="text/css" />
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
		<br>

		<form class="form-x" action="${ pageContext.request.contextPath }/order_pay.action" method="post" id="cart">
			<div class="grid-big">
				<div class="space xm10 xm1-move">
					<h3 class="padding-bottom border-bottom icon-caret-right">
						查看订单详情</h3>
					<br><input type="hidden" name="orderId" value="<s:property value="model.orderId" />"/>
					<table class="table table-bordered">
						<tbody>
							<tr class="">
								<th colspan="2">商品</th>
							</tr>
							<s:iterator var="orderItem" value="model.orderItems">
								<tr class="" height="90">
									<td width="60"><img
										src="${pageContext.request.contextPath }/images/<s:property value="#orderItem.goods.goodsPicture"/>"
										width="60"></td>
									<td class="badge-corner"><span class="text-red text-small"></span>
										<a href="goods.html" target="_blank"><s:property
												value="#orderItem.goods.goodsName" /></a>
										<div class="float-right padding-top" align="right">
											<div class="line-big">
												<div class="x6">
													<label>单价：</label>
												</div>
												<div class="x6">
													<label>¥<s:property
															value="#orderItem.goods.goodsPrice" /></label>
												</div>
											</div>
											<div class="line-big">
												<div class="x6">
													<label>数量：</label>
												</div>
												<div class="x6">
													<label><s:property value="#orderItem.count" /></label>
												</div>
											</div>
										</div></td>
								</tr>
							</s:iterator>


							<tr class="tablehover">
								<td colspan="2" align="right">总计： ¥<span id="total"><s:property
											value="model.allTotal" /></span></td>
							</tr>
						</tbody>
					</table>



					<br>

					<!--收货地址-->
					<h3 class="padding-bottom border-bottom icon-caret-right">
						收货信息</h3>
					<br>
					<div class="line-big">
						<div class="x6">
							<div class="form-group">
								<label for="receive"><strong>收件人：</strong></label> <label
									for="receive"><s:property value="model.name" /></label>
							</div>
							<div class="form-group">
								<label for="address"><strong>地 址：</strong></label> <label
									for="address"><s:property value="model.address" /></label>
							</div>
							<div class="form-group">
								<label for="postcode"><strong>邮 编：</strong></label> <label
									for="postcode"><s:property value="model.postNum" /></label>
							</div>
							<br>
							<br>
							<br>
						</div>
						<div class="x6">
							<div class="form-group">
								<label for="tel"><strong>电 话：</strong></label> <label for="tel"><s:property
										value="model.tel" /></label>
							</div>
						</div>
					</div>

					<h3 class="padding-bottom border-bottom icon-caret-right">
						支付及送货</h3>
					<br>
					
					
						<div class="line-big">
							<div class="x6">
								<p>
									<label for="shipping">选择银行</label><br/>
									<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
									<img src="${ pageContext.request.contextPath }/images/abc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</p>	
							</div>
							<div class="x6">
								<div class="form-group">
									<div class="label">
										<label for="shipping">送货</label>
									</div>
									<div class="field">
										<div class="button-group radio">
											<label class="button active"><span
												class="icon icon-check"></span> 瞬风快递</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="padding-top" align="right">
						    <input class="button bg-main" type="submit" value="立即付款"></input>
						</div>
				

					<br>
					<br>

				</div>
			</div>
			<br>
		</form>
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