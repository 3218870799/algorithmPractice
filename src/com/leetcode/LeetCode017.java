package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode017 {
	
	public static void main(String[] args) {
		LeetCode017 leetcode = new LeetCode017();
		LeetCode017.Solution solution = leetcode.getSolution();
		System.out.println(solution.letterCombinations("23"));
	}

	public Solution getSolution(){
		return new Solution();
	}
		
	class Solution {
		
	    private final String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	    public List<String> letterCombinations(String digits) {
	        if (digits.length() == 0) return Collections.emptyList();
	        List<String> list = new ArrayList<>();
	        helper(list, digits, "");
	        return list;
	    }

	    private void helper(List<String> list, String digits, String ans) {
	        if (ans.length() == digits.length()) {
	            list.add(ans);
	            return;
	        }
	        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
	            helper(list, digits, ans + c);
	        }
	    }
	}
	
	
	class BestSolution {
	    //把每个数字当作递归的一层，每一层中先枚举一个字母，递归进入下一层，再删除这个字母，回到上一个状态，枚举下一个字母。递归结束标志是递归了digits.lengtgh层，即字母组合长度等于digits长度，递归结束得到一个符合的字母组合，加入list。等于是在循环中套递归
	    public List<String> letterCombinations(String digits) {
	        List<String> res = new ArrayList<>();
	        String oneRes = "";
	        if(digits.equals(""))return res;
	        String[] dict = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        int[] digiInt = new int[digits.length()];
	        for(int i = 0;i<digits.length();i++)
	        {
	            digiInt[i]=digits.charAt(i)-'0';
	        }
	       
	        
	        combi(digiInt,0,dict,res,oneRes);
	        return res;
	    }
	    public void combi(int[] digits, int n,String[] dict, List<String> res,String oneRes)
	    {
	        if(n==digits.length)
	        {
	            res.add(oneRes);
	            return;
	        }
	        for(int j=0;j<dict[digits[n]].length();j++)
	        {
	            oneRes = oneRes + dict[digits[n]].charAt(j);
	            combi(digits,n+1,dict,res,oneRes);
	            oneRes = oneRes.substring(0,oneRes.length()-1);
	        }
	        
	    }
	}
	
}
