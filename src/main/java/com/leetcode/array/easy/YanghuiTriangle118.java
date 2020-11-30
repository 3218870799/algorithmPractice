package com.leetcode.array.easy;

import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.util.*;

public class YanghuiTriangle118 {
    public static void main(String[] args) {
        int n = 5;
        //结果返回二维数组形式
        int[][] result2 = generate2(5);
        //lambda表达式遍历输出
        Arrays.stream(result2).forEach(arr->{
            Arrays.stream(arr).filter(i->i!=0).forEach( i ->System.out.print(i));
            System.out.println();
        });
        List<List<Integer>> result = generate(5);
    }

    /**
     * 解决：先给第一列全部赋值为1
     * 然后遍历二位数组，从第二行第二个开始，每一个等于上一行位置的加上上一行前一列位置的和
     * @param n
     * @return
     */
    public static int[][] generate2(int n) {
        int [][] result = new int[n][n];
        if (n<0){
            return result;
        }
        for (int j = 0; j < n; j++) {
            result[j][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] =  result[i-1][j-1] + result[i-1][j];
            }
        }
        return result;
    }

    /**
     * 返回List<list<Integer>>
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new  ArrayList<List<Integer>>();
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        for(int i=1; i< numRows;i++){
            List<Integer> currentList =  new ArrayList<Integer>();
            currentList.add(1);
            for (int j=1;j< i;j++){
                currentList.add( last.get(j)+last.get(j-1));
            }
            currentList.add(1);
            last = currentList;
            result.add(currentList);
        }
        return result;
    }

}
