package com.xqc.recursion;

public class Hanoi {
	
	public static void process(int N,String from,String help,String to){
		if(N==1){
			System.out.println("Move 1 form " + from + " to " +to);
		}else{
			process(N-1,from,to,help);
			System.out.println("Move " + N +" from "+from + " to " + to );
			process(N-1,help,from,to);
		}
	}
	
	public static void main(String[] args) {
		process(3,"×ó","ÖÐ","ÓÒ");
	}

}
