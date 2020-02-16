package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode015 {
	
	public static void main(String[] args) {
		LeetCode015 leetcode = new LeetCode015();
		LeetCode015.Solution solution = leetcode.getSolution();
		int[] nums = {-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
		List result = solution.threeSum(nums);
		System.out.println(result);
		
	}
	private Solution getSolution() {
		return new Solution();
	}
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	    	Arrays.sort(nums);
	    	int len = nums.length;
	    	List<List<Integer>> rev = new ArrayList<List<Integer>>();
	        if (len < 3) return rev;
	    	if(nums[0]>0 || nums[len-1]<0 ) return rev;
	    	
	    	
	    	for(int i=0;i<len;i++){
	    		for(int j=i+1;j<len;j++){
	    			for(int k=j+1;k<len;k++){
	    				if((nums[i]+nums[j]+nums[k])==0){
	    			    	List<Integer> temp =new ArrayList<Integer>();
	    					temp.add(nums[i]);
	    					temp.add(nums[j]);
	    					temp.add(nums[k]);
	    					rev.add(temp);
	    				}
	    				
	    			}
	    		}
	    	}
	    	for(int i=0;i<rev.size()-1;){
	    		if(rev.get(i).equals(rev.get(i+1))){
	    			rev.remove(rev.get(i));
	    			i=0;
	    		}else{
	    			i++;
	    		}
	    	}
			return rev;
	        
	    }
	}
	
/*	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> list = new ArrayList<>();
	        int len = nums.length;
	        if (len < 3) return list;
	        Arrays.sort(nums);
	        int max = nums[len - 1];
	        if (max < 0) return list;
	        for (int i = 0; i < len - 2; ) {
	            if (nums[i] > 0) break;
	            if (nums[i] + 2 * max < 0) {
	                while (nums[i] == nums[++i] && i < len - 2) ;
	                continue;
	            }
	            int left = i + 1, right = len - 1;
	            while (left < right) {
	                int sum = nums[i] + nums[left] + nums[right];
	                if (sum == 0) {
	                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    while (nums[left] == nums[++left] && left < right) ;
	                    while (nums[right] == nums[--right] && left < right) ;
	                } else if (sum < 0) ++left;
	                else --right;
	            }
	            while (nums[i] == nums[++i] && i < len - 2) ;
	        }
	        return list;
	    }
	}*/

}
