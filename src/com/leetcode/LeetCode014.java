package com.leetcode;

public class LeetCode014 {
	
	public static void main(String[] args) {
		LeetCode014 leetcode = new LeetCode014();
		LeetCode014.Solution solution = leetcode.getSolution();
		String[] strs = {};
		String result = solution.longestCommonPrefix(strs);
		System.out.println(result);
		
	}
	
	public Solution getSolution(){
		return new Solution();
	}

	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	        int len = strs.length;
	        if (len == 0) return "";
	        int minLen = Integer.MAX_VALUE;
	        for (String s : strs) 
	        	minLen = Math.min(minLen, s.length());
	        for (int j = 0; j < minLen; ++j)
	            for (int i = 1; i < len; ++i)
	                if (strs[0].charAt(j) != strs[i].charAt(j))
	                    return strs[0].substring(0, j);
	        return strs[0].substring(0, minLen);
	    }
	}
	
	class BestSolution {
	    public String longestCommonPrefix(String[] strs) {
	        if (strs.length == 0){
	            return "";
	        }else{
	            String prefix = strs[0];
	            int minLength = strs[0].length();
	            for (int i = 0; i < strs.length; i++){
	                if (strs[i].length() < minLength){
	                    prefix = strs[i];
	                    minLength = prefix.length();
	                }
	            }
	            for (int i = 0; i < strs.length; i++){
	                String temp = strs[i].substring(0, prefix.length());
	                while (!temp.equals(prefix) && prefix.length() > 0){
	                    prefix = prefix.substring(0,prefix.length() - 1);
	                    temp = temp.substring(0, temp.length() - 1);
	                }
	                if(prefix.length() == 0){
	                    break;
	                }
	            }
	            return prefix;
	        }
	    }
	} 
/*	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	    	int MinLength = Integer.MAX_VALUE;
	    	for(String s: strs){
	    		if(MinLength<s.length()){
	    			MinLength=s.length();
	    		}
	    	}
	    	String rev = new String();
	    	for(int i=0;i<MinLength;++i){
	    		char temp;
	    		if(strs.length>0){
	    			temp = strs[0].charAt(i);
	    		}else{
	    			return "";
	    		}
	    		for(int j=0;j<strs.length;++j){
	    			if(!(strs[j].charAt(i)==temp)){
	    				if(i==0){
	    					return "";
	    				}else{
	    					return rev;
	    				}
	    			}
	    		}
	    		String r = temp + "";
	    		rev+=r;
	    	}
			return rev;
	        
	    }
	}*/
}
