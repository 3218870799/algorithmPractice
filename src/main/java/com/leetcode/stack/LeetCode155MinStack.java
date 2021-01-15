package com.leetcode.stack;

import java.util.Stack;

public class LeetCode155MinStack {
    //定义元素栈
    private Stack<Integer> dataStack;
    //定义辅助栈
    private Stack<Integer> minStack;


    /** initialize your data structure here. */
    public LeetCode155MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    public int top() {
        return dataStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }

}
