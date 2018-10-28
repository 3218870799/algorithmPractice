package com.leetcode;

public class LeetCode007 {
	
	public static void main(String[] args) {
		LeetCode007 leetcode = new LeetCode007();
		LeetCode007.Solution solution = leetcode.getSolution();
		int result = solution.reverse(123);
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int reverse(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int lastbit = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && lastbit > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && lastbit < -8)) return 0;
	            rev = rev * 10 + lastbit;
	        }
	        return rev;
	    }
	}
	class BestSolution {
		public int reverse(int x) {
			int max = Integer.MAX_VALUE / 10;
			int min = Integer.MIN_VALUE / 10;
			int maxBit = Integer.MAX_VALUE % 10;
			int minBit = Integer.MIN_VALUE % 10;
			int result = 0;
			while (x != 0) {
				int lastBit = x % 10;
				x /= 10;
				if (result > max || (result == max && lastBit > maxBit)) {
					return 0;
				}
				if (result < min || (result == min && lastBit < minBit)) {
					return 0;
				}
				result = result * 10 + lastBit;
			}
			return result;
		}
	}
	
}
