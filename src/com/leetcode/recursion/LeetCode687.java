package com.leetcode.recursion;
public class LeetCode687 {
	
	public static void main(String[] args) {
		LeetCode687 leetcode = new LeetCode687();
		LeetCode687.Solution solution = leetcode.getSolution();
		TreeNode root = leetcode.getTreeNode(0);
		System.out.println(solution.longestUnivaluePath(root));
	}
	
	public TreeNode getTreeNode(int x){
		return new TreeNode(x);
	}
	
	public Solution getSolution() {
		return new Solution();
	}
	 public class TreeNode {
		  int val;
		  TreeNode left;
          TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 class Solution {
		    int re = 0;
		    public int longestUnivaluePath(TreeNode root) {
		        helper(root, 0);
		        return re;
		    }
		    public int helper(TreeNode node, int n) {
		        if (node == null)
					return 0;
				int left = helper(node.left, node.val);
				int right = helper(node.right, node.val);
				re = Math.max(re, left + right);
				return node.val == n ? Math.max(left, right) + 1 : 0;

		    }
		}
}
