<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>666商城后台管理</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="alternate icon" type="image/png" href="${pageContext.request.contextPath }/assets/i/favicon.png">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/amazeui.min.css"/>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
    h3{
      font-size: 20px;
      color: #0E90D2;   
    }
  </style>
  <script type="text/javascript">
    function changeNext(){
        var a=document.getElementById("vcode");
        a.src="${pageContext.request.contextPath }/toAdmin_changeVCode.action?a="+new Date().getTime();
    }
</script>
</head>
<body>
<div class="header"> 
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
    <br>
    <h3>666商城后台管理登录</h3>
    <hr>
    <br>

    <form method="post" action="${pageContext.request.contextPath }/admin_login.action" class="am-form">
      <br> 
      	<span><h4 align="center" ><s:actionerror/></h4></span>
      <label  for="username">用户名:</label>
      <input type="text" name="name" id="adminName" value="">
      <br>
      <label for="password">密　码:</label>
      <input type="password" name="password" id="password" value="">
      <br />
      <ul class="am-avg-sm-2 am-thumbnails">
        <li>
          <label for="verify">验证码:</label>
          <input type="text" name="verify" id="verify" value="">
        </li>
        <li>
        	<br>
          <img id="vcode" margin="15px" src="${pageContext.request.contextPath }/toAdmin_changeVCode.action" /><a href="javascript:changeNext();">看不清楚,换一张</a>
        </li>
      </ul>
      <div class="am-cf">
        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="reset" name="" value="重 置" class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>
    <hr>
  </div>
</div>
</body>
</html>