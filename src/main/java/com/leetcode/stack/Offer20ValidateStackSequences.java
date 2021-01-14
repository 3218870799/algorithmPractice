package com.leetcode.stack;

import java.util.Stack;

public class Offer20ValidateStackSequences {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,1,2};
        System.out.printf("" + validateStackSequences(pushA,popA));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //如果入栈与出栈长度不相同，则直接返回false
        if (pushed.length != popped.length){
            return false;
        }
        //如果为空，直接为真
        if (pushed.length <1){
            return true;
        }
        //现将第一个元素入栈
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        int i =1;
        for (int j = 0; j < popped.length; j++) {
            //取出出栈的元素
            int num = popped[j];
            //如果栈顶的元素不等于出栈元素，继续入栈
            while(stack.peek() != num && i < pushed.length){
                stack.push(pushed[i++]);
            }
            if(stack.peek() == num){
                stack.pop();
                continue;
            }
            //一直没找到与栈顶相同的
            return false;
        }
        return true;
    }

}
