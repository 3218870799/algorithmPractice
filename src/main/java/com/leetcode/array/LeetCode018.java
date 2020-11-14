package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode018 {
	
	public static void main(String[] args) {
		LeetCode018 leetcode = new LeetCode018();
		LeetCode018.Solution solution = leetcode.getSolution();
		
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		
		List result = solution.fourSum(nums, target);
		
		System.out.println(result);
	}

	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public List<List<Integer>> fourSum(int[] nums, int target) {
	        Arrays.sort(nums);
	        int len = nums.length;
	        if (len < 4) return Collections.emptyList();
	        int max = nums[len - 1];
	        if (4 * max < target) return Collections.emptyList();
	        return kSum(nums, 0, 4, target);
	    }

	    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (k == 2) {
	            int left = start, right = nums.length - 1;
	            while (left < right) {
	                int sum = nums[left] + nums[right];
	                if (sum == target) {
	                    List<Integer> twoSum = new LinkedList<Integer>();
	                    twoSum.add(nums[left]);
	                    twoSum.add(nums[right]);
	                    res.add(twoSum);
	                    while (nums[left] == nums[++left] && left < right) ;
	                    while (nums[right] == nums[--right] && left < right) ;
	                } else if (sum < target) ++left;
	                else --right;
	            }
	        } else {
	            int i = start, end = nums.length - (k - 1), max = nums[nums.length - 1];
	            while (i < end) {
	                if (nums[i] * k > target) return res;
	                if (nums[i] + (k - 1) * max < target) {
	                    while (nums[i] == nums[++i] && i < end) ;
	                    continue;
	                }
	                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
	                for (List<Integer> t : temp) {
	                    t.add(0, nums[i]);
	                }
	                res.addAll(temp);
	                while (nums[i] == nums[++i] && i < end) ;
	            }
	        }
	        return res;
	    }
	}

}
