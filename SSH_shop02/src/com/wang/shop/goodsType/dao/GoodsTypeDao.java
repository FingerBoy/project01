package com.wang.shop.goodsType.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wang.shop.goodsType.entity.GoodsType;

public class GoodsTypeDao extends HibernateDaoSupport{

	public List<GoodsType> findAll() {
		List<GoodsType> list=(List<GoodsType>) this.getHibernateTemplate().find("from GoodsType");
		return list;
	}

}
