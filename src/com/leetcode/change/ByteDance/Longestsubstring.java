package com.leetcode.change.ByteDance;

import java.util.HashSet;
import java.util.Set;

public class Longestsubstring {
	public static void main(String[] args) {
		Longestsubstring leetcode = new Longestsubstring();
		Longestsubstring.Solution solution = leetcode.getSolution();		
	}
	private Solution getSolution() {
		return new Solution();
	}
	
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

}
