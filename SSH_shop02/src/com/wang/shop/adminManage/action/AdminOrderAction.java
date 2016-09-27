package com.wang.shop.adminManage.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.order.entity.Order;
import com.wang.shop.order.service.OrderService;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.PageBean;
/**
 * 管理员对订单的操作Action
 * @author Administrator
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{

	private Order order=new Order();
	private OrderService orderService;
	private int page;
	
	/**
	 * 显示所有订单信息
	 * @return
	 */
	public String orderShow(){
		PageBean<Order> pageBean=orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "orderShow";
	}
	
	/**
	 * 删除订单
	 * @return
	 */
	public String orderDelete(){
		System.out.println(order.getOrderId());
		orderService.deleteOrder(order.getOrderId());
		return "orderDelete";
	}
	/**
	 * 显示订单具体项
	 * @return
	 */
	public String orderItemShow(){
		order=orderService.showByOrderId(order.getOrderId());
		System.out.println(order.getOrderItems().size()+"~~~~");
		return "orderItemShow";
	}
	
	@Override
	public Order getModel() {
		return order;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
