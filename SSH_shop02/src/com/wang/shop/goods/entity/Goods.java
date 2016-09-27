package com.wang.shop.goods.entity;

import com.wang.shop.goodsType.entity.GoodsType;

public class Goods {

	private int goodsId;//����  ��ƷID 
	private String goodsName;//��Ʒ����
	private double goodsPrice;//��Ʒ�۸�
	private String goodsPicture;//��ƷͼƬ
	private String goodsSupplier;//��Ʒ��Ӧ��
	private GoodsType goodsType;//��Ʒ����
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsPicture() {
		return goodsPicture;
	}
	public void setGoodsPicture(String goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	public String getGoodsSupplier() {
		return goodsSupplier;
	}
	public void setGoodsSupplier(String goodsSupplier) {
		this.goodsSupplier = goodsSupplier;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsPicture="
				+ goodsPicture + ", goodsSupplier=" + goodsSupplier
				+ ", goodsType=" + goodsType + "]";
	}
	
	
}
