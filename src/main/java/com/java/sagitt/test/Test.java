package com.java.sagitt.test;

import com.google.common.collect.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {

	private static String str1 = "Đây là chuỗi thứ nhất ";
	private static String str2 = "Đây là chuỗi thứ hai ";

	// static int a[] = {1, 2, 3, 4, 5, 6, 7, 8};

	static int[][] spiralNumbers(int n) {
		int[][] m = new int[n][n];
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int currentDirectionIndex = 0;
		int currentRow = 0;
		int currentColumn = 0;
		int currentNum = 1;
		int tmpRow;
		int tmpColumn;
		for (int i = n * n; i > 0; i--) {
			m[currentColumn][currentRow] = currentNum;
			currentNum++;
			if (i > 1) {
				// Determine the next cell
				while (true) {
					tmpRow = currentRow + directions[currentDirectionIndex][0];
					tmpColumn = currentColumn + directions[currentDirectionIndex][1];
					if (tmpRow < 0 || tmpRow >= n || tmpColumn < 0 || tmpColumn >= n || m[tmpRow][tmpColumn] != 0) {
						currentDirectionIndex = (currentDirectionIndex + 1) % 4;
					} else {
						currentRow = tmpRow;
						currentColumn = tmpColumn;
						break;
					}
				}
			}
		}
		return m;
	}

	static int firstDuplicate(int[] a) {
		int flag = 0;
		int var = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					flag++;
					var = a[i];
				}
			}

		}
		if (flag == 0) {
			return -1;
		}
		return var;
	}

	static int centuryFromYear(int year) {
		int var = 0;
		if (year % 100 == 0) {
			var = year / 100;
		} else if (year % 100 != 0) {
			var = year / 100 + 1;
		}

		return var;

	}

	static boolean checkPalindrome(String inputString) {
		boolean check = true;
		String out = new StringBuffer(inputString).reverse().toString();
		String[] var = inputString.split("");
		String[] var2 = out.split("");
		List<String> bin = new LinkedList<String>(Arrays.asList(var));
		List<String> bin2 = new LinkedList<String>(Arrays.asList(var2));
		int total = bin.size();
		Iterator<String> itr1 = bin.iterator();
		Iterator<String> itr2 = bin2.iterator();
		int count = 0;
		while (itr1.hasNext() && itr2.hasNext()) {
			String s = itr1.next();
			String s2 = itr2.next();
			if (s.equals(s2)) {
				itr1.remove();
				itr2.remove();
				count++;
			}
		}
		if (total > count) {
			check = false;
		}

		return check;
	}

	static int adjacentElementsProduct(Integer[] inputArray) {
		int mutil = inputArray[0] * inputArray[1];
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] * inputArray[i + 1] > mutil) {
				mutil = inputArray[i] * inputArray[i + 1];
			}
		}
		return mutil;
	}

	static int shapeArea(int n) {
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			sum = sum + (i-1)*4;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(shapeArea(4));
		System.out.println("in ra");
	}

}
