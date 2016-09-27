package com.wang.shop.goods.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.goods.entity.Goods;
import com.wang.shop.goods.service.GoodsService;
import com.wang.shop.util.PageBean;
/**
 * 与商品相关的action
 * @author Administrator
 *
 */
public class GoodsAction extends ActionSupport implements ModelDriven<Goods>,ServletRequestAware{

	private GoodsService goodsService;
	private Goods goods=new Goods();
	HttpServletRequest request;
	
	private int page;
	/**
	 * 展示所有商品
	 * @return
	 */
	public String showAll(){
		//List<Goods> gList=goodsService.findAll();
		PageBean<Goods> pagebean=goodsService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pagebean);
		return "findAll_succ";
	}
	/**
	 * 根据分类显示商品
	 * @return
	 */
	public String showGoods(){
		goods=goodsService.findById(goods.getGoodsId());
		
		return "showGoods";
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}


	@Override
	public Goods getModel() {
		return goods;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage() {
		return page;
	}
}
