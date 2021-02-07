package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454fourSumCount {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //定义返回结果
        int count = 0;
        //存储A和B中出现的sum和出现的次数
        Map<Integer,Integer> sumAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                //sumAB.put(key, sumAB.containsKey(key) ? sumAB.get(key) + 1 : 1);
                sumAB.put(key, sumAB.getOrDefault(key,0) +1 );
            }
        }
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int key = -(C[k] + D[l]);
                if (sumAB.containsKey(key)){
                    count+=sumAB.get(key);
                }
            }
        }
        return count;
    }


}
