package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56Merge {
    public static void main(String[] args) {

    }


    public int[][] merge(int[][] intervals) {
        //传入一个二维数组，如果区间没有，直接返回
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0],end = intervals[i][1];
            //如果结果区间为空，或则结果区间最结束位置小于新区间的开始位置，不进行合并，直接放入结果中
            if (result.size()==0 || result.get(result.size()-1)[1] < start){
                result.add(new int[]{start,end});
            }else{
                //否则，合并两个区间,防止出现[[1,4],[2,3]]这种情况。
                result.get(result.size()-1)[1] = Math.max(result.get(result.size() - 1)[1], end);
            }
        }
        return result.toArray(new int[result.size()][]);
    }



}
