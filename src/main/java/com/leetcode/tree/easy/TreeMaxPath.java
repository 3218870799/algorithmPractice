package com.leetcode.tree.easy;

/**
 * @ClassName TreeMaxPath
 * @Author Administrator
 * @Date 2020/12/16/016 20:56
 * @Description TODO
 */
public class TreeMaxPath {

    public static int max = Integer.MIN_VALUE;  // 始终保持最大的和

    // root到叶节点的最大路径的和
    public static int solution(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        max = Math.max(max, left + right + root.val);// 更新max值
        return Math.max(left, right) + root.val;
    }


    public static void main(String[] args) {
        // Test case
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        solution(node1);
        System.out.println("max = " + max);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
