package com.xqc.sort;

import java.util.Arrays;

public class SeclectionSort {
	public static void main(String[] args) {
		//步骤1：初始化数组
		int[] arr={6,3,8,2,9,1};
		System.out.println("排序前数组为："+Arrays.toString(arr));
		//步骤二：选择排序
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }		

		//步骤三：显示排序后数组
        System.out.println("排序后数组为："+Arrays.toString(arr));
	}
}
