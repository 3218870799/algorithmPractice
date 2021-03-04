package com.leetcode.tree.easy;

public class LeetCode112HasPathSum {


    //递归方法求解
    public boolean hasPathSumMethod1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //如果是根节点而且val == sum 则是
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        //任意左右有一个是则是
        return hasPathSumMethod1(root.left, sum - root.val) || hasPathSumMethod1(root.right, sum - root.val);
    }

}
