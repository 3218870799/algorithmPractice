package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCode013 {
	
	public static void main(String[] args) {
		LeetCode013 leetcode = new LeetCode013();
		LeetCode013.Solution solution = leetcode.getSolution();
		int result = solution.romanToInt("IV");
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int romanToInt(String s) {
	        Map<Character, Integer> map = new HashMap<>();
	        map.put('I', 1);
	        map.put('V', 5);
	        map.put('X', 10);
	        map.put('L', 50);
	        map.put('C', 100);
	        map.put('D', 500);
	        map.put('M', 1000);
	        int len = s.length();
	        int sum = map.get(s.charAt(len - 1));
	        for (int i = len - 2; i >= 0; --i) {
	            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
	                sum -= map.get(s.charAt(i));
	            } else {
	                sum += map.get(s.charAt(i));
	            }
	        }
	        return sum;
	    }
	}
	class BestSolution {
	    public int romanToInt(String s) {
	        int value = 0;
	        char[] charArray = s.toCharArray();
	        int length = charArray.length;

	        for (int i = 0; i < charArray.length; i++) {
	            char letter = charArray[i];

	            if (letter == 'I') {
	                if (i < length - 1 && charArray[i + 1] == 'V') {
	                    value += 4;
	                    i++;
	                } else if (i < length - 1 && charArray[i + 1] == 'X') {
	                    value += 9;
	                    i++;
	                } else {
	                    value += 1;
	                }
	            } else if (letter == 'V') {
	                value += 5;
	            } else if (letter == 'X') {
	                if (i < length - 1 && charArray[i + 1] == 'L') {
	                    value += 40;
	                    i++;
	                } else if (i < length - 1 && charArray[i + 1] == 'C') {
	                    value += 90;
	                    i++;
	                } else {
	                    value += 10;
	                }
	            } else if (letter == 'L') {
	                value += 50;
	            } else if (letter == 'C') {
	                if (i < length - 1 && charArray[i + 1] == 'D') {
	                    value += 400;
	                    i++;
	                } else if (i < length - 1 && charArray[i + 1] == 'M') {
	                    value += 900;
	                    i++;
	                } else {
	                    value += 100;
	                }
	            } else if (letter == 'D') {
	                value += 500;
	            } else if (letter == 'M') {
	                value += 1000;
	            }
	        }
	        return value;
	    }
	}

}
