package com.leetcode.array.medium;

public class LeetCode189Rotate {

    public void rotate(int[] nums, int k) {
        //防止k的多余数组长度，旋转的就不止一圈
        k %= nums.length;
        //现将数组整个旋转
        reverseArray(nums,0,nums.length-1);
        //再将前k个进行旋转
        reverseArray(nums,0,k-1);
        //再将后面的进行旋转
        reverseArray(nums,k,nums.length);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


}
