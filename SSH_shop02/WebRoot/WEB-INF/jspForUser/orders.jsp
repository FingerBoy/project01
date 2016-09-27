<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>666商城-便宜实惠go！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" />
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/pintuer.js"></script>
    <script src="${pageContext.request.contextPath }/js/respond.js"></script>
    <link type="image/x-icon" href="${pageContext.request.contextPath }/images/icon.ico" rel="shortcut icon" />
    <link href="http://www.pintuer.com/favicon.ico" rel="bookmark icon" />
</head>

<body>
   	<%@ include file="main.jsp" %>
    
  	<!--内容-->
    <div class="container">
  <br>
    
    <form class="form-x" action="/initmi/form/?action=form_buy" method="post" id="cart">
    <div class="grid-big">
        <div class="space xm10 xm1-move">
           
           <s:if test="#request.orderList==null||#request.orderList.size()==0">
           		<h3 class="padding-bottom text-center text-main text-large"> 您还没有购买东西,请先购买</h3>	
           	
           </s:if>  
           <s:else>
            <h3 class="padding-bottom border-bottom icon-caret-right"> 查看订单列表</h3>
            <br>
            <table class="table table-hover">
              <tr>
                <th>订单号</th>
                <th>用户ID</th>
                <th>下单时间</th>
                <th>收货人</th>
                <th>电话</th>
                <th>地址</th>
                <th>邮编</th>
                <th>操作</th>
              </tr>
              <s:iterator var="order" value="#request.orderList">
		              <tr>
		                <td><s:property value="#order.orderId"/></td>
		                <td><s:property value="#order.user.id"/></td>
		                <td><s:property value="#order.orderDate"/></td>
		                <td><s:property value="#order.user.username"/></td>
		                <td><s:property value="#order.tel"/></td>
		                <td><s:property value="#order.address"/></td>
		                <td><s:property value="#order.postNum"/></td>
		                <td>
		                  <a href="${pageContext.request.contextPath }/order_showByOrderId.action?orderId=<s:property value="#order.orderId"/>" class="button bg-main radius-rounded button-little">查看订单</a>
		                </td>
		              </tr>
  		      </s:iterator>
             </s:else>
            </table>
            <br><br><br><br>
        </div>
    </div>
    <br>
  </form>
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
          <div class="navbar-head"><button class="button bg-gray icon-navicon" data-target="#navbar-footer"></button><a href="http://www.pintuer.com" target="_blank"><img class="logo" src="${pageContext.request.contextPath }/images/logo-white.png" /></a></div>
          <div class="navbar-body nav-navicon" id="navbar-footer">
            <div class="navbar-text navbar-left hidden-s hidden-l">版权所有 &copy; <a href="#">666网上商城</a> All Rights Reserved.</div>
            <ul class="nav nav-inline navbar-right"><li><a href="http://www.pintuer.com">首页</a></li><li><a href="http://www.pintuer.com">联系我们</a></li></ul>
          </div>
        </div>
      </div>
    </div>


</body>
</html>
