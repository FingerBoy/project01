package com.wang.shop.toAdminJsp.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.util.VCode;
/**
 * 负责后台页面跳转的Action
 * @author Administrator
 *
 */
public class ToAdminAction extends ActionSupport{

	/**
	 * 进入登录页面
	 * @return
	 */
	public String login(){
		System.out.println("进入后台登录页面");
		return "login";
	}
	/**
	 * 改变图片验证码
	 * @return
	 * @throws IOException
	 */
	public String changeVCode() throws IOException{
		VCode v = new VCode(90, 45);
		BufferedImage img = v.getImage();
	/*	String vcode=v.getContent();
		System.out.println(v.getContent());
		ServletActionContext.getRequest().setAttribute("vcode", );*/
		v.saveImage(img, ServletActionContext.getResponse().getOutputStream());
		return NONE;
	}
	/**
	 * 进入添加管理员的页面
	 * @return
	 */
	public String adminAdd(){
		System.out.println("进入添加管理员页面");
		return "adminAdd";
	}
	
	/**
	 * 进入密码修改页面
	 * @return
	 */
	public String adminPwd(){
		System.out.println("进入密码修改页面");
		return "adminPwd";
	}
	/**
	 * 进入添加商品页面
	 * @return
	 */
	public String goodsAdd(){
		System.out.println("进入添加商品页面");
		return "goodsAdd";
	}
	
	public String index(){
		return "index";
	}
}
