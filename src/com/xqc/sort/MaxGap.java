package com.xqc.sort;

public class MaxGap {

	public static int maxGap(int[] nums) {
		//如果数组为空或者为一没有最大差值
		if (nums == null || nums.length < 2) {
			return 0;
		}
		
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//遍历整个数组，找到最小值和最大值
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		//最小等于最大，则数组全是一种数
		if (min == max) {
			return 0;
		}
		//各个桶是否有数进入
		boolean[] hasNum = new boolean[len + 1];
		//各个桶的最大值
		int[] maxs = new int[len + 1];
		//各个桶的最小值
		int[] mins = new int[len + 1];
		
		int bid = 0;
		for (int i = 0; i < len; i++) {
			//进桶，更新桶信息
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}
		int res = 0;
		int lastMax = maxs[0];
		int i = 1;
		//找个非空桶与左边的非空桶，用当前最小减去左边最大即为差值
		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}

	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num - min) * len / (max - min));
	}



}
