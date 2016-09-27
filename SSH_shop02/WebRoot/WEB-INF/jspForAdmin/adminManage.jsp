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
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">管理员管理</strong> / <small>查看、修改、删除管理员信息</small></div>
    </div>


    <div class="am-g">
      <div class="am-u-sm-12">
        <form class="am-form">
          <table class="am-table am-table-striped am-table-hover table-main">
            <thead>
              <tr>
                <th class="table-id">ID</th><th class="table-title">管理员姓名</th><th class="table-type">管理员身份证</th><th class="table-author">管理员电子邮箱</th><th class="table-date">管理员联系电话</th><th class="table-set">管理员权限</th>
              </tr>
          </thead>
          <tbody>
			<s:iterator value="pageBean.list" var="admin">
				<tr>
					<td><s:property value="#admin.id"/></td>
					<td><a href="#"><s:property value="#admin.name"/></a></td>
					<td><s:property value="#admin.idCard"/></td>
					<td><s:property value="#admin.email"/></td>
					<td><s:property value="#admin.phone"/></td>
					<td>
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
								<button
									class="am-btn am-btn-default am-btn-xs am-text-secondary">
									<span class="am-icon-pencil-square-o"></span> <a
										href="${pageContext.request.contextPath }/admin_intoUpdate.action?id=<s:property value="#admin.id"/>">编辑</a>
								</button>
								<button
									class="am-btn am-btn-default am-btn-xs am-text-danger">
									<span class="am-icon-trash-o"></span> <a href="${pageContext.request.contextPath }/admin_adminDelete.action?id=<s:property value="#admin.id"/>" onclick="javascript:return confirm('确认要删除吗?');">删除</a>
								</button>
							</div>
						</div>
					</td>
				</tr>
			</s:iterator>

		</tbody>
        </table>
          <div class="am-cf">
  共 <s:property value="pageBean.totalCount"/>
				条记录
				<div class="am-fr">
					<ul class="am-pagination">
						<li class="am-active"><a
							href="${pageContext.request.contextPath }/admin_adminShow.action?page=1">首页</a></li>
						<s:if test="pageBean.page!=1">
							<li class=""><a
								href="${pageContext.request.contextPath }/admin_adminShow.action?page=<s:property value="pageBean.page-1"/>">上一页</a></li>
						</s:if>
						<s:else>
							<li class="am-disabled">上一页</li>
						</s:else>
						<s:if test="pageBean.page!=pageBean.totalPage">
							<li><a
								href="${pageContext.request.contextPath }/admin_adminShow.action?page=<s:property value="pageBean.page+1"/>">下一页</a></li>
						</s:if>
						<s:else>
							<li class="am-disabled">下一页</li>
						</s:else>
						<li><a
							href="${pageContext.request.contextPath }/admin_adminShow.action?page=<s:property value="pageBean.totalPage"/>">末页</a></li>
					</ul>
				</div>
			</div>
          <hr />
          <p>注：.....</p>
        </form>
      </div>

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

