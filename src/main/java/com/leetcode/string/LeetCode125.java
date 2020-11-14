package com.leetcode.string;

public class LeetCode125 {
	
	public static void main(String[] args) {
		LeetCode125 leetcode = new LeetCode125();
		LeetCode125.Solution solution = leetcode.getSolution();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(solution.isPalindrome(s));		
		
		
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public boolean isPalindrome(String s) {
	    	if(s==null) return true;
	    	s = s.toLowerCase().replace(" ", "");
	    	
	    	char[] carr = s.toCharArray();
	    	int i=0;
	    	int j=carr.length-1;
	    	while(i<=j){
	    		if(!isChar(carr[i])){
	    			i++;
	    			continue;
	    		}
	    		if(!isChar(carr[j])){
	    			j--;
	    			continue;
	    		}
	    		if(carr[i]!=carr[j])
	    			return false;
	    		i++;
	    		j--;
	    	}
	    	
			return true;
	        
	    }
	     public boolean isChar(char c){
	         if (c<48||(c>57&&c<65)||(c>90&&c<97)||c>122){
	             return false;
	         }
	         return true;
	     }
	}
	
	
/*	class BestSolution {
	    private static final char[]charMap = new char[256];
	    static{
	        for(int i=0;i<10;i++){
	            charMap[i+'0'] = (char)(1+i);  // numeric
	        }
	        for(int i=0;i<26;i++){
	            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
	        }
	    }
	    public boolean isPalindrome(String s) {
	        char[]pChars = s.toCharArray();
	        int start = 0,end=pChars.length-1;
	        char cS,cE;
	        while(start<end){
	            cS = charMap[pChars[start]];
	            cE = charMap[pChars[end]];
	            if(cS!=0 && cE!=0){
	                if(cS!=cE)return false;
	                start++;
	                end--;
	            }else{
	                if(cS==0)start++;
	                if(cE==0)end--;
	            }
	        }
	        return true;
	    }
	}*/

}
