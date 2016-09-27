package com.wang.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wang.shop.order.entity.Order;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.MathUtils;
import com.wang.shop.util.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {

	public void save(Order order) {
		order.setAllTotal(MathUtils.getRound(order.getAllTotal(), 2));
		this.getHibernateTemplate().save(order);
	}

	public List<Order> findById(int id) {
		String hql="from Order o where o.user.id=? order by o.orderDate desc";
		List<Order> list=(List<Order>) this.getHibernateTemplate().find(hql, id);
		return list;
	}

	public Order showByOrderId(Integer orderId) {
		Order order = this.getHibernateTemplate().get(Order.class,orderId );
		
		return order;
	}

	public int findAllCount() {
		String hql="select count(*) from Order";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Order> findAll(int begin, int limit) {
		String hql="from Order";
		List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{}, begin, limit));
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	public void deleteOrder(Integer orderId) {

		HibernateTemplate template = this.getHibernateTemplate();
		Order order = template.get(Order.class, orderId);
		System.out.println("order:::"+order);
		template.delete(order);
		
	}

}
