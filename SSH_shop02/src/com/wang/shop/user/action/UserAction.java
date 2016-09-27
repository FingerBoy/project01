package com.wang.shop.user.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.user.entity.User;
import com.wang.shop.user.service.UserService;
/**
 * 用户相关信息的action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware{

	private User user=new User();
	private UserService userService;
	private String newPassword;
	HttpServletRequest request;
	//注册action
	public String regist(){
		userService.save(user);
		System.out.println("用户信息保存到数据库");
		return "regist_succ";
	}
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	//检验用户昵称是否存在
	public String checkName() throws UnsupportedEncodingException{
		System.out.println("进入ajax检验");
		String userNiName=user.getUserNiName();
		if(userService.findUserByName(userNiName)==null){
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream=new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		
		return "ajax_succ";
	}
	/**
	 * 用户登录方法
	 * @return
	 */
	public String login(){
		System.out.println("进入登录检验");
		User u=userService.findUserForLogin(user);
		if(u!=null){
			//将用户名存入到session域中
			request.getSession().setAttribute("loginName", u);;
			//System.out.println(user.getUserNiName());
			return "login_succ";
		}
		this.addActionError("用户名或密码错误,请重新登陆");
		return "login_fail";
	}
	/**
	 * 退出当前用户方法
	 * @return
	 */
	public String logout(){
		request.getSession().removeAttribute("loginName");
		System.out.println("退出当前用户");
		return "logout_succ";
	}
	/**
	 * 进入到修改用户资料页面
	 * @return
	 */
	public String toChange(){
		User u=(User)request.getSession().getAttribute("loginName");
		
			user=userService.findUserByName(u.getUserNiName());
			request.setAttribute("user", user);
			return "user_change";
		
	}
	public String changeUser(){
		user.setPasswordok(user.getPassword());
		userService.updateUser(user);
		return "changeUser_succ";
		//return null;
	}
	/**
	 * 修改密码
	 * @return
	 */
	public String changePwd(){
		User u=(User)request.getSession().getAttribute("loginName");
		 if(userService.checkAndUpdatePwd(user.getPassword(), newPassword, u.getUserNiName())){
			System.out.println("修改密码成功");	
				return "pwd_change";
		}else{
			System.out.println("密码输入错误");
			this.addActionError("原始密码输入错误");
			return "pwd_chang_fail";
		}
		
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
