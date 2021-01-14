package com.leetcode.tree.easy;

public class Offer62KthNode {
    public static void main(String[] args) {


    }
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }
    public void inorder(TreeNode root){
        if (root ==null) return;
        inorder(root.right);
        if (k==0) return;
        if (--k==0) res = root.val;
        inorder(root.left);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
