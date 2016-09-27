package com.wang.shop.cart.entity;

import com.wang.shop.goods.entity.Goods;

/**
 * 购物项的实体类
 * @author Administrator
 *
 */
public class CartItem {

	private Goods goods;//购物项中商品的信息
	private int count;//购买数量
	private double sum;//当前商品的小计
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "CartItem [goods=" + goods + ", count=" + count + ", sum=" + sum
				+ "]";
	}
	
	
}
