package com.leetcode.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Offer59MaxSlidingWindow {
    public static void main(String[] args) {


    }

    //暴力解法，直接遍历计算窗口内的最大值，然后保存到数组中
    public ArrayList<Integer> maxSlidingWindowFunc1(int[] nums, int k) {
        //定义保存结果数组
        ArrayList<Integer> list = new ArrayList<>();
        //当窗口大小为空，或则窗口大小大于数组长度
        if (k < 1 || nums.length < k) {
            return list;
        }
        int left = 0;
        int right = k - 1;
        //窗口移动
        while (right < nums.length) {
            //计算当前窗口最大值
            int val = calcMax(left, right, nums);
            list.add(val);
            left++;
            right++;
        }
        return list;
    }

    public int calcMax(int left, int right, int[] nums) {
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
        	return new int[0];
		}
        //单调队列，用链表实现
        Deque<Integer> deque = new LinkedList<>();
        //定义返回结果数组
        int[] res = new int[nums.length - k + 1];
		//res数组的下标
		int index = 0;
		//未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
            	// [ 3,2 ]
            	deque.removeLast();
			}
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到结果数组中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
		res[index++] = deque.peekFirst();
        //窗口区间形成，i此时为右侧窗口
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
			//最大值正好等于要删除的那个元素
            if (deque.peekFirst() == nums[i - k]) {
            	deque.removeFirst();
			}
            //删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
            	deque.removeLast();
			}
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            res[index++] = deque.peekFirst();
        }
        return res;
    }


}
