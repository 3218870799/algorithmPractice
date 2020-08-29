package com.xqc.bishi;

import java.util.Scanner;

public class LineNumSum {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		
		for (int i = 1; i < m; i++) {
			int sum =0;
			int end = i;
			while(sum<m){
				sum+=end;
				end++;
			}
			if(sum==m){
				System.out.print(m+"=");
				for (int j = i; j < end-1; j++) {
					System.out.print(j+"+");
				}
				System.out.println(end-1);
			}
		}
	}

}
