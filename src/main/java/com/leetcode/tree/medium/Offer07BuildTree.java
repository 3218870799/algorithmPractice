package com.leetcode.tree.medium;

import java.util.HashMap;
import java.util.Map;

public class Offer07BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //判空
        if (preorder == null || inorder ==null || preorder.length==0 ||inorder.length==0){
            return null;
        }
        //使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。
        Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        int length = preorder.length;
        for (int i =0;i<length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelp(preorder,0,length-1,inorder,0,length-1,indexMap);
        return root;
    }
    public TreeNode buildTreeHelp(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        //
        if (preorderStart > preorderEnd) {
            return null;
        }
        //根节点为前序遍历的第一个节点
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        //递归出口，当只有一个节点时，返回该节点
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            //找到根节点在后续遍历中的位置
            int rootIndex = indexMap.get(rootVal);
            //左子树节点数等于根节点索引减去后续开始索引，右子树节点数等于后续的结束索引减去根节点索引
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            //递归左子树，
            TreeNode leftSubtree = buildTreeHelp(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTreeHelp(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
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
