package com.xqc.test;

import java.util.Scanner;

public class RemoveCharFromStr {
	public static void main(String[] args) {
		
		String str = "abcdacb";
		String remove = "abc";
		char[] strArray = str.toCharArray();
		char[] removeArray = remove.toCharArray();
		
		for (int i = 0; i < removeArray.length; i++) {
			for (int j = 0; j < strArray.length; j++) {
				if(strArray[j]==removeArray[i]){
					//strArray[j]=Array
				}
			}
		}
		
		
	}

}
