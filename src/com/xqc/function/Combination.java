package com.xqc.function;

public class Combination {
	
	public static void main(String[] args) {
		System.out.println(RecursiveComposition(5,2));
	}
	/**
	 * 从a中选出b人，返回可以选择的方法数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int RecursiveComposition(int a ,int b){
		if(b>a){
			return 0;
		}
		if(b==0){
			return 1;
		}
		return RecursiveComposition(a-1,b-1)+RecursiveComposition(a-1,b);
	}


}
