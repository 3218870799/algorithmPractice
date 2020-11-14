package com.leetcode.array;

import java.util.Arrays;

public class LeetCode016 {
	
	public static void main(String[] args) {
		LeetCode016 leetcode = new LeetCode016();
		LeetCode016.Solution solution = leetcode.getSolution();
		int[] nums = {-1,2,1,-4};
		int target = 1;
		int result = solution.threeSumClosest(nums, target);
		System.out.println(result);	
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int threeSumClosest(int[] nums, int target) {
	    	int len = nums.length;
	    	int MinDif = Integer.MAX_VALUE;
	    	int result = 0;
	    	for(int i=0;i<=len-3;i++){
	    		for(int j=i+1;j<=len-2;j++){
	    			for(int k=j+1;k<=len-1;k++){
	    				int tempresult = nums[i] + nums[j] + nums[k];
	    				int temp = Math.abs(tempresult-target);
	    				if(temp<MinDif){
	    					result = tempresult;
	    					MinDif = temp;
	    				}
	    			}
	    		}
	    	}
			return result;
	        
	    }
	}
	class BestSolution {
	    public int threeSumClosest(int[] nums, int target) {
	        	
	    int result = nums[0]+nums[1]+nums[2]; 
		Arrays.sort(nums);
	    for(int i = 0;i<nums.length-2;i++){
	    	int start = i+1,end=nums.length-1;
	   
	        while(start<end){
	            int tmpSum = nums[i]+nums[start]+nums[end];
	            if(Math.abs(tmpSum-target)<Math.abs(result-target))
	            	result = tmpSum;
	        	if(tmpSum < target )
	        		start++;
	        	else if(tmpSum > target)
	        		end--;
	        	else 
	        		return result;
	          
	        }
	    }
	    	return result;
	    } 
	    
	}

}
