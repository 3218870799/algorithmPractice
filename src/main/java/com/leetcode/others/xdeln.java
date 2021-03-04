package com.leetcode.others;

import java.util.Arrays;

public class xdeln {

    public static void main(String[] args) {
        //思路：
        // 先将结果初始化最后m-n个字符，放在res中
        //从res的第一位开始，在它前面寻找最大的字符，并且替换，将最大位的下标记为max
        //下一次从max开始寻找。由于max已经被用过，防止被重复使用，就在上一轮找到max之后将其置0
        String x = "1267453";
        int n = 3;
        int len = x.length();
        char[] xCharArr = x.toCharArray();
        int reslen = len - n;
        char[] result = new char[reslen];
        //初始化
        for (int i = n,j=0; i < len && j<reslen; i++,j++) {
            result[j] = xCharArr[i];
        }
        //记录被选中的最大值的下标
        int max = 0;
        for (int i = 0; i < reslen; i++) {
            int flag = 1;
            for (int j = max; j < len - reslen + i ; j++) {
                if (result[i] <= xCharArr[j]){
                    result[i] = xCharArr[j];
                    max = j;
                    xCharArr[j] = 0;
                    flag = 0;
                }
            }
            //flag为1说明i位在初始化的情况下，就是最大的。i后面的不用比较了
            if (flag == 1)break;
        }
        Arrays.stream(result).forEach(System.out::println);
    }

}
