package com.wang.shop.goodsType.service;

import java.util.List;

import com.wang.shop.goodsType.dao.GoodsTypeDao;
import com.wang.shop.goodsType.entity.GoodsType;

public class GoodsTypeService {

	private GoodsTypeDao goodsTypeDao;
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}
	public List<GoodsType> findAll() {
		return goodsTypeDao.findAll();
	}
}
