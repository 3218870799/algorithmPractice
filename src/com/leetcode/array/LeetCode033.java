package com.leetcode.array;

public class LeetCode033 {
	public static void main(String[] args) {
		LeetCode033 leetcode = new LeetCode033();
		LeetCode033.Solution solution = leetcode.getSolution();
		int[] nums = {1,2,3,4,0};
		System.out.println(solution.search(nums, 0));

	}
	
	public Solution getSolution(){
		return new Solution();
	}
	/**
	 * 位运算:（操作后并不改变原数）
	 * 	左移 1 位 *2，左移 2 位 *4，左移 3 位 *8······
	 * 	右移 1 位 /2 ,右移 2 位 、4 ，右移三位 /8······
	 *
	 */
	class Solution {
	    public int search(int[] nums, int target) {
	    	int left =0,right = nums.length-1,mid;
	    	while(left<=right){
		    	mid=left + right>>>1;
	    		if(nums[mid]==target)
	    			return mid;
	    		else if(nums[mid]>=nums[left]){
	    			if(nums[left]<=target&&nums[mid]>=target)
	    				right=mid-1;
	    			else
	    				left = mid+1;
	    		}else{
	    			if(target<=nums[right]&&target>nums[mid])
	    				left = mid +1;
	    			else
	    				right = mid-1;
	    		}
	    	}
	    	return -1;
	    }
	}
}
