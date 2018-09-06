package com.xqc.sort;

import java.util.Arrays;

public class BubleSort {
	public static void main(String[] args) {
		//步骤1：初始化数组
		int[] arr={6,3,8,2,9,1};
		System.out.println("排序前数组为："+Arrays.toString(arr));
		//步骤二：冒泡排序
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
		//步骤三：显示排序后数组
        System.out.println("排序后数组为："+Arrays.toString(arr));
	}
}
