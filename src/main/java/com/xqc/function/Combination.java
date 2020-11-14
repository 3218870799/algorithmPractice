package com.xqc.function;

public class Combination {
	
	static int count=0;
	
	public static void main(String[] args) {
		//System.out.println(RecursiveComposition(5,2));
		
		int[] a={1,2,3};
		A(a,0,2);
		System.out.println(count);
		
	}
	private static void A(int[] a, int start, int end) {

		if(start==end){
			for (int x : a) {
				System.out.print(x);
			}
			count++;
			System.out.println();
		}else{
			//对于从开始到结束的每个数字
			for(int i=start;i<=end;i++){

				//每个数字都可以放在最前边一次
				swap(a,start,i);
				//将除了第一位以外剩下的进行全排列
				A(a,start+1,end);
				//防止重复，再换回来
				swap(a,start,i);
			}			
		}		
	}
	
	private static void swap(int[] a, int start, int i) {
		int temp=a[start];
		a[start]=a[i];
		a[i]=temp;
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
