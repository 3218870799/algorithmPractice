package com.leetcode.tree.easy;

import java.util.LinkedList;
import java.util.List;

public class Offer34PathSum {

    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //递归进行先序遍历
        recur(root,sum);
        return result;
    }
    private void recur(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum-=root.val;
        //如果等于sum并且是叶子节点，就是一条途径，加入
        if (sum == 0 && root.left == null && root.right == null){
            result.add(new LinkedList(path));
        }
        recur(root.left,sum);
        recur(root.right,sum);
    }
}
