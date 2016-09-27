package com.wang.shop.cart.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * 
 * @author Administrator
 * 
 */
public class Cart {
	
	//���ﳵ����
	
	//key����Ʒ��ID,value��CartItem���� ,Ϊ�˱�֤����,ʹ��LinkedHashMap
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	//�����ܼ�
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
	
	//���ﳵ����
	
	//��ӵ����ﳵ
	public void addToCart(CartItem cartItem){
		//�жϹ��ﳵ���Ƿ��Ѿ����ڸù�����
		//�������,��������,�ܼ�����
		//���������,��ӵ�map.�ܼ�����
		//1.�����ƷID
		Integer id=cartItem.getGoods().getGoodsId();
		//2.�ж�map���Ƿ���ڸ�ID
		if(map.containsKey(id)){
			//����
			int count = map.get(id).getCount();
			count+=cartItem.getCount();
			map.get(id).setCount(count);
			
		}else{
			//������
			map.put(id, cartItem);
		}
		//���ܹ��ﳵ����û��,����Ҫ��total��������,����д��if-else�±�
		total+=cartItem.getSum();
	}
	
	//ɾ��ָ��������
	public void removeCartItem(Integer goodsId){
		//�Ƴ���ǰ������
		CartItem cartItem = map.remove(goodsId);
		//�ܼ���Ӧ��ȥ�Ƴ�������Ʒ�۸�
		total-=cartItem.getSum();
		
	}
	//��չ��ﳵ
	public void clearCart(){
		
		//���map����
		map.clear();
		//�ܼ���Ϊ0
		total=(double) 0;
	}
	
	
}
