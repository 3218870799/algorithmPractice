package com.xqc.matrix;

public class ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		//指针A的行数与列数
		int aR = 0;
		int aC = 0;
		//指针B的行数与列数
		int bR = 0;
		int bC = 0;
		//行数与列数的最大值
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		
		boolean fromUp = false;
		while (aR != endR + 1) {
			
			printLevel(matrix, aR, aC, bR, bC, fromUp);
			//判断指针A与指针B怎么走
			aR = aC == endC ? aR + 1 : aR;
			aC = aC == endC ? aC : aC + 1;
			bC = bR == endR ? bC + 1 : bC;
			bR = bR == endR ? bR : bR + 1;
			fromUp = !fromUp;
		}
		
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
