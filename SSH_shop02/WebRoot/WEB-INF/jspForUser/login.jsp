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
    <script src="js/jquery.js"></script> 
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
    <link type="image/x-icon" href="${pageContext.request.contextPath}/images/icon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>
    <%@ include file="main.jsp" %>
    
  	<!--内容-->
    <div class="container">
      <div class="line-small">
        <div>
          <h2 class="border-bottom padding-bottom text-main"><span class="float-right hidden-l">
            <ul class="bread">
              <li><a href="../index.html" class="icon-home" herf="http://a.pintuer.com/index.html"> 首页</a></li>
              <li><a href="../about/channel-1.html" herf="http://a.pintuer.com/about/channel-1.html">登陆</a></li>
            </ul></span><span class="icon-caret-right"></span> 登陆
          </h2>
        </div>
        
        <br /><br /><br />
      	<div  class="x6 x3-move">
          <form action="${pageContext.request.contextPath }/user_login.action" class="form-x" method="post">
            <br>
            <div align="center" ><h1 class="text-main">欢迎登陆</h1></div><br>
            <div align="center" font-size="22"><strong><s:actionerror/></strong></div><br>
            <div class="form-group">
              <div class="label">
                  <label for="f_username_txt">用户名</label></div>
              <div class="field">
                  <input type="text" class="input" id="f_username_txt" name="username" maxlength="50" value="" data-validate="required:请填写用户名" placeholder="请输入用户名">
              </div>
            </div>
            <br>
            <div class="form-group">
              <div class="label">
                  <label for="f_password_txt">密码</label></div>
              <div class="field">
                  <input type="password" class="input" id="f_password_txt" name="password" maxlength="50" value="" data-validate="required:请填写密码" placeholder="请输入密码">
              </div>
            </div>
            <br />
            <div class="line">
              <div class="x3 x3-move"><input type="submit" value="提交登陆" class="button bg-main"></div>
              <div class="x3 x2-move">
              <a href="${pageContext.request.contextPath }/to_regist.action" class="button bg-main"><span class="icon-paper-plane-o"></span> 去注册</a>
              </div>
            </div>
          </form>           
        </div>
      </div>
      <br />
    </div>
    


</body>
</html>
