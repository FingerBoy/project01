package com.wang.shop.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wang.shop.user.entity.User;

/**
 * 用户检测用户是否已登录的拦截器,如果未登录则跳转到登录页面进行登录
 * 
 * @author Administrator
 * 
 */
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 获得进入的action的name
		String actionName = invocation.getProxy().getActionName();
		System.out.println("actionName" + actionName);
		if (actionName.equals("user_toChange") || actionName.equals("to_changePwd")
				|| actionName.equals("cart_myCart")
				|| actionName.equals("order_showById")
				) {

			User user = (User) invocation.getInvocationContext().getSession()
					.get("loginName");
			if (user == null) {
				return "noLogin";
			}
		}

		return invocation.invoke();
	}

}
