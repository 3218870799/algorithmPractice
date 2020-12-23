package com.xqc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class LambdaDemo {

	//定义一个函数式接口
	interface Printer{
		void printer(String val);
	}
	public void pringSomething(String something,Printer printer){
		
	}
	
	public static void main(String[] args) {

		//重新对排序
		TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		});

		TreeSet<Integer> set1 = new TreeSet<>((x,y)->Integer.compare(x,y));
		//语法一：无参无返回值
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("输出某些东西");
			}
		};
		//简化实现
		Runnable runnable1 = ()->System.out.println("输出某些东西");
		//语法二：有一个参数，无返回值
		Consumer<String> com = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		//简化实现
		//如果只有一个参数，(x)也可以直接写成x
		Consumer<String> com1 = (x)->{System.out.println(x);};
		com1.accept("有一个参数，无返回值,输出参数");
		//语法三：多个参数，有返回值，多条执行语句
		Comparator<Integer> com2 = (x,y)->{
			System.out.println("执行某些操作");
			return Integer.compare(x,y);
		};
		//如果只有一条语句，return 和大括号都可以省略
		Comparator<Integer> com3 = (x,y)->Integer.compare(x,y);
		//语法六：参数指定类型
		//语法三依然可以执行，是因为JVM的上下文推断
		Comparator<Integer> com4 = (Integer x ,Integer y)->Integer.compare(x,y);



		/**
		Thread t = new  Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		});
		t.start();
		*/
	      ArrayList<Integer> list = new ArrayList<>();
	      Collections.addAll(list, 1,2,3,4,5);
	      //lambda表达式 方法引用
	      list.forEach(System.out::println);
	      list.forEach(element -> {
	        if (element % 2 == 0) {
	          System.out.println(element);
	        }
	      });
		
	}

}
