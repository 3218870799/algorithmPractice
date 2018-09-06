package com.xqc.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		//步骤1：初始化数组
		int[] arr={6,3,8,2,9,1};
		System.out.println("排序前数组为："+Arrays.toString(arr));
		//步骤二：插入排序
		//从未排序的序列中取出第一个
		for(int i=1;i<arr.length;i++){
			int tempdata = arr[i];
			int j;
			//寻找合适的插入位置，从后往前走，如果大与这个数则将这个数往后移动一
			for(j=i-1;j>=0;j--){
				if(arr[j]>tempdata){
					arr[j+1] = arr[j];
				}else{
					break;
				}
			}
			//寻找到合适位置，将取出的数放在该位置
			arr[j+1] = tempdata;
		}

		//步骤三：显示排序后数组
        System.out.println("排序后数组为："+Arrays.toString(arr));
	}
}
