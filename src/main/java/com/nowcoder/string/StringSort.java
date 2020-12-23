package com.nowcoder.string;

import java.util.*;

public class StringSort {

    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> result = Permutation(str);
        result.stream().forEach(System.out::println);
    }

    public static ArrayList<String> Permutation(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        ArrayList<String> result = PermutationHelp(strBuilder);
        return result;
    }
    public static ArrayList<String> PermutationHelp(StringBuilder str){
        ArrayList<String> result = new  ArrayList<String>();
        if(str.length() == 1){
            result.add(str.toString());
        }else{
            for(int i = 0; i < str.length(); i++){
                //可能有重复字符，先判定该字符是否已经交换过排序过
                if(i == 0 || str.charAt(i) != str.charAt(0)){
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = PermutationHelp(new StringBuilder(str.substring(1)));
                    for(int j =0; j < newResult.size(); j++)
                        result.add(str.substring(0,1)+newResult.get(j));
                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            //需要在做一个排序操作
            Collections.sort(result);
        }
        return result;
    }



}
