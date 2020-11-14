package com.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {
	
	public static void main(String[] args) {
		LeetCode136 leetcode = new LeetCode136();
		LeetCode136.Solution solution = leetcode.getSolution();
		int[] nums = {2,1,3,2,1};
		int result = solution.singleNumber(nums);
		System.out.println(result);
	}
	private Solution getSolution() {
		return new Solution();

	}
	class Solution {
	    public int singleNumber(int[] nums) {
	        int n = nums[0];
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        map.put(n, 1);
	        for (int j = 1; j < nums.length; j++) {
	           if (!map.containsKey(nums[j])) {
	               n = n + nums[j];
	               map.put(nums[j], 1);
	           } else {
	               n = n - nums[j];
	           }
	        }
	        return n;
	    }
	}
	class BestSolution {
	    public int singleNumber(int[] nums) {
	    	int result = 0;
	    	for(int i=0;i<nums.length;i++)
	    		result^=nums[i];
			return result;
	        
	    }
	}

}
