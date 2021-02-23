package com.leetcode.dfs;

public class Offer36treeToDoublyList {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root ==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if (cur==null) return;
        dfs(cur.left);
        //前一节点的右指针指向当前节点
        if (pre!=null){
            pre.right = cur;
        }else{
            head = cur;
        }
        //当前节点的左指针指向前一节点
        cur.left = pre;
        //将前一节点指向当前节点
        pre = cur;
        dfs(cur.right);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
