package com.leetcode.dp.medium;

/**
 * @ClassName PartitionEqualSubsetSum416
 * @Author Administrator
 * @Date 2020/12/22/022 15:27
 * @Description TODO
 */
public class PartitionEqualSubsetSum416 {

    public boolean canPartition(int[] nums){
        int len = nums.length;
        //先计算sum
        int sum = 0;
        for (int num:nums) {
            sum+=num;
        }
        //如果sum是奇数，直接返回false
        if((sum & 1)==1){
            return false;
        }
        int target = sum/2;
        //对于数组前i个是否有子集使总和为j
        boolean[][] dp = new boolean[len][target+1];
        //赋值第一行，第一行只能填满容量为0的背包
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        //从第二行开始填表
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <=target ; j++) {
                //不考虑当前元素，直接从上一行抄下来
                dp[i][j] = dp[i-1][j];
                //如果当前值恰好等于当前容量
                if (nums[i]==j){
                    dp[i][j] = true;
                    continue;
                }
                //如果当前值严格小于当前容量
                if(nums[i]<j){
                    //或者上一行的值，或则上一行右边的值(考虑当前数，容量减少），其中一个成立即可
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }

        }
    return dp[len -1][target];
    }
}
