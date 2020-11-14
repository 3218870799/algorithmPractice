package com.leetcode.string;

public class LeetCode151 {
	
	public static void main(String[] args) {
		LeetCode151 leetcode = new LeetCode151();
		LeetCode151.Solution solution = leetcode.getSolution();
		String s = "   a   b ";
		
		String result = solution.reverseWords(s);
		
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	
	public class Solution {
	    public String reverseWords(String s) {
	    	if(s==null)
	    		return null;
	    	StringBuilder rev = new StringBuilder();
	    	s=s.trim();
	    	String[] arr = s.split(" ");
	    	for(int i=arr.length-1;i>0;i--){
	    		rev.append(arr[i].trim());
	    		rev.append(" ");
	    	}
	    	rev.append(arr[0]);
			return rev+"";
	        
	    }
	}

}
