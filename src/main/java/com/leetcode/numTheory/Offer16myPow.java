package com.leetcode.numTheory;

public class Offer16myPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        //特判
        if(x == 0){
            return 0;
        }
        long b = n;
        double result = 1.0;
        //如果小于零，求
        if (b < 0){
            b = -b;
            x = 1/x;
        }
        while(b > 0){
            //如果是奇数
            if ((b%1)==1){
                result *= x;
            }
            //底数平方，指数减半
            b >>=1;
            x *=x;
        }
        return result;
    }

}
