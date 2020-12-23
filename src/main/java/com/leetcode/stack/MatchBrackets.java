package com.leetcode.stack;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.ListDatatypeValidator;

import java.util.Stack;

public class MatchBrackets {
    public static void main(String[] args) {
        String s = "cjsdhc{{{{(())[][]}";
        Boolean result = isValid(s);
        System.out.println(result);

    }
    private static Boolean isValid(String s) {
        /**
         * 用栈实现
         * 遍历字符串时判断，
         * 如果是左括号，那么将其入栈，
         * 如果为右括号，
         *          先判断栈是否为空，为空直接返回false
         *          不为空时判断：
         *                  栈顶元素与右括号是否匹配，
         *                  如果匹配就出栈，不匹配返回false
         */
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (('('==s.charAt(i))||('['==s.charAt(i))||('{'==s.charAt(i))){
                stack.push(s.charAt(i));
            }else if((')'==s.charAt(i))||(']'==s.charAt(i))||('}'==s.charAt(i))){
                if (stack.empty()){
                    return false;
                }else{
                    if (('('==stack.peek()&&')'==s.charAt(i))||('['==stack.peek()&&']'==s.charAt(i))||('{'==stack.peek()&&'}'==s.charAt(i))){
                        stack.pop();
                    }
                }
            }
        }
        // 遍历循环结束后，如果发现栈里为空，则证明括号匹配完毕；否则括号不匹配
        if (stack.empty()){
            return true;
        }
        return false;

    }
}
