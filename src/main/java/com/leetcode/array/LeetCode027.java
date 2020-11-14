package com.leetcode.array;

/**
 *
 * 数组
 * 移除指定元素
 *
 */
public class LeetCode027 {
	
	public static void main(String[] args) {
		LeetCode027 leetcode = new LeetCode027();
		LeetCode027.Solution solution = leetcode.getSolution();
		
		int[] nums = {2,2,3};
		int len = solution.removeElement(nums, 3);
		
		for(int i=0;i<len;i++){
			System.out.println(nums[i]);
		}
	}

	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int removeElement(int[] nums, int val) {
	        int tail = 0;
	        for (int i = 0, len = nums.length; i < len; ++i) {
	            if (nums[i] != val) {
	                nums[tail++] = nums[i];
	            }
	        }
	        return tail;
	    }
	}
}
