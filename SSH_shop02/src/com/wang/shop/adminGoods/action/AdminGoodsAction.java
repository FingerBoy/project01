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
 * 管理员操作Goods商品的Action
 * @author Administrator
 *
 */
public class AdminGoodsAction extends ActionSupport implements
		ModelDriven<Goods> {

	private GoodsService goodsService;
	private Goods goods = new Goods();
	
	private int page;
	// 文件上传需要的参数
	private File upload;// 上传的文件
	private String uploadFileName;//上传的文件名陈
	private String uploadContentType;// 接收文件上传的MIME类型
	/**
	 * 添加商品
	 * @return
	 */
	public String addGoods() {
		System.out.println(uploadFileName);
		goods.setGoodsPicture(uploadFileName);
		if (upload != null) {
			// 获得文件上传的磁盘绝对路径
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/images");
				// 创建一个文件
				File diskFile = new File(realPath + File.separator
						+ uploadFileName);
				// 文件上传
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
	 * 展示商品信息
	 * @return
	 */
	public String goodsShow(){
		PageBean<Goods> pageBean=goodsService.findByPage(page);
		//将pageBean保存到值栈栈顶
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "goodsShow";
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 跳转到修改商品页面
	 * @return
	 */
	public String toGoodsUpdate(){
		goods=goodsService.findById(goods.getGoodsId());
		ServletActionContext.getRequest().setAttribute("goods", goods);
		System.out.println(goods);
		return "toGoodsUpdate";
	}
	/**
	 * 修改商品信息
	 * @return
	 */
	public String goodsUpdate(){
		System.out.println(goods);
		goods.setGoodsPicture(uploadFileName);
		if (upload != null) {
			// 获得文件上传的磁盘绝对路径
			try {
				String realPath = ServletActionContext.getServletContext()
						.getRealPath("/images");
				// 创建一个文件
				File diskFile = new File(realPath + File.separator
						+ uploadFileName);
				// 文件上传
				FileUtils.copyFile(upload, diskFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		goodsService.updateGoods(goods);
		return "goodsUpdate_succ";
	}
	/**
	 * 删除商品
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
