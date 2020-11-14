package com.leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode225 {
	

	
	class MyStack {
		Queue myStack = new LinkedList();
		Queue helper = new LinkedList();
		
	    /** Initialize your data structure here. */
	    public MyStack() {
	    }
	    /** Push element x onto stack. */
	    public void push(int x) {
	    	while(!myStack.isEmpty())
	    		helper.add(myStack.remove());
	    	myStack.add(x);
	    	while(!helper.isEmpty())
	    		myStack.add(helper.remove());
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
			return (int) myStack.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
			return (int) myStack.peek();
	        
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
			return myStack.isEmpty();
	        
	    }
	}
	


}
