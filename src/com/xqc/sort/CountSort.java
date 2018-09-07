package com.xqc.sort;

import java.util.Arrays;

public class CountSort {
	
    public static void main(String[] args)
    {
    	//初始化数组
        int[] A=new int[]{6,3,8,6,3,1,3};
        //打印
        System.out.println("排序前数组为："+Arrays.toString(A));
        //计数排序
        int[] B=countSort(A, 8);
        //打印
        System.out.println("排序后数组为："+Arrays.toString(B));
    }

    private static int[] countSort(int[] array,int k)
    {
        int[] count=new int[k+1];//构造count数组
        int length=array.length,sum=0;//获取A数组大小用于构造B数组  
        int[] B=new int[length];//构造B数组
        for(int i=0;i<length;i++)
        {
            count[array[i]]+=1;// 统计A中各元素个数，存入C数组
        }
        for(int i=0;i<k+1;i++)//修改C数组
        {
            sum+=count[i];
            count[i]=sum;    
        }
        for(int i=length-1;i>=0;i--)//遍历A数组，构造B数组
        {
            
            B[count[array[i]]-1]=array[i];//将A中该元素放到排序后数组B中指定的位置
            count[array[i]]--;//将C中该元素-1，方便存放下一个同样大小的元素
            
        }
        return B;//将排序好的数组返回，完成排序
        
    }
}