package com.leetcode.string;

public class LeetCode647CountSubStrings {

    public static void main(String[] args) {
        String a = "aaa";
        int resutl = countSubstringsByCenterExpansion(a);
    }

    //中心扩展
    static int totalCount = 0;
    public static int countSubstringsByCenterExpansion(String s) {
        if (s==null){
            return 0;
        }
        //遍历字符串，计算以i位置为中心的字符串是回文串的个数
        for (int i = 0; i < s.length(); i++) {
            //计算奇数回文串
            count(s,i,i);
            //计算偶数回文串
            count(s,i,i+1);
        }
        return totalCount;
    }
    public static void count(String s ,int i,int j){
        //以i为中心向两边扩展，如果两边相等，则是回文，加1，如果不等，再扩大也不可能是了
        while (i>=0 && j<=s.length()-1 && s.charAt(i) == s.charAt(j)){
            i--;j++;
            totalCount++;
        }
    }

    public int countSubstrings(String s) {
        int n = s.length();
        //定义从第i到第j位置的子串是不是回文串
        boolean[][] dp = new boolean[n][n];
        //记录回文串的个数
        int count = 0;
        //当只有一个字符时，全部为ture
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        //当只有两个字符时
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }
        //当三个字符以上时
        for (int len = 3; len <= n; len++) {
            //起点为i，终点为j，跨度为len的
            for (int i = 0; i + len <=n ; i++) {
                int j = i + len -1;
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
