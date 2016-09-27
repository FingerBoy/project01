package com.wang.shop.toJsp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.goodsType.entity.GoodsType;
import com.wang.shop.goodsType.service.GoodsTypeService;
/**
 * ����ǰ̨��תҳ���action
 * @author Administrator
 *
 */
public class GotoAction extends ActionSupport implements ServletRequestAware{
	

	private GoodsTypeService goodsTypeService;
	HttpServletRequest request;
	/**
	 * ��ת����վ��ҳ
	 * @return "index"
	 * @throws Exception
	 */
	public String index() throws Exception {
		System.out.println("������ҳ");
		List<GoodsType> typeList=goodsTypeService.findAll();
		//���뵽session
		System.out.println(typeList.size()+"------");
		request.getSession().setAttribute("typeList", typeList);
		return "index";
	}
	/**
	 * ����ע��ҳ��
	 * @return
	 */
	public String regist(){
		System.out.println("����ע��ҳ��");
		return "regist";
	}
	/**
	 * �����¼ҳ��
	 * @return
	 */
	public String login(){
		System.out.println("�����¼ҳ��");
		return "login";
	}
	/**
	 * �����޸�����ҳ��
	 * @return
	 */
	public String changePwd(){
		System.out.println("�����޸�����ҳ��");
		return "changePwd";
	}

	/**
	 * ��ת���ҵĹ��ﳵ
	 * @return
	 */
	public String cart(){
		System.out.println("�����ҵĹ��ﳵ");
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
