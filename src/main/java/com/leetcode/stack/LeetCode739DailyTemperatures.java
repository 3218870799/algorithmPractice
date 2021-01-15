package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        //
        Deque<Integer> stack = new ArrayDeque<>();
        //定义结果数组
        int[] res = new int[T.length];
        //遍历每日温度
        for (int i = 0; i < T.length; i++) {
            //若当日温度大于栈顶温度，说明当日未升温日，栈顶一直出栈，计算差
            while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
