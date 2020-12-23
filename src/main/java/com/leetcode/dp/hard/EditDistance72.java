package com.leetcode.dp.hard;

/**
 * @ClassName EditDistance72
 * @Author Administrator
 * @Date 2020/12/22/022 12:59
 * @Description distabce
 */
public class EditDistance72 {

    public static void main(String[] args) {
        int distance = getEditDistance("apple","rap");
        System.out.println(distance);
    }

    private static int getEditDistance(String s1, String s2) {
        //
        int d = 0;
        //s1的前i位与s2的前j位转换所需要的步骤数
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //s1与s2为空，不用变换
        dp[0][0] = 0;
        //一个串为空，变成另一个串则插入该串的长度的步骤
        for (int i = 0; i < s1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < s2.length()+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                //如果该位相等，则啥也不做
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    d=0;
                }else{
                    //如果不等，步数加一
                    d=1;
                }
                /*该位的步骤数等于：
                dp[i-1][j] 删除一位
                dp[i][j-1] 插入一位
                dp[i-1][j-1] 替换一位 或则 啥也不做
                 */
                dp[i][j]=Min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+d);
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static int Min(int a,int b,int c) {
        return (a<b?a:b)<c?(a<b?a:b):c;
    }
}
