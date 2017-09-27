package com.java.sagitt.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
 
	private static String str1 = "Đây là chuỗi thứ nhất ";
	private static String str2 = "Đây là chuỗi thứ hai ";
	private List<String> list = new ArrayList<>();

	public static void main(String[] args) {
	/*	String var = "Hom nay la thu 3";
		int index1 = var.charAt(1);
		//String ott = (chart) index1;
		System.out.println("Ký tự tại vị trí thứ 0: " + (char) index1);
		char out = (char) index1;
		String out2 = String.valueOf(out);*/
		int out = str1.compareTo(str2);
		System.out.println("");
		
	} 
}
