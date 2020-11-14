package com.netclass.problem;

public class NumTower {
	public static void main(String[] args) {
		int n =5;
		int[][] tower = {
				{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}
		};
		int result = GetMaxSum(n,tower);
		System.out.println(result);
	}

	private static int GetMaxSum(int n, int[][] tower) {

		// TODO Auto-generated method stub
		int[][] dp = new int[n+1][n+1];
		dp[1][1]=tower[0][0];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j]=tower[i-1][j-1]+Math.max(dp[i-1][j],dp[i-1][j-1]);
			}
		}
		
		int sum =0;
		for (int i = 0; i < dp.length; i++) {
			if(dp[n][i]>sum)sum=dp[n][i];
		}
		return sum;
	}

}
