package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode003 {
	/*
	 * Leetcode3
	 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

		示例 1:
		
		输入: "abcabcbb"
		输出: 3 
		解释: 无重复字符的最长子串是 "abc"，其长度为 3。
		示例 2:
		
		输入: "bbbbb"
		输出: 1
		解释: 无重复字符的最长子串是 "b"，其长度为 1。
		示例 3:
		
		输入: "pwwkew"
		输出: 3
		解释: 无重复字符的最长子串是 "wke"，其长度为 3。
		     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
	 */
	
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    	Set<Character> set = new HashSet<Character>();
	    	int n = s.length();
	    	int i=0,j=0,maxlength=0;
	    	while(i<n&&j<n){
	    		if(!set.contains(s.charAt(j))){
	    			set.add(s.charAt(j++));
	    			maxlength=Math.max(maxlength, j-i);
	    		}else {
	    			//将原本set前
	    			set.remove(s.charAt(i++));
				}
	    	}
			return maxlength;
	    }
	}
	/**
	 * 
	 * Best Solution
	 *
	 */
	class BestSolution {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	        
	    }
	}

}
