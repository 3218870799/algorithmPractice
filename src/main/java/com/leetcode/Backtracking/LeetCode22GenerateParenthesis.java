package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22GenerateParenthesis {

    //返回可能生成的列表
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    public void backtrack(List<String> result, StringBuilder cur, int leftNum, int rightNum, int n) {
        //一种方案已经合法填满2n的长度，则将其加入到结果中
        if (cur.length() == n * 2) {
            result.add(cur.toString());
            return;
        }
        //如果左括号数量小于n，可以继续添加左括号，先加左括号，先加有括号一定不合法
        if (leftNum < n) {
            cur.append('(');
            //递归继续添加
            backtrack(result, cur, leftNum + 1, rightNum, n);
            //将当前添加的删掉，以便其他情况
            cur.deleteCharAt(cur.length() - 1);
        }
        //如果有括号数量小于左括号数量，则可以添加右括号
        if (rightNum < leftNum) {
            cur.append(')');
            backtrack(result, cur, leftNum, rightNum + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
