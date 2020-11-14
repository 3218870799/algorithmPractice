package com.leetcode;

/**
 * 
 * ??????????????
 * 
 *
 */
public class LeetCode008 {
	
	public static void main(String[] args) {
		LeetCode008 leetcode = new LeetCode008();
		LeetCode008.Solution solution = leetcode.getSolution();
		System.out.println(solution.myAtoi("-91283472332"));
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public int myAtoi(String str) {

			if(str == null || str.length()==0) return 0;
	    	
	    	char[] s = str.trim().toCharArray();
	    	int i=0;
	    	boolean isNegative = false;
	    	if(s[0]=='+'){
	    		i++;
	    	}else if(s[0] == '-' ){
	    		i++;
	    		isNegative = true;
	    	}
	    	int rev = 0;
	    	for(;i<s.length;i++){
	    		char c = s[i];
	    		if(c<'0' || c>'9') break;
	    		
    			rev*=10;
    			int lastBit = c-'0';
    			
    			if(isNegative){
    				rev-=lastBit;
        			if(rev<Integer.MIN_VALUE) 
        				return Integer.MIN_VALUE;
    			}else{
        			rev+=lastBit;
    				if(rev > Integer.MAX_VALUE ) 
    					return Integer.MAX_VALUE;

    			}
	    	}
			return rev;
	    }
	}

}
