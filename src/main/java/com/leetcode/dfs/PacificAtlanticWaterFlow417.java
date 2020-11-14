package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {

}
class Solution {
	//表示二维平面的行数与列数
    private int m, n;
    //表示四个方向的数组
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //判断某个坐标x,y是否在矩形区域内
    private boolean in_area(int x, int y){
        return 0 <= x && x < m && 0 <= y && y < n;
    }
    //从当前节点出发，坐标x，y,高度为h，能不能到达P，或者能不能道达A
    //
/*    private void dfs(int[][] matrix, int x, int y, int[][] tmp){
        tmp[x][y] = 1;
        for (int[] d : direction) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (!in_area(newx, newy) || matrix[x][y] > matrix[newx][newy] || tmp[newx][newy] == 1){
                continue;
            }
            dfs(matrix, newx, newy, tmp);
        }
    }
    */
    /**
     * 换一种思路，从边界往里面走，只能走到比自己更高或者等高的地方。边界能走到的地方，就是能流入对应海洋的地方。
     */
    private void dfs(int[][] matrix,int x, int y, boolean[][] canReach) {
    	//将当前点设置为已访问
        canReach[x][y] = true;
        //对上下左右是个方向进行遍历，
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[i][0];
            int newY = y + direction[i][1];
            //如果满足：在矩形内，高度比当前点更高或者相等，且还没有被访问过，就对其访问
            if (in_area(newX, newY) && matrix[x][y] <= matrix[newX][newY] && !canReach[newX][newY]) {
                dfs(matrix,newX, newY, canReach);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    	//结果坐标集合，既能到太平洋又能到大西洋的坐标集合
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0)
            return ans;
        //列数
        m = matrix.length;
        //行数
        n = matrix[0].length;
        //能到太平洋的结果集合 和能到大西洋的结果集合，能到则该坐标为1，不能到为0
        //int[][] po = new int[m][n], ao = new int[m][n]; //po 太平洋，ao 大西洋
        boolean[][] po = new boolean[m][n];
        boolean[][] ao = new boolean[m][n];
        //
        for (int i = 0; i < n; ++i){
            dfs(matrix, 0, i, po);
            dfs(matrix, m - 1, i, ao);
        }
        //
        for (int i = 0; i < m; ++i){
            dfs(matrix, i, 0, po);
            dfs(matrix, i, n - 1, ao);
        }
        //对二维平面内所有点进行遍历，找到都可以到达的点
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (po[i][j] && ao[i][j] ){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
}
