<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header class="am-topbar admin-header">
	<div class="am-topbar-brand">
		<strong>666商城</strong> <small>后台管理</small>
	</div>

	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>

	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
			<s:if test="#session.loginAdmin.role==1">
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 超级管理员:<s:property value="#session.loginAdmin.name"/> <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="${pageContext.request.contextPath }/toAdmin_adminPwd.action"><span
								class="am-icon-user"></span> 修改密码</a></li>
						<li><a href="${pageContext.request.contextPath }/admin_logout.action"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
			</s:if>
			<s:else>
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 普通管理员:<s:property value="#session.loginAdmin.name"/> <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="${pageContext.request.contextPath }/toAdmin_adminPwd.action"><span
								class="am-icon-user"></span> 修改密码</a></li>
						<li><a href="${pageContext.request.contextPath }/admin_logout.action"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
			</s:else>
			<li><a href="javascript:;" id="admin-fullscreen"><span
					class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
		</ul>
	</div>
</header>
