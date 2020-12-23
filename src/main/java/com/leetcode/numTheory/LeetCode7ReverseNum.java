package com.leetcode.numTheory;

public class LeetCode7ReverseNum {
    /**
     * 输入 ： 123  输出：321
     * 输入：-123  输出 ：-321
     * 如果溢出，则输出0
     * 反转数字
     * @param
     */
    public static void main(String[] args) {
        int in  = -1999999999;
        long ans =0;
        int MAXINT = 0x7fffffff;
        int MININT = 0x80000000;
        while(in!=0){
            ans = ans*10 + (in%10);
            in/=10;
        }
        if(ans<MININT || ans>MAXINT){
            ans = 0;
        }
        System.out.println(ans);

    }
}
