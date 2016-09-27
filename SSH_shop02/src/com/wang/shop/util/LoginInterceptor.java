package com.wang.shop.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wang.shop.user.entity.User;

/**
 * �û�����û��Ƿ��ѵ�¼��������,���δ��¼����ת����¼ҳ����е�¼
 * 
 * @author Administrator
 * 
 */
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ý����action��name
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
