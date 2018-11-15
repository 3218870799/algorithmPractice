package com.leetcode;

public class LeetCode021 {
	
	public static void main(String[] args) {
		LeetCode021 leetcode = new LeetCode021();
		LeetCode021.Solution solution = leetcode.getSolution();
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
