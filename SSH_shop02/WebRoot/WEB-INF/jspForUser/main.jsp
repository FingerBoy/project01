<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--顶部-->
<div class="layout bg-black bg-inverse">

	<s:if test="#session.loginName==null">
		<div class="container height-large">
			<span class="float-right text-small text-gray hidden-l"> <a
				class="text-main"
				href="${pageContext.request.contextPath }/to_regist.action">注册</a><span>
					| </span><a class="text-main"
				href="${pageContext.request.contextPath }/to_login.action">登录</a><span>
					| </span><a class="text-main" href="http://www.pintuer.com">联系我们</a>
			</span> 欢迎访问 <a href="${pageContext.request.contextPath }/to_index.action">666商城</a> 便宜实惠购！
		</div>
	</s:if>
	<s:else>
		<div class="container height-large">
			<span class="float-right text-small text-gray hidden-l"> 欢迎用户:<strong
				class="text-main"><s:property value="#session.loginName.userNiName" /></strong>
				<span> | </span><a class="text-main"
				href="${pageContext.request.contextPath }/user_logout.action">退出</a><span>
					| </span><a class="text-main" href="http://www.pintuer.com">联系我们</a>
			</span> 欢迎访问 <a href="${pageContext.request.contextPath }/to_index.action">666商城</a> 便宜实惠购！
		</div>
	</s:else>
</div>

<!--导航-->
<div class="demo-nav padding-big-top padding-big-bottom">
	<div class="container padding-top padding-bottom">

		<div class="line">
			<div class="xl12 xs3 xm3 xb2">
				<button class="button icon-navicon float-right"
					data-target="#header-demo"></button>
				<a target="_blank" href="${pageContext.request.contextPath }/to_index.action"><img
					src="${pageContext.request.contextPath}/images/logo.png" /></a>
			</div>
			<div class=" xl12 xs9 xm9 xb10 nav-navicon" id="header-demo">

				<div class="xs12 xm9 xb9 padding-small">
					<ul class="nav nav-menu nav-inline nav-big">
						<li><a href="${pageContext.request.contextPath }/to_index.action">首页</a></li>
							<li><a href="${pageContext.request.contextPath }/goods_showAll.action?page=1">全部商品</a></li>
						<li><a href="#">分类查看<span class="arrow"></span></a>
							<ul class="drop-menu">
							<s:iterator value="#session.typeList" var="type">
								<li><a href="${pageContext.request.contextPath }/goodsType_showByType.action?goodsTypeId=<s:property value="#type.goodsTypeId"/>"><s:property value="#type.goodsTypeName"/></a></li>
							</s:iterator>
							</ul></li>
							<li><a href="#">用户管理<span class="arrow"></span></a>
							<ul class="drop-menu">
								<li><a href="${pageContext.request.contextPath }/user_toChange.action">资料管理</a></li>
								<li><a href="${pageContext.request.contextPath }/to_changePwd.action">修改密码</a></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath }/cart_myCart.action">购物车</a></li>
						<li><a href="${pageContext.request.contextPath }/order_showById.action">我的订单</a></li>
					</ul>
				</div>
				<div class="hidden-l hidden-s xm3 xb3">
					<div class="text-red text-big icon-phone height-large text-right">
						热线 400 1234567</div>
				</div>

			</div>

		</div>

	</div>

</div>
