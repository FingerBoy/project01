package com.wang.shop.cart.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * 
 * @author Administrator
 * 
 */
public class Cart {
	
	//购物车属性
	
	//key是商品的ID,value是CartItem对象 ,为了保证有序,使用LinkedHashMap
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	//购物总计
	private Double total=0.0;
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getTotal() {
		return total;
	}
	
	//购物车方法
	
	//添加到购物车
	public void addToCart(CartItem cartItem){
		//判断购物车里是否已经存在该购物项
		//如果存在,数量增加,总计增加
		//如果不存在,添加到map.总计增加
		//1.获得商品ID
		Integer id=cartItem.getGoods().getGoodsId();
		//2.判断map中是否存在该ID
		if(map.containsKey(id)){
			//存在
			int count = map.get(id).getCount();
			count+=cartItem.getCount();
			map.get(id).setCount(count);
			
		}else{
			//不存在
			map.put(id, cartItem);
		}
		//不管购物车中有没有,都需要对total进行增加,所以写在if-else下边
		total+=cartItem.getSum();
	}
	
	//删除指定购物项
	public void removeCartItem(Integer goodsId){
		//移除当前购物项
		CartItem cartItem = map.remove(goodsId);
		//总计相应减去移除掉的商品价格
		total-=cartItem.getSum();
		
	}
	//清空购物车
	public void clearCart(){
		
		//清空map集合
		map.clear();
		//总计设为0
		total=(double) 0;
	}
	
	
}
