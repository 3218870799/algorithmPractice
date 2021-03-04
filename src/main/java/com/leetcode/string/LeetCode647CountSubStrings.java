package com.leetcode.string;

public class LeetCode647CountSubStrings {

    public static void main(String[] args) {
        String a = "aaa";
        int resutl = countSubstringsByCenterExpansion(a);
    }
    public int countSubstringsByManacher(String s) {
        int n = s.length();
        //重新处理字符串，以$开头，以!结尾，中间字符加入#
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');
        //设f(i)为以s的第i位为回文中心可以扩展出的最大回文半径
        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }
        return ans;
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
