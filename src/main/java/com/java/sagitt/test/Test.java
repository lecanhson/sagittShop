package com.java.sagitt.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
 
	private static String str1 = "Đây là chuỗi thứ nhất ";
	private static String str2 = "Đây là chuỗi thứ hai ";
	private List<String> list = new ArrayList<>();

	public static void main(String[] args) {
	
		ClassLoader loader = Test.class.getClassLoader();
        System.out.println(loader.getResource("com.java.sagitt.test/Test.class"));
	} 
}
