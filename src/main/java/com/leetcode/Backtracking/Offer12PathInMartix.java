package com.leetcode.Backtracking;

public class Offer12PathInMartix {
    public static void main(String[] args) {

        //bool result = exist()
    }
    public boolean exist(char[][] board, String word) {
        //判断矩阵形状
        if(board.length==0) {
            return false;
        }
        //定义二维矩阵标记是否已经遍历过
        boolean[][] vis = new boolean[board.length][board[0].length];
        //初始化全为false
        //遍历每一个，寻找第一个字符
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //以第一个字符为起点深度遍历，找到一个就返回
                //
                if (dfs(board,word,i,j,vis,0)){
                    return true;
                }
            }
        }
        //一直没有，返回false
        return false;
    }
    //id代表在所需要查的字符串的第几个位置了匹配到
    public boolean dfs(char[][] board, String word,int i,int j,boolean[][] vis,int id) {
        //回溯函数，成功退出和失败退出
        //先考虑失败退出
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] == true){
            return false;
        }
        if (board[i][j] != word.charAt(id)){
            return false;
        }
        //成功退出
        //word遍历完了
        if (id == word.length() -1){
            return true;
        }
        //如果到现在还没退出，就从该位置开始遍历
        vis[i][j] = true;
        boolean flag = dfs(board,word,i+1,j,vis,id+1)
                    || dfs(board,word,i-1,j,vis,id+1)
                    || dfs(board,word,i,j+1,vis,id+1)
                    || dfs(board,word,i,j-1,vis,id+1);
        //每次回溯完之后，再改回来
        vis[i][j] = false;
        return flag;
    }

}
