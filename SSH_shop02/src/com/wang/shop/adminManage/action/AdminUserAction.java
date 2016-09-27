package com.wang.shop.adminManage.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.goods.entity.Goods;
import com.wang.shop.user.entity.User;
import com.wang.shop.user.service.UserService;
import com.wang.shop.util.PageBean;
/**
 * ����Ա���û���Ϣ�Ĳ���Action
 * @author Administrator
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
	private UserService userService;
	private int page;
	
	/**
	 * ��ʾ�����û�
	 * @return
	 */
	public String userShow(){
		PageBean<User> pageBean=userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "userShow";
	}
	/**
	 * ��ת���û���Ϣ�޸�ҳ��
	 * @return
	 */
	public String toUserUpdate(){
		user=userService.findById(user.getId());
		
		return "toUserUpdate";
	}
	/**
	 * �޸��û���Ϣ
	 * @return
	 */
	public String userUpdate(){
		user.setPasswordok(user.getPassword());
		System.out.println(user);
		userService.updateUser(user);
		return "userUpdate_succ";
	}
	/**
	 * ɾ���û���Ϣ
	 * @return
	 */
	public String userDelete(){
		userService.deleteUser(user.getId());
		return "userDelete";
	}
	
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
