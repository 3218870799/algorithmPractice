package com.xqc.classic;

public class KnapsackProblem {
	/**
	 * 01b背包问题,每个物品只有一个，背包容量为n，在背包中怎么装才能使装的东西价值最大
	 * @param weight
	 * @param value
	 * @param n
	 * @return 
	 *        0  1  2  3  4  5  6  7  8  9  10   重量
	 *        ————————————————————————————————————
	 *      1|
	 *      2|
	 *      dp[i][j] 背包容量为j时，可以选择前i个物品，达到最大的价值
	 *        方式1:选择第i个物品 dp[i-1][j-w[i]]+value[i],则最大=第i个物品的价值+剩余容量选择前i-1个物品所能达到的最大值
	 *        方式2：不选择第i个物品dp[i-1][j]则最大=容量为j时选择前i-1个物品所能达到的最大值
	 *   故：方程dp[i][j]=MAX(dp[i-1][j-w[i]]+value[i],dp[i-1][j]);
	 */
	private static int KnapsackProblem(int[] weight, int[] value, int n) {
		//m表示物品的数量
		int m = weight.length;
		int[][] dp = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				if(j>=weight[i]){
					dp[i][j]=Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j] );
				}else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[m][n];
		
	}
	
	
	public static void main(String[] args) {
		int[] weight = {2,2,6,5,4};
		int[] value = {6,3,5,4,6};
		System.out.println(KnapsackProblem(weight,value,10));

	}



}
