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
 * �û������Ϣ��action
 * @author Administrator
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware{

	private User user=new User();
	private UserService userService;
	private String newPassword;
	HttpServletRequest request;
	//ע��action
	public String regist(){
		userService.save(user);
		System.out.println("�û���Ϣ���浽���ݿ�");
		return "regist_succ";
	}
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	//�����û��ǳ��Ƿ����
	public String checkName() throws UnsupportedEncodingException{
		System.out.println("����ajax����");
		String userNiName=user.getUserNiName();
		if(userService.findUserByName(userNiName)==null){
			inputStream=new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream=new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		
		return "ajax_succ";
	}
	/**
	 * �û���¼����
	 * @return
	 */
	public String login(){
		System.out.println("�����¼����");
		User u=userService.findUserForLogin(user);
		if(u!=null){
			//���û������뵽session����
			request.getSession().setAttribute("loginName", u);;
			//System.out.println(user.getUserNiName());
			return "login_succ";
		}
		this.addActionError("�û������������,�����µ�½");
		return "login_fail";
	}
	/**
	 * �˳���ǰ�û�����
	 * @return
	 */
	public String logout(){
		request.getSession().removeAttribute("loginName");
		System.out.println("�˳���ǰ�û�");
		return "logout_succ";
	}
	/**
	 * ���뵽�޸��û�����ҳ��
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
	 * �޸�����
	 * @return
	 */
	public String changePwd(){
		User u=(User)request.getSession().getAttribute("loginName");
		 if(userService.checkAndUpdatePwd(user.getPassword(), newPassword, u.getUserNiName())){
			System.out.println("�޸�����ɹ�");	
				return "pwd_change";
		}else{
			System.out.println("�����������");
			this.addActionError("ԭʼ�����������");
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
