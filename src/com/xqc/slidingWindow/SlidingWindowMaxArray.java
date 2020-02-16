package com.xqc.slidingWindow;

import java.util.LinkedList;

public class SlidingWindowMaxArray {
	//LinkedList 双向链表
	//ArrayList 动态数组
	public static int[] getMaxWindow(int[] arr,int w) {
		if(arr.length<w||arr==null||w<1)
			return null;
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] rev = new int[arr.length-w+1];
		int index = 0;
		
		for(int i = 0;i<arr.length;i++){
			while(arr[i]<qmax.peekLast())
				qmax.pollLast();
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w)
				qmax.pollFirst();
			if(i>w-1)
				rev[index++] = arr[qmax.peekFirst()];
		}
		return rev;
	}
	
	
	

}
