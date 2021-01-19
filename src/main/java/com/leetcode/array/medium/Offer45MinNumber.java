package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class Offer45MinNumber {
	
	public static void main(String[] args) {
		int[] test1 = {10,2};
		int[] test2 = {3,30,34,5,9};
		String res = minNumber(test1);
		System.out.printf(res);
		
	}
    public static String minNumber(int[] nums) {
    	List<String> strList = new ArrayList<>();
    	//将数字转换为字符串
		for (int num:nums) {
			strList.add(String.valueOf(num));
		}
		strList.sort((s1,s2)->(s1+s2).compareTo(s2 +s1));

		StringBuilder sb = new StringBuilder();
		for (String str:strList
			 ) {
			sb.append(str);
		}
    	return sb.toString();
    }
	

}
