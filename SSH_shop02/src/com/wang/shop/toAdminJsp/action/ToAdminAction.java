package com.wang.shop.toAdminJsp.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wang.shop.util.VCode;
/**
 * �����̨ҳ����ת��Action
 * @author Administrator
 *
 */
public class ToAdminAction extends ActionSupport{

	/**
	 * �����¼ҳ��
	 * @return
	 */
	public String login(){
		System.out.println("�����̨��¼ҳ��");
		return "login";
	}
	/**
	 * �ı�ͼƬ��֤��
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
	 * ������ӹ���Ա��ҳ��
	 * @return
	 */
	public String adminAdd(){
		System.out.println("������ӹ���Աҳ��");
		return "adminAdd";
	}
	
	/**
	 * ���������޸�ҳ��
	 * @return
	 */
	public String adminPwd(){
		System.out.println("���������޸�ҳ��");
		return "adminPwd";
	}
	/**
	 * ���������Ʒҳ��
	 * @return
	 */
	public String goodsAdd(){
		System.out.println("���������Ʒҳ��");
		return "goodsAdd";
	}
	
	public String index(){
		return "index";
	}
}
