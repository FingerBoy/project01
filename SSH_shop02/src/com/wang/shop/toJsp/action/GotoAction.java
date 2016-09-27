package com.wang.shop.toJsp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.goodsType.entity.GoodsType;
import com.wang.shop.goodsType.service.GoodsTypeService;
/**
 * 负责前台跳转页面的action
 * @author Administrator
 *
 */
public class GotoAction extends ActionSupport implements ServletRequestAware{
	

	private GoodsTypeService goodsTypeService;
	HttpServletRequest request;
	/**
	 * 跳转到网站主页
	 * @return "index"
	 * @throws Exception
	 */
	public String index() throws Exception {
		System.out.println("进入主页");
		List<GoodsType> typeList=goodsTypeService.findAll();
		//存入到session
		System.out.println(typeList.size()+"------");
		request.getSession().setAttribute("typeList", typeList);
		return "index";
	}
	/**
	 * 进入注册页面
	 * @return
	 */
	public String regist(){
		System.out.println("进入注册页面");
		return "regist";
	}
	/**
	 * 进入登录页面
	 * @return
	 */
	public String login(){
		System.out.println("进入登录页面");
		return "login";
	}
	/**
	 * 进入修改密码页面
	 * @return
	 */
	public String changePwd(){
		System.out.println("进入修改密码页面");
		return "changePwd";
	}

	/**
	 * 跳转到我的购物车
	 * @return
	 */
	public String cart(){
		System.out.println("进入我的购物车");
		return "cart";
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request=request;
	}
	
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
}
