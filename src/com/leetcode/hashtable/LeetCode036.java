package com.leetcode.hashtable;

import java.util.HashSet;

public class LeetCode036 {
	
	public static void main(String[] args) {
		LeetCode036 leetcode = new LeetCode036();
		LeetCode036.Solution solution = leetcode.getSolution();
		char[][] board = {
				{'5','.','7'},
				{'3','.','4'},
				{'1','.','2'},
		};
		System.out.println(solution.isValidSudoku(board));
		
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	class Solution {
	    public boolean isValidSudoku(char[][] board) {
	        for(int i = 0; i<9; i++){
	            HashSet<Character> rows = new HashSet<Character>();
	            HashSet<Character> columns = new HashSet<Character>();
	            HashSet<Character> cube = new HashSet<Character>();
	            for (int j = 0; j < 9;j++){
	                if(board[i][j]!='.' && !rows.add(board[i][j]))
	                    return false;
	                if(board[j][i]!='.' && !columns.add(board[j][i]))
	                    return false;
	                int RowIndex = 3*(i/3);
	                int ColIndex = 3*(i%3);
	                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
	                    return false;
	            }
	        }
	        return true;
	                
	    }
	}
}
