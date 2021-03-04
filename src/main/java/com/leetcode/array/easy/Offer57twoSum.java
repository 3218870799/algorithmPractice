package com.leetcode.array.easy;

public class Offer57twoSum {





    public int[] twoSumByDoublePoint(int[] nums, int target) {
        int x =0,y=nums.length-1;
        while (x < y) {
            int s = nums[x] + nums[y];
            if (s == target){
                return new int[]{nums[x],nums[y]};
            }else if (s < target){
                x++;
            }else if (s > target){
                y--;
            }
        }
        return new int[0];
    }
}
