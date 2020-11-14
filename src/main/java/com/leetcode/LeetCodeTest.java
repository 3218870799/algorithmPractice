package com.leetcode;

public class LeetCodeTest {
	
	public static void main(String[] args) {
		LeetCodeTest l = new LeetCodeTest();
		LeetCodeTest.Solution solution = l.getSolution();
		solution.test();
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution{
		public void test(){
			
			System.out.println("This is a Test!");
		}
	}

	
}
