package com.wang.shop.order.service;

import java.util.List;

import com.wang.shop.order.dao.OrderDao;
import com.wang.shop.order.entity.Order;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.PageBean;

public class OrderService {

	private OrderDao orderDao;
	
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	public void save(Order order) {
		orderDao.save(order);
	}


	public List<Order> findById(int id) {
		return orderDao.findById(id);
	}


	public Order showByOrderId(Integer orderId) {
		return orderDao.showByOrderId(orderId);
	}


	public PageBean<Order> findByPage(int page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);
		int limit=4;
		pageBean.setLimit(limit);
		int totalCount=orderDao.findAllCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=totalCount%limit>0?totalCount/limit+1:totalCount/limit;
		pageBean.setTotalPage(totalPage);
		
		int begin=(page-1)*limit;
		pageBean.setList(orderDao.findAll(begin,limit));
		
		return pageBean;
	}


	public void deleteOrder(Integer orderId) {

		orderDao.deleteOrder(orderId);
	}
}
