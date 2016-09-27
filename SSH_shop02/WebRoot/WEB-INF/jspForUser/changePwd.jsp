<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>666商城-便宜实惠go！</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <script src="${pageContext.request.contextPath}/js/respond.js"></script>
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
              <li><a href="../about/channel-1.html" herf="http://a.pintuer.com/about/channel-1.html">用户设置</a></li>
            </ul></span><span class="icon-caret-right"></span> 修改密码
          </h2>
        </div>
        
        <br /><br /><br />
      	<div  class="x6 x3-move">
          <form action="${pageContext.request.contextPath }/user_changePwd.action" class="form-x" method="post">
            <br>
            <div class="form-group">
             <div align="center" font-size="22"><strong><s:actionerror/></strong></div><br><br>
              <div class="label">
                  <label for="f_password_txt">旧密码</label></div>
              <div class="field">
                  <input type="password" class="input" id="oldpassword" name="password" maxlength="50" value="" data-validate="required:请填写旧密码" placeholder="请填写旧密码">
              </div>
            </div>
            <br>
            <div class="form-group">
              <div class="label">
                  <label for="f_password_txt">新密码</label></div>
              <div class="field">
                  <input type="password" class="input" id="newPassword" name="newPassword" maxlength="50" value="" data-validate="required:请填写新密码" placeholder="请填写新密码">
              </div>
            </div>
            <br>
            <div class="form-group">
              <div class="label">
                  <label for="f_password_txt">重复密码</label></div>
              <div class="field">
                  <input type="password" class="input" id="repassword" name="repassword" maxlength="50" value="" data-validate="required:请再次填写新密码,repeat#newPassword:两次输入的密码不一致" placeholder="请再次填写新密码">
              </div>
            </div>
            <br />
            <div class="line">
              <div class="line">
              <div class="x3 x3-move"><input type="submit" value="确认修改" class="button bg-main"></div>
              <div class="x3 x3-move">
                <a href="javascript:history.go(-1)" class="button bg-main">返回上一页</a>
              </div>
            </div>
            </div>
          </form>           
        </div>
      </div>
      <br />
    </div>
    


</body>
</html>