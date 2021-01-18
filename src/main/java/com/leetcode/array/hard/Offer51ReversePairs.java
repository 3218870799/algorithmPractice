package com.leetcode.array.hard;

public class Offer51ReversePairs {

    public int reversePairs(int[] nums) {
        //输入数组长度
        int len = nums.length;

        if (len < 2) {
            return 0;
        }
        //将原始数组进行拷贝，因为需要修改原始数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        //辅助数组用于归并有序数组
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        //递归终止条件
        if (left == right) {
            return 0;
        }
        //当left + right很大时容易发生溢出，二分查找典型的错误
        int mid = left + (right - left) / 2;
        //分别计算左右两边进行计算
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        //计算合并时逆序数对的数量
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        //返回结果逆序对为左边的+右边的 + 合并时的
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        //分别指向两个有序对的第一个元素
        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
