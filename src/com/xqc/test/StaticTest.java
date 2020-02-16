package com.xqc.test;

public class StaticTest {
	
    private static boolean ready;
    private static int number;
    private static int num;
    
    private static class Reader extends Thread{
        public void run(){
	        while(!ready){
	            Thread.yield();
	        }
	        System.out.println(number);
        }
    }
    public static void main(String[] args){
    	new Reader().start();
        number = 42;
        num = 24;
        ready = true;
        System.out.println(num);
    }

}
