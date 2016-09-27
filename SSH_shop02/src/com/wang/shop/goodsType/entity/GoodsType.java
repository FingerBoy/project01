package com.wang.shop.goodsType.entity;

import java.util.ArrayList;
import java.util.List;

import com.wang.shop.goods.entity.Goods;

public class GoodsType {

	private int goodsTypeId;//商品类别编号
	private String goodsTypeName;//商品类别名称
	private String goodsTypeContent;//商品类型描述
	private List<Goods> goodsList=new ArrayList<Goods>();//关联商品类
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public String getGoodsTypeContent() {
		return goodsTypeContent;
	}
	public void setGoodsTypeContent(String goodsTypeContent) {
		this.goodsTypeContent = goodsTypeContent;
	}
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
}
