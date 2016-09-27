package com.wang.shop.goods.dao;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.wang.shop.goods.entity.Goods;
import com.wang.shop.util.PageHibernateCallback;

public class GoodsDao extends HibernateDaoSupport{

	public List<Goods> findAll() {
		List<Goods> list=(List<Goods>) this.getHibernateTemplate().find("from Goods");
		
		return list;
	}

	public Goods findById(int goodsId) {
		Goods goods=this.getHibernateTemplate().get(Goods.class, goodsId);
		return goods;
	}

	public int findTotalCount() {
		String hql="select count(*) from Goods";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	
	public List<Goods> findByPageId(int begin, int limit) {
		String hql="from Goods";
		List<Goods> list=(List<Goods>) this.getHibernateTemplate().execute((HibernateCallback<Goods>) new PageHibernateCallback(hql, new Object[]{}, begin, limit));
		if(list!=null&&list.size()>0){
			
			return list;
		}
		return null;
	}

	public void saveGoods(Goods goods) {
		this.getHibernateTemplate().save(goods);
	}

	public void updateGoods(Goods goods) {

		this.getHibernateTemplate().update(goods);
	}

	public void deleteGoods(int goodsId) {

		HibernateTemplate template = this.getHibernateTemplate();
		Goods goods=template.get(Goods.class, goodsId);
		template.delete(goods);
	}

}
