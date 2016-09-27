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
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/admin.css">
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<%@ include file="top.jsp" %>

	<div class="am-cf admin-main">
		<%@ include file="left.jsp" %>

		<!-- content start -->
  <div class="admin-content">
    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改</strong> / <small>修改账号密码</small></div>
    </div>

    <hr/>

    <div class="am-g">
      <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath }/admin_updatePwd.action" method="post">
        
        <input type="hidden" id="realpwd" name="pwd" value="<s:property value="#session.loginAdmin.password"/>">
        
        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">旧密码</label>
          <div class="am-u-sm-9">
            <input type="password" id="oldpwd" name="oldpwd" placeholder="输入旧密码"><span id="pwdMes1"></span>
          </div>
        </div>

        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">新密码</label>
          <div class="am-u-sm-9">
            <input type="password" id="newpwd" name="password" placeholder="输入新密码">
          </div>
        </div>

        <div class="am-form-group">
          <label class="am-u-sm-3 am-form-label">重复密码</label>
          <div class="am-u-sm-9">
            <input type="password" id="renewpwd" name="renewpwd" placeholder="输入第二次输入新密码"><span id="pwdMes2"></span>
          </div>
        </div>
        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-push-3">
            <input  id="submit" type="submit"  class="am-btn am-btn-primary" value="修改密码">
          </div>
        </div>
        <br />
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
	<script
		src="${pageContext.request.contextPath }/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script src="${pageContext.request.contextPath }/assets/js/app.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#submit").click(function(){
				
				var realpwd=$("#realpwd").val();
				
				if($("#newpwd").val()!=$("#renewpwd").val()){
					$("#pwdMes2").html("两次密码输入不一致,请重新输入").css("color","red");
					return false;
				}else if($("#oldpwd").val()!=realpwd){
					$("#pwdMes1").html("原始密码输入错误,请重新输入").css("color","red");
					return false;
				}
				
			});
		})
	</script>
</body>
</html>

