package com.wang.shop.order.entity;

import com.wang.shop.goods.entity.Goods;

public class OrderItem {
	
	private Integer itemId;//������Id
	private Integer count;//��Ʒ����
	private double total;//��Ʒ�ܼ۸�
	//�������е���Ʒ
	private Goods goods;
	//�����������Ķ���
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
