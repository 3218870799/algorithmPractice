package com.leetcode;

public class LeetCode026 {
	
	public static void main(String[] args) {
		LeetCode026 leetcode = new LeetCode026();
		LeetCode026.Solution solution = leetcode.getSolution();
		
		int[] nums = {1,1,2};
		int len = solution.removeDuplicates(nums);
		
		for(int i=0;i<len;i++){
			System.out.println(nums[i]);
		}
	}

	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int removeDuplicates(int[] nums) {
	    	int len = 0;
	    	int cur = 1;
	    	while(cur<nums.length){
	    		if(nums[len] == nums[cur]){
	    			cur++;
	    		}else{
	    			len++;
	    			nums[len] = nums[cur];
	    			cur++;
	    		}
	    	}
	    	
			return len+1;
	        
	    }
	}
	
	class BestSolution {
	    public int removeDuplicates(int[] nums) {
	        int index=1;
	        for(int i=1;i<nums.length;i++){
	            if(nums[i]!=nums[i-1]){
	                nums[index]=nums[i];
	                index++;
	            }
	        }
	        return index;
	    }
	}   

}
