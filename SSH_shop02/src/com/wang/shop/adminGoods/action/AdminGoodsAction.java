package com.wang.shop.adminGoods.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wang.shop.admin.entity.Admin;
import com.wang.shop.goods.entity.Goods;
import com.wang.shop.goods.service.GoodsService;
import com.wang.shop.util.PageBean;
/**
 * ����Ա����Goods��Ʒ��Action
 * @author Administrator
 *
 */
public class AdminGoodsAction extends ActionSupport implements
		ModelDriven<Goods> {

	private GoodsService goodsService;
	private Goods goods = new Goods();
	
	private int page;
	// �ļ��ϴ���Ҫ�Ĳ���
	private File upload;// �ϴ����ļ�
	private String uploadFileName;//�ϴ����ļ�����
	private String uploadContentType;// �����ļ��ϴ���MIME����
	/**
	 * �����Ʒ
	 * @return
	 */
	public String addGoods() {
		System.out.println(uploadFileName);
		goods.setGoodsPicture(uploadFileName);
		if (upload != null) {
			// ����ļ��ϴ��Ĵ��̾���·��
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/images");
				// ����һ���ļ�
				File diskFile = new File(realPath + File.separator
						+ uploadFileName);
				// �ļ��ϴ�
				FileUtils.copyFile(upload, diskFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(goods);
		goodsService.saveGoods(goods);
		return "addGoods_succ";
	}

	/**
	 * չʾ��Ʒ��Ϣ
	 * @return
	 */
	public String goodsShow(){
		PageBean<Goods> pageBean=goodsService.findByPage(page);
		//��pageBean���浽ֵջջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "goodsShow";
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * ��ת���޸���Ʒҳ��
	 * @return
	 */
	public String toGoodsUpdate(){
		goods=goodsService.findById(goods.getGoodsId());
		ServletActionContext.getRequest().setAttribute("goods", goods);
		System.out.println(goods);
		return "toGoodsUpdate";
	}
	/**
	 * �޸���Ʒ��Ϣ
	 * @return
	 */
	public String goodsUpdate(){
		System.out.println(goods);
		goods.setGoodsPicture(uploadFileName);
		if (upload != null) {
			// ����ļ��ϴ��Ĵ��̾���·��
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/images");
				// ����һ���ļ�
				File diskFile = new File(realPath + File.separator
						+ uploadFileName);
				// �ļ��ϴ�
				FileUtils.copyFile(upload, diskFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		goodsService.updateGoods(goods);
		return "goodsUpdate_succ";
	}
	/**
	 * ɾ����Ʒ
	 * @return
	 */
	public String goodsDelete(){
		goodsService.deleteGoods(goods.getGoodsId());
		
		return "goodsDelete_succ";
	}
	
	@Override
	public Goods getModel() {
		// TODO Auto-generated method stub
		return goods;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
