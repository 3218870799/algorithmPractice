package com.leetcode.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50FrstUniqChar {
    public static void main(String[] args) {

    }
    public char firstUniqCharByLinkedHashMap(String s) {
        //使用有序哈希表进行存储
        Map<Character,Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        //遍历字符串，将字符串可能的存储起来
        for (char c :sc) {
            dic.put(c,!dic.containsKey(c));
        }
        //有序遍历有序链表
        for (Map.Entry<Character,Boolean> d :dic.entrySet()) {
            //如果只出现一个，则返回key
            if (d.getValue()){
                return d.getKey();
            }
        }
        //没有，返回 ‘ ’
        return ' ';
    }

    public char firstUniqCharByArr(String s) {
        //使用数组进行存储
        int[] dic = new int[26];
        int MinIndex = Integer.MAX_VALUE;
        //将字符串转换为数组
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic[c -'a']++;
        }
        for (int i = 0; i < dic.length; i++) {
          if (dic[i]==1){
              return (char) (i + 'a');
          }
        }
        return ' ';
    }

}
