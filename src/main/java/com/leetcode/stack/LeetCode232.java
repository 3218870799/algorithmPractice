package com.leetcode.stack;

import java.util.Stack;


public class LeetCode232 {
	
	
	
	class MyQueue {
		
		Stack<Integer> ma = new Stack<Integer>();
		Stack<Integer> help = new Stack<Integer>();

	    /** Initialize your data structure here. */
	    public MyQueue() {
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        while(!ma.isEmpty())
	        	help.push(ma.pop());
	        ma.push(x);
	        while(!help.isEmpty())
	        	ma.push(help.pop());
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
			return ma.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
			return ma.peek();
	        
	    }
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
			return ma.isEmpty();
	        
	    }
	}
	
	

}
