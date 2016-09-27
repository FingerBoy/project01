<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>666商城-便宜实惠go！</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
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
  <br>
    
    <form class="form-x" action="${pageContext.request.contextPath}/order_save.action" method="post" id="cart">
    <div class="grid-big">
        <div class="space xm5 xm1-move">
            <h3 class="padding-bottom border-bottom icon-caret-right"> 购物车</h3>
            <br>
            <input type="hidden" id="carttotal" name="carttotal" value="419">
           <s:if test="#session.cart.cartItems.size()!=0">
            <table class="table table-bordered">
            <tbody><tr class=""><th colspan="2">商品</th></tr>
            <s:iterator value="#session.cart.cartItems" var="c">   
	            <tr class="" height="90">
	              <td width="60"><img src="${pageContext.request.contextPath}/images/<s:property value="#c.goods.goodsPicture"/>" width="60"></td>
	              <td class="badge-corner">
	                <span class="text-red text-small"></span> <a href="qipaojiu/detail-1-22.html" target="_blank"><s:property value="#c.goods.goodsName"/></a>
	                <div class="float-right padding-top" align="right">
	                    <div class="line-big">
	                      <div class="x6"><label>商品单价：</label></div>
	                      <div class="x6"><label>¥<s:property value="#c.goods.goodsPrice"/></label></div>
	                    </div>
	                    <div class="line-big">
	                      <div class="x6"><label>修改数量：</label></div>
	                      <div class="x6"><input class="input" type="text" name="quantity" id="quantity" value="<s:property value="#c.count"/>"></div>
	                    </div>
	                </div>
	                <a class="badge bg-red icon-trash-o"  href="${pageContext.request.contextPath}/cart_remove.action?goodsId=<s:property value="#c.goods.goodsId"/>"> 删除</a>
	                </td>
	            </tr>
            </s:iterator>
           	
            
            <tr class="tablehover"><td colspan="2" align="right">总计： ¥<span id="total"><s:property value="#session.cart.total"/></span></td></tr>
            </tbody></table>
            <div class="padding-top" align="right"><a class="button border-main" href="${pageContext.request.contextPath }/cart_clearCart.action"> 清空购物车 </a></div>
            </s:if>
            <s:else>
           	 <h4 class="padding-bottom" align="center" color="red"> 亲!你的购物车没有商品哦,赶紧去买点宝贝吧~</h4>
            
            </s:else>
			
            <br>
            <h3 class="padding-bottom border-bottom icon-caret-right"> 支付及送货</h3>
            <br>
            <div class="form-group">
                <div class="label"><label for="payment">支付</label></div>
                <div class="field">
                    <div class="button-group radio">
                        <label class="button active"><input name="payment" value="余额支付" checked="checked" type="radio" data-validate="radio:请选择支付方式"><span class="icon icon-check"></span> 余额支付</label>
                        <label class="button"><input name="payment" value="现金或转账" type="radio" data-validate="radio:请选择支付方式"><span class="icon icon-check"></span> 现金或转账</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label for="shipping">送货</label></div>
                <div class="field">
                    <div class="button-group radio">
                        <label class="button active"><input name="shipping" value="快递" checked="checked" type="radio" data-validate="radio:请选择物流方式"><span class="icon icon-check"></span> 快递</label>
                        <label class="button"><input name="shipping" value="邮政" type="radio" data-validate="radio:请选择物流方式"><span class="icon icon-check"></span> 邮政</label>
                        <label class="button"><input name="shipping" value="货运" type="radio" data-validate="radio:请选择物流方式"><span class="icon icon-check"></span> 货运</label>
                    </div>
                </div>
            </div>
            <br>



        </div>
        
        <div class="space xm5 xm1-move">

            <h3 class="padding-bottom border-bottom icon-caret-right"> 收货信息</h3>
            <br>
            <div class="form-group">
                <div class="label"><label for="receive">收件人</label></div>
                <div class="field">
                  <input type="text" class="input" id="receive" name="name" value="" size="30" placeholder="收件人的真实姓名" data-validate="required:收件人不能为空">
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label for="address">地址</label></div>
                <div class="field">
                  <input type="text" class="input" id="address" name="address" value="" size="30" placeholder="详细的收件地址" data-validate="required:收件地址不能为空">
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label for="postcode">邮编</label></div>
                <div class="field">
                  <input type="text" class="input" id="postcode" name="postNum" value="" size="30" placeholder="收件地址邮编" data-validate="required:邮编不能为空,number:邮编必须为数字">
                </div>
            </div>
            <div class="form-group">
                <div class="label"><label for="tel">电话</label></div>
                <div class="field">
                  <input type="text" class="input" id="tel" name="tel" value="" size="30" placeholder="收件人手机或电话号码" data-validate="required:电话不能为空">
                </div>
            </div>
            
            <div class="padding-top" align="right"><a class="button border-main" href="${pageContext.request.contextPath }/goods_showAll.action?page=1"> 继续购物 </a> <button class="button bg-main" type="submit"> 立即下单 </button></div>
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