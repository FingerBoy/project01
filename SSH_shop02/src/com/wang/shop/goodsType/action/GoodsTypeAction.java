package com.wang.shop.goodsType.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.goodsType.entity.GoodsType;
import com.wang.shop.goodsType.service.GoodsTypeService;
/**
 * ��Ʒ���͵�action
 * @author Administrator
 *
 */
public class GoodsTypeAction extends ActionSupport implements ModelDriven<GoodsType>,ServletRequestAware{

	HttpServletRequest request;
	private GoodsType goodsType=new GoodsType();
	private GoodsTypeService goodsTypeService;
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	/**
	 * ͨ��������ʾ��Ʒ��Ϣ
	 * @return
	 */
	public String showByType(){
		System.out.println("�������鿴ҳ��");
		int goodsTypeId=goodsType.getGoodsTypeId();
		List<GoodsType> list=(List<GoodsType>) request.getSession().getAttribute("typeList");
		for(GoodsType g:list){
			if(g.getGoodsTypeId()==goodsTypeId){
				request.setAttribute("goodsType", g);
			}
		}
		
		return "showByType";
	}

	@Override
	public GoodsType getModel() {
		// TODO Auto-generated method stub
		return goodsType;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
}
