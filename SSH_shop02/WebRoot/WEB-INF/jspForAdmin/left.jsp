<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- sidebar start -->
<div class="admin-sidebar">
	<ul class="am-list admin-sidebar-list">
		<li><a href="${pageContext.request.contextPath }/toAdmin_index.action"><span class="am-icon-home"></span>
				首页</a></li>
		<s:if test="#session.loginAdmin.role==1">
			<li class="admin-parent"><a class="am-cf"><span
					class="am-icon-file"></span> 管理员管理 <span
					class="am-icon-angle-right am-fr am-margin-right"></span></a>
				<ul class="am-list am-collapse admin-sidebar-sub am-in"
					id="collapse-nav">
					<li><a href="${pageContext.request.contextPath }/toAdmin_adminAdd.action" class="am-cf"><span
							class="am-icon-check"></span> 添加管理员<span
							class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
					<li><a href="${pageContext.request.contextPath }/admin_adminShow.action?page=1"><span
							class="am-icon-puzzle-piece"></span> 管理管理员</a></li>
				</ul></li>
		</s:if>
		<li class="admin-parent"><a class="am-cf"><span
				class="am-icon-file"></span> 商品管理 <span
				class="am-icon-angle-right am-fr am-margin-right"></span></a>
			<ul class="am-list am-collapse admin-sidebar-sub am-in"
				id="collapse-nav">
				<li><a href="${pageContext.request.contextPath }/toAdmin_goodsAdd.action" class="am-cf"><span
						class="am-icon-check"></span> 添加商品<span
						class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
				<li><a href="${pageContext.request.contextPath }/adminGoods_goodsShow.action?page=1"><span
						class="am-icon-puzzle-piece"></span> 管理商品</a></li>
			</ul></li>
		<li><a href="${pageContext.request.contextPath }/adminUser_userShow.action?page=1"><span
				class="am-icon-pencil-square-o"></span> 用户管理</a></li>
		<li><a href="${pageContext.request.contextPath }/adminOrder_orderShow.action?page=1"><span
				class="am-icon-pencil-square-o"></span> 订单管理</a></li>
		<li><a href="${pageContext.request.contextPath }/admin_logout.action"><span class="am-icon-sign-out"></span> 注销</a></li>
	</ul>

</div>
<!-- sidebar end -->