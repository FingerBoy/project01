package com.wang.shop.util;

public class MathUtils {

	/**
	 * ����һ��double������������
	 * @param num 
	 * @param s  ������λ
	 * @return  ��������������double
	 */
	public static double getRound(double num,int s){
		return Math.round(num*Math.pow(10, s))/Math.pow(10, s);
	}
}
