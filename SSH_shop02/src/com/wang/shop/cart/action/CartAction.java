package com.wang.shop.cart.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.cart.entity.Cart;
import com.wang.shop.cart.entity.CartItem;
import com.wang.shop.goods.service.GoodsService;

/**
 * 购物车action
 * @author Administrator
 *
 */
public class CartAction  extends ActionSupport implements ServletRequestAware{
	//定义商品数量(接收页面的传值)
	private int count;
	//定义商品Id(接收页面传值)
	private int goodsId;
	private GoodsService goodsService;
	HttpServletRequest request;
	/**
	 * 添加到购物车
	 * @return
	 */
	public String addToCart(){
		System.out.println("count"+count+":::goodsId"+goodsId);
		CartItem cartItem=new CartItem();
		cartItem.setCount(count);
		cartItem.setGoods(goodsService.findById(goodsId));
		cartItem.setSum(count*cartItem.getGoods().getGoodsPrice());
		System.out.println(cartItem);
		Cart cart=getCart();
		cart.addToCart(cartItem);
		return "addToCart";
		/*System.out.println("count"+count+":::goodsId"+goodsId);
		return null;*/
	}

	/**
	 * 清空购物车
	 * @return
	 */
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	/**
	 * 移出购物车
	 * @return
	 */
	public String remove(){
		Cart cart=getCart();
		cart.removeCartItem(goodsId);
		return "remove";
	}
	
	public String myCart(){
		
		return "myCart";
	}
	//获得购物车对象的方法
	private Cart getCart() {
		Cart cart =(Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		return cart;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
			this.request=request;
	}
	
}
