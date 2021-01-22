package com.leetcode.dp.medium;

public class LeetCode96numTrees {

    public static void main(String[] args) {
        System.out.printf(numTrees(5)+"");
    }

    public static int numTrees(int n) {
        //定义前i个节点有多少种不同的二叉搜索树
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] += dp[j -1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
