package com.xqc.recursion;

/**
 * 
 * 打印一个字符串所有的子串
 */
public class PrintAllSub {
	
	/**
	 * 
	 * @param str 总串
	 * @param i 当前位置
	 * @param parent 上一次操作传来的字符串
	 */
	public static void printAllSubsquence(char[] str,int i,String parent){
		if(i==str.length){
			System.out.println(parent);
			return;
		}
		printAllSubsquence(str, i+1, parent);
		printAllSubsquence(str, i+1, parent + String.valueOf(str[i]));
	}
	
	public static void main(String[] args) {
		String test = "abc";
		
		char[] str = test.toCharArray();
		printAllSubsquence(str, 0, "");
	}

}
