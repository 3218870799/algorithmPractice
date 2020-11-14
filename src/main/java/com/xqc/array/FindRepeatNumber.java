package com.xqc.array;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,0,2,5,3};
		System.out.println(findRepeatNumber(nums));
		System.out.println(findRepeatNumber2(nums));
		
	}

	private static int findRepeatNumber2(int[] nums) {
		int n = nums.length;
		//因为是0——n-1范围，所以将下标与元素对应，一直换到不等的那个即可
		for (int num:nums) {
			if(num<0||num>=n)
				return -1;
		}
		//利用下标交换，保证下标==元素值
		for (int i = 0; i < n; i++) {
			while(nums[i]!=i && nums[nums[i]]!=nums[i])
				swap(nums,i,nums[i]);//交换nums[i] nums[nums[i]]
			if(nums[i]!=i && nums[nums[i]]==nums[i])
				return nums[i];
		}
		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
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
