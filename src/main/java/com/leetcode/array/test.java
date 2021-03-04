package com.leetcode.array;

public class test {
    public static void main(String[] args) {
        char[] ip = {1,2,7,'.',0,'.',0,'.',0};
        System.out.printf(testIp(ip) + "");
    }

    public static Boolean testIp(char[] ipChar){
        int[] dotIndex = null;
        int index =0;
        for (int i = 0; i < ipChar.length; i++) {
            if (ipChar[i] =='.'){
                dotIndex[index] = i;
                index++;
            }
        }
        if (index!=3){
            return false;
        }
        int start = 0;
        for (int i = 0; i < 4; i++) {
            int length = dotIndex[i] - start;
            start = dotIndex[i];
            if (length > 2){
                if (ipChar[dotIndex[i] - 3] > 2 || ipChar[dotIndex[i] - 3] < 0 ){
                    return false;
                }
                if (ipChar[dotIndex[i] - 2] > 5|| ipChar[dotIndex[i] - 2] < 0 ){
                    return false;
                }
                if (ipChar[dotIndex[i] - 1 ] > 5 || ipChar[dotIndex[i] -1 ] < 0 ){
                    return false;
                }
            }
            if (length > 1){
                if (ipChar[dotIndex[i] - 1] < 0 ){
                    return false;
                }
                if (ipChar[dotIndex[i] ] < 0 ){
                    return false;
                }
            }
            if (length > 0){
                if (ipChar[dotIndex[i] ] < 0 ){
                    return false;
                }
            }
        }
        return true;
    }
    
}
