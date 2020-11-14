package com.netclass.problem;

/**
 * @author xqc
 * @data 2020年4月3日
 * Description:完美数，例如6=1+2+3;
 * 找出1到100之中的完美数
 */
public class PerferNum {
	
	public static void main(String[] args) {
		for (int i = 1; i <100; i++) {
			int sum =0;
			//对每个i找到他的所有因子和
			for (int j = 1; j <i; j++) {
				if(i%j==0){
					sum+=j;
				}
			}
			if(sum==i){
				System.out.println(sum);
			}
			
			
		}
	}

}
