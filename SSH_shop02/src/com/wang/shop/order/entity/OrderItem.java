package com.wang.shop.order.entity;

import com.wang.shop.goods.entity.Goods;

public class OrderItem {
	
	private Integer itemId;//订单项Id
	private Integer count;//商品数量
	private double total;//商品总价格
	//订单项中的商品
	private Goods goods;
	//订单项所属的订单
	private Order order;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
