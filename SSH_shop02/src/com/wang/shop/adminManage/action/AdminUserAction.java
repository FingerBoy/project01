package com.wang.shop.adminManage.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.goods.entity.Goods;
import com.wang.shop.user.entity.User;
import com.wang.shop.user.service.UserService;
import com.wang.shop.util.PageBean;
/**
 * 管理员对用户信息的操作Action
 * @author Administrator
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User>{

	private User user=new User();
	private UserService userService;
	private int page;
	
	/**
	 * 显示所有用户
	 * @return
	 */
	public String userShow(){
		PageBean<User> pageBean=userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "userShow";
	}
	/**
	 * 跳转到用户信息修改页面
	 * @return
	 */
	public String toUserUpdate(){
		user=userService.findById(user.getId());
		
		return "toUserUpdate";
	}
	/**
	 * 修改用户信息
	 * @return
	 */
	public String userUpdate(){
		user.setPasswordok(user.getPassword());
		System.out.println(user);
		userService.updateUser(user);
		return "userUpdate_succ";
	}
	/**
	 * 删除用户信息
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
