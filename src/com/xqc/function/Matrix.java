package com.xqc.function;

public class Matrix {
	
	public static int[][] MatrixMul(int[][] a, int[][] b) {
		int Arow = a.length;
		int Acol = a[1].length;
		int Brow = b.length;
		int Bcol = b[1].length;
		if(Acol!=Brow)
			return null;
		int[][] c = new int[Arow][Bcol];
		System.out.println(Arow+","+Acol+","+Brow+","+Bcol);
		for(int i=1;i<=Arow;i++)
			for(int j=1;j<=Bcol;j++)
				for(int k=1;k<=Acol;k++)
					c[i][j]+=a[i][k]*b[k][j];
		return c;
	}
	public static int[][] MatrixPow(int[][] a,int k){
		
		
		
		return a;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[2][2];
		int[][] b = new int[2][2];
		
		MatrixMul(a,b);
	}

}
