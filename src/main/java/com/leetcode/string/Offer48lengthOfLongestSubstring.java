package com.leetcode.string;

import java.util.*;

public class Offer48lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        //维护一个单调栈，存放下标
        Deque<Integer> stack = new ArrayDeque<>();
        //转成字符数组
        char[] sArr = s.toCharArray();
        //使用HashMap去重
        Map<Character, Integer> hasMap = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < sArr.length; i++) {
            if (!hasMap.containsKey(sArr[i])){
                stack.push(i);
            }else{
                while((!stack.isEmpty()) && stack.peek()<=i){
                    stack.pop();
                }
            }
            hasMap.put(sArr[i],i);
            maxLength = Math.max(maxLength,stack.size());
        }
        return maxLength;
    }
    public int lengthOfLongestSubstring2(String s) {
        //存储 s[j] 左边距离最近的相同字符为 s[i] ，即 s[i] = s[j]
        Map<Character,Integer> dic = new HashMap<>();
        int res = 0,tmp =0;
        for (int j = 1; j < s.length(); j++) {
            //获取索引i
            int i = dic.getOrDefault(s.charAt(j),-1);
            //更新索引表
            dic.put(s.charAt(j),j);
            // dp[j - 1] -> dp[j]
            tmp = tmp < j - i ? tmp + 1 : j - i;
            //max(dp[j - 1], dp[j])
            res = Math.max(res,tmp);
        }
        return res;
    }

}
