package com.leetcode.stack;

import java.util.Stack;

public class LeetCode42Trap {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        //特殊情况，无法形成低洼时
        if (height.length < 3){
            return 0;
        }
        //循环遍历数组
        for (int i = 0; i < height.length; i++) {
            //维护单调栈，当当前元素大于栈顶元素时
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                //栈顶元素出栈
                int popnum = stack.pop();
                //相同元素情况。如1,1
                while (!stack.isEmpty() && (height[i] == height[stack.peek()])){
                    stack.pop();
                }
                //计算该层水的单位
                if (!stack.isEmpty()){
                    //次栈顶元素，及左边界高度
                    int temp = height[stack.peek()];
                    //高
                    int high = Math.min(temp-height[popnum],height[i]-height[popnum]);
                    //宽
                    int wid = i - stack.peek() -1;
                    water += high * wid;
                }
            }
            //将索引入栈，继续下一轮
        }
        return water;
    }

}
