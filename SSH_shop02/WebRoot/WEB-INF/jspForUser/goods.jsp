<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags" %>
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

  <div><ul class="bread"><li><a href="../index.html" class="icon-home" herf="http://www.aoyeah.cn/index.html"> 首页</a></li><li><a href="../qipaojiu/channel-1.html" herf="http://www.aoyeah.cn/qipaojiu/channel-1.html">商品详情</a></li></ul></div>
    <br>

    <div class="line">
        <div class="xm4">
            <div class="picture border" align="center"><img src="${pageContext.request.contextPath}/images/<s:property value="model.goodsPicture"/>" id="big" width="100%"></div>
            <br>
            <br><br>
        </div>
        <div class="xm7 xm1-move">
            <h1><s:property value="model.goodsName"/></h1>
            <hr>
            <p class="thebest"><s:property value="goods.goodsName"/></p>
            <p><s:property value="model.goodsType.goodsTypeContent"/></p>
            <p>您的专享价格: <span class="text-large text-main">￥<s:property value="model.goodsPrice"/></span> </p>
            <div><a target="_blank" class="button border-blue icon-qq" href="#"> 批发咨询 量大价优</a></div>
            <hr><br>
            <form method="post" action="${pageContext.request.contextPath }/cart_addToCart.action" class="form-inline" id="967884824">
            <input type="hidden" name="goodsId" value="<s:property value="model.goodsId"/>">
              <div class="form-group">
                  <div class="label"><label for="quantity">数量：</label></div>
                  <div class="field">
                    <input type="number" class="input" name="count" id="accountnum" value="1">
                  </div>
              </div>
              <div class="form-group">库存：993</div>
              <p></p>
              <div>
                <input type="submit" value="加入购物车" class="button bg-main">
                <a class="button border-main" href="cart.html">立即购买</a>
              </div>
            </form>
            <br>
        </div>
    </div>
    
    <h2 class="text-main icon-caret-right"> 商品详情</h2>
    <hr>
    <div class="detail text-center">
     <!--  <p><h3>这里是文字介绍</h3></p> -->
      <p><img src="${pageContext.request.contextPath}/images/<s:property value="model.goodsPicture"/>"> </p>
    </div>
    
</div>

    <div class="layout bg footer">
      <div class="container">
          <div class="grid-big">
              <br /><br />
              <div class="xs3">
                    <div class="media media-y">
                      <div class="txt radius-circle bg-main text-main text-large">正</div><div class="media-body"><strong>100%行货正品</strong></div>
                    </div>
                </div>
                <div class="xs3">
                    <div class="media media-y">
                      <div class="txt radius-circle bg-main text-main text-large">7</div><div class="media-body"><strong>7天无理由退货</strong></div>
                    </div>
                </div>
                <div class="xs3">
                    <div class="media media-y">
                      <div class="txt radius-circle bg-main text-main text-large">30</div><div class="media-body"><strong>30天免费换货</strong></div>
                    </div>
                </div>
                <div class="xs3">
                    <div class="media media-y">
                      <div class="txt radius-circle bg-main text-main text-large icon-truck"></div><div class="media-body"><strong>168元起包邮</strong></div>
                    </div>
                </div>
            </div>
        </div>
        <br><br>
      </div>


     <!--footer 开始了-->
    <div class="layout bg-black bg-inverse">
      <div class="container">
        <div class="navbar">
          <div class="navbar-head"><button class="button bg-gray icon-navicon" data-target="#navbar-footer"></button><a href="http://www.pintuer.com" target="_blank"><img class="logo" src="${pageContext.request.contextPath}/images/logo-white.png" /></a></div>
          <div class="navbar-body nav-navicon" id="navbar-footer">
            <div class="navbar-text navbar-left hidden-s hidden-l">版权所有 &copy; <a href="#">666网上商城</a> All Rights Reserved.</div>
            <ul class="nav nav-inline navbar-right"><li><a href="http://www.pintuer.com">首页</a></li><li><a href="http://www.pintuer.com">联系我们</a></li></ul>
          </div>
        </div>
      </div>
    </div>


</body>
</html>