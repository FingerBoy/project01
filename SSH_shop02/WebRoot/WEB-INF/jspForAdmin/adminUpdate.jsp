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
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改</strong> / <small>修改管理员账号信息</small></div>
    </div>

    <hr/>

    <div class="am-g">
      <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath }/admin_adminUpdate.action" method="post">
        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员ID / adminId</label>
          <div class="am-u-sm-9">
            <input type="text" id="adminId" name="id" placeholder="输入你的管理员ID / adminID" value="<s:property value="#request.admin.id"/>" readonly="true">
          </div>
        </div>
		<input type="hidden" name="password" value="<s:property value="#request.admin.password"/>">
        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员姓名 / UserName</label>
          <div class="am-u-sm-9">
            <input type="text" id="adminName" name="name" placeholder="输入你的管理员姓名 / adminName" value="<s:property value="#request.admin.name"/>" readonly="true">
          </div>
        </div>

        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员身份证 / UserName</label>
          <div class="am-u-sm-9">
            <input type="number" id="adminCard" name="idCard" placeholder="输入你的管理员身份证 / adminCard" value="<s:property value="#request.admin.idCard"/>" readonly>
          </div>
        </div>

        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员电子邮箱</label>
          <div class="am-u-sm-9">
            <input type="email" id="adminEmail" name="email" placeholder="输入你的管理员电子邮箱 / adminEmail" value="<s:property value="#request.admin.email"/>">
          </div>
        </div>
        
        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员联系电话</label>
          <div class="am-u-sm-9">
            <input type="number" id="adminPhone" name="phone" placeholder="输入你的管理员联系电话 / adminPhone" value="<s:property value="#request.admin.phone"/>">
          </div>
        </div>

        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">管理员权限</label>
          <div class="am-u-sm-9">
           <!--  <div class="am-u-sm-2 am-text-left">超级管理员</div> -->
            <s:if test="#request.admin.role==1">
              <select name="role">
                <option value="1">超级管理员</option>
                <option value="0">普通管理员</option>
              </select>
              </s:if>
            <s:else>
            	<select name="role">
                <option value="0">普通管理员</option>
                <option value="1">超级管理员</option>
              </select>
            </s:else>  
          </div>
        </div>

        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-push-3">
            <input type="submit"  class="am-btn am-btn-primary" value="保存修改">
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
