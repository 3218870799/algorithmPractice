package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode006 {
	
	public static void main(String[] args) {
		LeetCode006 leetcode = new LeetCode006();
		LeetCode006.Solution solution = leetcode.getSolution();
		String result = solution.convert("PAYPALISHIRING",3);
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class OfficeSolution {
	    public String convert(String s, int numRows) {

	        if (numRows == 1) return s;

	        List<StringBuilder> rows = new ArrayList<>();
	        for (int i = 0; i < Math.min(numRows, s.length()); i++)
	            rows.add(new StringBuilder());

	        int curRow = 0;
	        boolean goingDown = false;

	        for (char c : s.toCharArray()) {
	            rows.get(curRow).append(c);
	            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
	            curRow += goingDown ? 1 : -1;
	        }

	        StringBuilder ret = new StringBuilder();
	        for (StringBuilder row : rows) ret.append(row);
	        return ret.toString();
	    }
	}
	class Solution {
	    public String convert(String s, int numRows) {
	        if(numRows<1)
	            return "";
	        if(numRows==1)
	            return s;
	        StringBuilder[] rowStr=new StringBuilder[numRows];
	        for(int i=0; i<numRows; ++i)
	            rowStr[i]=new StringBuilder();
	        int index=0;
	        while(index<s.length()) {
	            for(int i=0; i<numRows && index<s.length(); ++i, ++index) 
	                rowStr[i].append(s.charAt(index));
	            for(int i=numRows-2; i>0 && index<s.length(); --i, ++index ) 
	                rowStr[i].append(s.charAt(index));
	        }
	        for(int i=1; i<numRows; ++i)
	            rowStr[0].append(rowStr[i]);
	        return rowStr[0].toString();
	    }
	}
	class BestSolution {
	    public String convert(String s, int numRows) {
	        if(numRows==1 || s.length()<=numRows)
	            return s;
	        
	        int i,j;
	        final int dr = (numRows - 1) << 1, n=s.length();
	        char[] res = new char[n];
	        
	        i=0;
	        for(int col=0; col<numRows-1; ++col) {
	            res[i++] = s.charAt(col);
	            for(j=dr; j<n; j+=dr) {
	                res[i++] = s.charAt(j-col);
	                if(col!=0 && j+col<s.length())
	                    res[i++] = s.charAt(j+col);
	            }
	            if (j-col < n){
	                res[i++] = s.charAt(j-col);
	            }
	        }
	        for(j=0; j+numRows-1<n; j+=dr){
	            res[i++] = s.charAt(j+numRows-1);
	        }
	        return new String(res);
	    }
	}
	
}
