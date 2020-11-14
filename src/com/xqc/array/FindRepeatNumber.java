package com.xqc.array;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,0,2,5,3};
		System.out.println(findRepeatNumber(nums));
		
	}
	//方法一：使用hash表，set中只能存放不重复的数字，如果没有找到，返回-1
	private static int findRepeatNumber(int[] nums) {
		int res = -1;
		Set<Integer> set = new HashSet<Integer>();
		for(int num:nums) {
			//如果往set中注入成功，则返回true，如果重复则添加失败，返回false
			if(!set.add(num)) {
				res = num;
				break;
			}
		}
		return res;
		
	}


}
