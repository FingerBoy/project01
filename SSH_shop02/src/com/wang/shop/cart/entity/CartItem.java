package com.wang.shop.cart.entity;

import com.wang.shop.goods.entity.Goods;

/**
 * �������ʵ����
 * @author Administrator
 *
 */
public class CartItem {

	private Goods goods;//����������Ʒ����Ϣ
	private int count;//��������
	private double sum;//��ǰ��Ʒ��С��
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
