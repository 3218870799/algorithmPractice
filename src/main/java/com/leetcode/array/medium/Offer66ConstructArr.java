package com.leetcode.array.medium;

public class Offer66ConstructArr {

    public int[] constructArr(int[] a) {
        if(a ==null || a.length ==0){
            return a;
        }
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = right[len -1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * a[i-1];
        }

        for (int i = len - 2 ; i >=0 ; i--) {
            right[i] = right[i+1] * a[i+1];
        }

        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = left[i] * right[i];
        }
        return  b;
    }

}
