package com.netclass.problem;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020年3月22日
 * Description:
 *一群猴子排成一圈，按1，2，…，n依次编号。
 *然后从第1只开始数，数到第m只,把它踢出圈，
 *从它后面再开始数，再数到第m只，在把它踢出去…，
 *如此不停的进行下去，直到最后只剩下一只猴子为止，那只猴子就叫做大王。
 *要求编程模拟此过程，输入m、n, 输出最后那个大王的编号。
 */
public class MonkeyNumOff {
	public static void main(String[] args) {
/*		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();*/
		int result = GetKing(3,17);
		System.out.println(result);
	}

	private static int GetKing(int m, int n) {
		int[] monkey = new int[n+1];
		//给每个猴子编号
		for (int i = 0; i < monkey.length; i++) {
			monkey[i]= i+1;
		}
		int count =0;
		//当还剩下猴子
		while(n>0){
			//遍历每个猴子
			for (int i = 0; i < monkey.length; i++) {
				//如果该猴子没有被淘汰，计数加一
				if(monkey[i]!=0){
					count++;
					//计数慢，该猴子为需要淘汰的猴子
					if(count==m){
						//淘汰猴子，计数清零，猴子数减一
						monkey[i]=0;
						count=0;
						n--;
					}
				}
			}
		}
		for (int i = 0; i < monkey.length; i++) {
			if(monkey[i]!=0){
				//return i;
				System.out.println(i);
			}
		}
		return -1;
	}

}
