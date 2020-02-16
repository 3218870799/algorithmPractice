package com.xqc.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
	public static void main(String[] args) {
/*		int i=0;
		while(i<10){
			System.out.println(++i);
		}*/
		
/*		List my = new LinkedList();
		System.out.println(my.add(1));
		System.out.println(my.add(2));
		System.out.println(my.add(3));
		
		System.out.println(my.size());
		
		System.out.println(my.get(1));
		
		System.out.println(my.contains(2));
		
		System.out.println(my.remove(2));
		
		System.out.println(my.iterator());*/
		
		Queue my =  new LinkedList();
		long start = System.currentTimeMillis();
		
		int j=0;
		for(int i=0;i<10000;i++)
			my.add(j++);
		for(int k=0;k<10000;k++)
			my.remove();
		
		long end = System.currentTimeMillis();
		
		System.out.println("¹²Ö´ÐÐ"+ (end -start));
		
/*		System.out.println(my.add(1));
		System.out.println(my.add(2));
		System.out.println(my.add(3));
		
		System.out.println(my.poll());
		System.out.println(my.peek());
		
		System.out.println(my.remove());
		
		System.out.println(my.size());*/
		

	};

}
