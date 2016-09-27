package com.wang.shop.order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.wang.shop.user.entity.User;

/**
 * ����ʵ��
 * @author Administrator
 *
 */
public class Order {

	private Integer orderId;//����Id  ����
	private String name;//�ջ�������
	private String address;//�ջ���ַ
	private String tel;//�ջ��˵绰
	private String postNum;//�ʱ�
	private double allTotal;
	private Date orderDate;//������������
	//�����������û�
	private  User user;//�����û�  ���  �û�Id
	//��������Ķ��������
	private Set<OrderItem> orderItems=new HashSet<OrderItem>();
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPostNum() {
		return postNum;
	}
	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}
	public double getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(double allTotal) {
		this.allTotal = allTotal;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", address="
				+ address + ", tel=" + tel + ", postNum=" + postNum
				+ ", allTotal=" + allTotal + ", orderDate=" + orderDate
				+ ", user=" + user + ", orderItems=" + orderItems + "]";
	}
	
	
}
