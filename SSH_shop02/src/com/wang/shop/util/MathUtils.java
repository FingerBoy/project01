package com.wang.shop.util;

public class MathUtils {

	/**
	 * 对于一个double类型四舍五入
	 * @param num 
	 * @param s  保留几位
	 * @return  返回四舍五入后的double
	 */
	public static double getRound(double num,int s){
		return Math.round(num*Math.pow(10, s))/Math.pow(10, s);
	}
}
