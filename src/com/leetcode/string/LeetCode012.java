package com.leetcode.string;

public class LeetCode012 {
	
	
	public static void main(String[] args) {
		LeetCode012 leetcode = new LeetCode012();
		LeetCode012.Solution solution = leetcode.getSolution();
		String result = solution.intToRoman(1004);
		System.out.println(result);
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public String intToRoman(int num) {
	    	if(num<1||num>3999) return null;
	        String M[] = {"", "M", "MM", "MMM"};
	        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	    }
	}
	
	class BestSolution {
	    public String intToRoman(int num){
	        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	        int index = 0;
	        StringBuffer sb = new StringBuffer();
	        while(num>0){
	            if(num>=values[index]){
	                sb.append(letters[index]);
	                num -= values[index];
	            }else{
	                index ++;
	            }
	        }
	        return sb.toString();
	    }
	}

}
