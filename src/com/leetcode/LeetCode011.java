package com.leetcode;

public class LeetCode011 {
	
	public static void main(String[] args) {
		LeetCode011 leetcode = new LeetCode011();
		LeetCode011.Solution solution = leetcode.getSolution();
		int[] arr = {1,8,6,2,5,4,8,3,7}; 
		int result =  solution.maxArea(arr);
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int maxArea(int[] height) {
	    	int MaxArea = 0;
	    	
	    	for(int i=0;i<height.length-1;i++){
	    		for(int j=i+1;j<height.length;j++){
	    			int area = Math.min(height[i], height[j]) * (j-i);
	    			if(area>=MaxArea){
	    				MaxArea = area;
	    			}
	    		}
	    	}
			return MaxArea;
	        
	    }
	}
	class BestSolution {
	    public int maxArea(int[] height) {
	       int length = height.length;
		   int maxAres = (length-1)*Math.min(height[0],height[length-1]);
		   int temp = 0;
		   int left = 0;
		   int right = length-1;
		   while(left<right){
			   int temMax = (right-left)*Math.min(height[right],height[left]);
			   if(temMax>maxAres) maxAres = temMax;
			   if(height[left]<height[right]){
				   temp = left;
				   while(height[temp]>=height[left]&&left<right){
					   left++;
				   }
			   }
			   else{
				   temp = right;
				   while(height[temp]>=height[right]&&left<right){
					   right--;
				   }
			   }
		   }
	        
		   return maxAres;
	    }
	}

}
