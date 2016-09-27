package com.wang.shop.cart.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.cart.entity.Cart;
import com.wang.shop.cart.entity.CartItem;
import com.wang.shop.goods.service.GoodsService;

/**
 * ���ﳵaction
 * @author Administrator
 *
 */
public class CartAction  extends ActionSupport implements ServletRequestAware{
	//������Ʒ����(����ҳ��Ĵ�ֵ)
	private int count;
	//������ƷId(����ҳ�洫ֵ)
	private int goodsId;
	private GoodsService goodsService;
	HttpServletRequest request;
	/**
	 * ��ӵ����ﳵ
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
	 * ��չ��ﳵ
	 * @return
	 */
	public String clearCart(){
		Cart cart=getCart();
		cart.clearCart();
		return "clearCart";
	}
	/**
	 * �Ƴ����ﳵ
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
	//��ù��ﳵ����ķ���
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
