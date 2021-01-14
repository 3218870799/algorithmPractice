package com.leetcode.string;

public class Offer20IsNumber {

    public boolean isNumber(String s){
        s = s.trim();
        //排除三种清空，空串，e前没有数字，只有.
        // \s空白字符 * 多个
        // ([+-]? \\.?[eE][\\s\\S]* : +-有或没有.有或者没有，跟着e或则E，跟空白或则非空白，
        String regex = "\\s* | ([+-]?\\.?[eE][\\s\\S]*) | ([+-]?\\.)";
        if (s.matches(regex)){
            return false;
        }
        //对不是特殊情况的字符串，进行正则匹配
        regex = "(([+-])?\\d*\\.?\\d*)([eE][+-]?\\d+)?";
        return s.matches(regex);
    }

}
