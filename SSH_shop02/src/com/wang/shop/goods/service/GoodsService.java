package com.wang.shop.goods.service;

import java.util.List;

import com.wang.shop.goods.dao.GoodsDao;
import com.wang.shop.goods.entity.Goods;
import com.wang.shop.util.PageBean;

public class GoodsService {

	private GoodsDao goodsDao;
	
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}



	public List<Goods> findAll() {

		return goodsDao.findAll();
	}



	public Goods findById(int goodsId) {
		return goodsDao.findById(goodsId);
	}



	public PageBean<Goods> findByPage(int page) {
		PageBean<Goods> pageBean =new PageBean<Goods>();
		pageBean.setPage(page);
		int limit=6;
		pageBean.setLimit(limit);
		int totalCount=goodsDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage=totalCount%limit>0?totalCount/limit+1:totalCount/limit;
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		int begin=(page-1)*limit;			
		List<Goods> list=goodsDao.findByPageId(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}



	public void saveGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.saveGoods(goods);
	}



	public void updateGoods(Goods goods) {

		goodsDao.updateGoods(goods);
	}



	public void deleteGoods(int goodsId) {

		goodsDao.deleteGoods(goodsId);
	}





	
}
