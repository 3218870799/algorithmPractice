package com.leetcode.string;

import java.util.List;

public class LeetCode020 {
	
	public static void main(String[] args) {
		LeetCode020 leetcode = new LeetCode020();
		LeetCode020.Solution solution = leetcode.getSolution();
		String s = "()[]{}";
		boolean result = solution.isValid(s);
		
		System.out.println(result);
	}

	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public boolean isValid(String s) {
	        char[] stack = new char[s.length() + 1];
	        int top = 1;
	        for (char c : s.toCharArray()) {
	            if (c == '(' || c == '[' || c == '{') {
	                stack[top++] = c; 
	            } else if (c == ')' && stack[--top] != '(') {
	                return false;
	            } else if (c == ']' && stack[--top] != '[') {
	                return false;
	            } else if (c == '}' && stack[--top] != '{') {
	                return false;
	            }
	        }
	        return top == 1;
	    }
	}
}
