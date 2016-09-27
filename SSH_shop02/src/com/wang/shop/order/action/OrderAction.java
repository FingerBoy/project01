package com.wang.shop.order.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.cart.entity.Cart;
import com.wang.shop.cart.entity.CartItem;
import com.wang.shop.order.entity.Order;
import com.wang.shop.order.entity.OrderItem;
import com.wang.shop.order.service.OrderService;
import com.wang.shop.user.entity.User;
import com.wang.shop.util.PaymentUtil;
/**
 * 订单ACtion
 * @author Administrator
 *
 */
public class OrderAction  extends ActionSupport implements ModelDriven<Order>,ServletRequestAware{

	private Order order=new Order();
	private OrderService orderService;
	HttpServletRequest request;
	private String pd_FrpId;
	
	
	/**
	 * 保存订单
	 * @return
	 */
	public String save(){
		
		order.setOrderDate(new Date());
		
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			return "noLogin";
		}
		order.setAllTotal(cart.getTotal());
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setTotal(cartItem.getSum());
			orderItem.setGoods(cartItem.getGoods());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		User user=(User) request.getSession().getAttribute("loginName");
		System.out.println("user:"+user);
		order.setUser(user);
		orderService.save(order);
		
		return "save_succ";
		
	}
	/**
	 * 通过用户id显示商品
	 * @return
	 */
	public String showById(){
		User user=(User) request.getSession().getAttribute("loginName");
		List<Order> orderList=orderService.findById(user.getId());
		
		
		request.setAttribute("orderList", orderList);
		//ActionContext.getContext().getValueStack().set("orders", list);
		return "showById";
	}
	
	/**
	 * 通过订单id显示
	 * @return
	 */
	public String showByOrderId(){
		System.out.println("orderId"+order.getOrderId());
		 order=orderService.showByOrderId(order.getOrderId());
		
		return "showByOrderId";
	}
	/**
	 * 完成付款的方法  
	 * @return
	 * @throws IOException
	 */
	public String pay() throws IOException{
		
		// 2.完成付款:
				// 付款需要的参数:
				String p0_Cmd = "Buy"; // 业务类型:
				String p1_MerId = "10001126856";// 商户编号:
				String p2_Order = order.getOrderId().toString();// 订单编号:
				String p3_Amt = "0.01"; // 付款金额:
				String p4_Cur = "CNY"; // 交易币种:
				String p5_Pid = ""; // 商品名称:
				String p6_Pcat = ""; // 商品种类:
				String p7_Pdesc = ""; // 商品描述:
				String p8_Url = "http://192.168.36.69:8080/shop/order_callBack.action"; // 商户接收支付成功数据的地址:
				String p9_SAF = ""; // 送货地址:
				String pa_MP = ""; // 商户扩展信息:
				String pd_FrpId = this.pd_FrpId;// 支付通道编码:
				String pr_NeedResponse = "1"; // 应答机制:
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue); // hmac
				// 向易宝发送请求:
				StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);
				
				// 重定向:向易宝出发:
				ServletActionContext.getResponse().sendRedirect(sb.toString());
		
		
		return null;
	}
	
	@Override
	public Order getModel() {
		return order;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
}
