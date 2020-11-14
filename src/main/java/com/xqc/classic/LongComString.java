package com.xqc.classic;

import java.util.Arrays;

public class LongComString {
	
	/**
	 * 最长公共子序列
	 * @param a
	 * @param b
	 * @return 动态规划方法
	 * 规划二维数组，比较字符相同，如果相同则把i-1.j-1的值加1
	 * 如果不同，则把两个对角的最大的值复制过来
	 */
	public static int LCS(String a,String b){
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m+1][n+1];

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				char c1 = a.charAt(i);
				char c2 = b.charAt(j);
				if(c1==c2){
					dp[i+1][j+1]=dp[i][j]+1;
				}else {
					dp[i+1][j+1]=Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		
		return dp[m][n];
	}
	/**
	 * 最长上升子序列
	 * [10,9,2,5,7,101,18]则最长上升子序列为2，3, 7, 18
	 * 使用动态规划
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums){
		
		int n = nums.length;
		//截止到某一个index的最长上升子序列
		int[] dp = new int[n];
		
		int maxLen = 0;
		
		for(int i=0;i<n;i++){
			//一个数也是上升子序列
			int len =1;
			
			for(int j=0;j<i;j++){
				//
				if(nums[j]<nums[i]){
					len=Math.max(len, dp[j]+1);
				}
			}
			//截止到i的最长长度
			dp[i]=len;
			if(dp[i]>maxLen){
				maxLen=dp[i];
			}
		}
		return maxLen;
		
	}
	/**
	 * 最长上升子序列
	 * 如果新加入的对比于原本的中间，则替换，如果在最后，则长度加一
	 * @param nums
	 * @return
	 */
	public static int lengthOfLISFunction2(int[] nums){
		int n = nums.length;
		int[] dp = new int[n];
		int len =0;
		for (int num : nums) {
			//二分收索判断num在dp中的什么地方，即下标多少，范围是0到len
			int index = Arrays.binarySearch(dp, 0, len ,num);
			//<0则没有出现过，取到应该放的地方
			//pos = 
			if(index<0){
				index = -(index+1);
			}
			//如果在中间就直接更新为这个数
			dp[index] = num;
			//这个应该插入的位置在最后
			if(index==len){
				//长度要加一
				len++;
			}
			
		}
		return len;
	}
	
	
	
	
	public static void main(String arg[]){
		String a = "abcd";
		String b = "abcd";
		System.out.println(LCS(a,b));
		
	}

}
