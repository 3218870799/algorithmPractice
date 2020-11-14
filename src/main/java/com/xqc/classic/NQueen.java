package com.xqc.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author xqc
 * @data 2020年4月1日
 * Description:
 * 在一个N*N的矩阵中将n个放在不同行不同列不同的斜的位置
 * 使用回溯算法，从开始放一个皇后，判断下一个，如果可以一直到最后，那就是一种方法
 * 如果不能到最后，就将上一个位置的皇后变成'.',改变该皇后的位置
 */
public class NQueen {
	
	public static void main(String[] args) {
		List<List<String>> result = GetNQueens(4);
		for (List<String> list : result) {
			for (String string : list) {
				System.out.println(string);
			}

		}

	}

	private static List<List<String>> GetNQueens(int n) {
		//结果
		List<List<String>> res = new ArrayList<>();
		//先用char[][]表示二维的图像
		char[][] board = new char[n][n];
		//初始化，将board全部变成‘,’
		init(board);
		//回溯的help方法
		helper(res,board,0);
		return res;
	}

	private static void init(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}
		
	}

	private static void helper(List<List<String>> res, char[][] board, int rowIndex) {
		//如果可以遍历的最后，就将该图加入到res图数组中
		if(rowIndex==board.length){
			res.add(gengerate(board));
			return;
		}
		//列从0开始
		for (int colIndex = 0; colIndex < board.length; colIndex++) {
			//如果不在同一列，不在对角线
			if(isValid(board,rowIndex,colIndex)){
				//就把该位置放上皇后
				board[rowIndex][colIndex]='Q';
				//去填下一个地方的皇后
				helper(res,board,rowIndex+1);
				//回退改成‘.’
				board[rowIndex][colIndex]='.';
			}
			
		}
		
	}
	
	private static boolean isValid(char[][] board, int rowIndex, int colIndex) {
		//该列的这一行上有皇后就冲突了，返回false
		for (int i = 0; i < rowIndex; i++) {
			if(board[i][colIndex]=='Q')return false;
		}
		//从左上到右下的对角线如果有皇后，返回false
		for (int i = rowIndex-1,j=colIndex-1; i >=0 && j>=0; i--,j--) {
			if(board[i][j]=='Q')return false;
		}
		//从右上到左下的对角线如果有皇后，返回false；
		for (int i = rowIndex-1,j=colIndex+1; i >=0 && j<board.length; i--,j++) {
			if(board[i][j]=='Q')return false;
		}
		//都没有，返回true
		return true;
	}

	//把char[][]换成list<string>
	private static List<String> gengerate(char[][] board) {
		List<String> list = new ArrayList<>();
		for (char[] row : board) {
			StringBuilder sb = new StringBuilder();
			for (char c : row) {
				sb.append(c);
			}
			list.add(sb.toString());
		}
		
		return list;
	}
	
	
	

}
