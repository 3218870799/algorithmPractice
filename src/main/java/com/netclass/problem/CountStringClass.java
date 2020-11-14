package com.netclass.problem;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020年3月23日
 * Description:输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
 */
public class CountStringClass {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		char[] ch  = input.nextLine().toCharArray();
		
        int abccount=0;
        int spacecount=0;
        int numcount=0;
        int othercount=0;

		for (int i = 0; i < ch.length; i++) {
			//判断是不是字母
	           if(Character.isLetter(ch[i])) {
	                abccount++;
	                //判断是不是数字
	            }else if(Character.isDigit(ch[i])) {
	                numcount++;
	                //判断是不是空格
	            }else if(Character.isSpaceChar(ch[i])){
	                spacecount++;
	            }else{
	                othercount++;
	            }
	    }
	        System.out.println(abccount);
	        System.out.println(spacecount);
	        System.out.println(numcount);
	        System.out.println(othercount);
	}

}
