package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @ClassName:三数之和——leetCode15题
 * @Author qcxiao
 * @Date:2020年8月29日上午10:31:57
 * @Version:1.0
 * @Description:
 */
public class ThreeSum015 {
	
	public static void main(String[] args) {
		ThreeSum015 leetcode = new ThreeSum015();
		ThreeSum015.Solution solution = leetcode.getSolution();
		
		int[] nums = {-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
		List result = solution.threeSum(nums);
		System.out.println(result);
		
	}
	private Solution getSolution() {
		return new Solution();
	}
	/**
	 * @Author qcxiao
	 * @Date:2020年8月29日上午10:35:17
	 * @Version:1.0
	 * @Description:暴力解法
	 */
	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	    	//先排序
	    	Arrays.sort(nums);
	    	int len = nums.length;
	    	List<List<Integer>> rev = new ArrayList<List<Integer>>();
	    	//对特殊情况进行处理
	        if (len < 3) return rev;
	    	if(nums[0]>0 || nums[len-1]<0 ) return rev;
	    	//三重循环判断三数之和是否为0
	    	for(int i=0;i<len;i++){
	    		for(int j=i+1;j<len;j++){
	    			for(int k=j+1;k<len;k++){
	    				//如果等于0，将三个数构建成一个新链表，加入到结果链表中
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
	    	//遍历结果链表，去除重复的
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
	
	class Solution02 {
	    public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> rev = new ArrayList<>();
	        //特殊处理
	        int len = nums.length;
	        if (len < 3) return rev;
	        //排序
	        Arrays.sort(nums);
	        //处理
	        int max = nums[len - 1];
	        if (max < 0) return rev;
	        
	        for (int i = 0; i < len - 2; ) {
	        	//如果三个数中最小的大于零，不可能和为零
	            if (nums[i] > 0) continue;
	            //如果最小加上两倍最大依然小于零，则不可能，下一个
	            if (nums[i] + 2 * max < 0) {
	                while (nums[i] == nums[++i] && i < len - 2) ;
	                continue;
	            }
	            int left = i + 1, right = len - 1;
	            while (left < right) {
	                int sum = nums[i] + nums[left] + nums[right];
	                if (sum == 0) {
	                    rev.add(Arrays.asList(nums[i], nums[left], nums[right]));
	                    while (nums[left] == nums[++left] && left < right) ;
	                    while (nums[right] == nums[--right] && left < right) ;
	                } else if (sum < 0) ++left;
	                else --right;
	            }
	            while (nums[i] == nums[++i] && i < len - 2) ;
	        }
	        return rev;
	    }
	}

}
