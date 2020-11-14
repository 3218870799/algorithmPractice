package com.leetcode.array;

public class LeetCode105 {
	
	public static void main(String[] args) {
		LeetCode105 leetcode = new LeetCode105();
		LeetCode105.Solution solution = leetcode.getSolution();
		//TreeNode root = leetcode.getTreeNode(0);
		
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		TreeNode root = solution.buildTree(preorder, inorder);
		while(root!=null){
			System.out.println(root.val);
			root=root.right;
		}
		
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
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	    	if(preorder==null||inorder==null){
	    		return null;
	    	}
			return myBuildTree(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
	        
	    }

		TreeNode myBuildTree(int[] inorder,int instart,int inend,int[] preorder,int prestart,int preend){
		
	    	if(instart>inend){
	    		return null;
	    	}
	    	TreeNode root = new TreeNode(preorder[prestart]);
	    	//在后续数组中找到前序的根节点
	    	int position = findPosition(inorder, instart, inend, preorder[prestart]);
	    	root.left=myBuildTree(inorder, instart, position-1, preorder, prestart+1, prestart+position-instart);
	    	root.right=myBuildTree(inorder,position+1,inend,preorder,position-inend+preend+1,preend);
	    	return root;
		}
	    int findPosition(int[] arr,int start,int end,int key){
	       int i;
	        for(i = start;i<=end;i++){
	            if(arr[i] == key){
	                return i;
	            }
	         }
	         return -1;
	     }
	}
	
	
	class BestSolution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            return func(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode func(int[] preorder, int[] inorder, int begin1, int end1, int begin2, int end2) {
            if (begin1 == preorder.length) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[begin1]);
            if (begin1 == end1) {
                return root;
            }

            for (int index = end2; index >= begin2; index--) {
                if (preorder[begin1] == inorder[index]) {
                    int length = index - begin2;
                    root.left = func(preorder, inorder, begin1 + 1, begin1 + length, begin2, index - 1);
                    root.right = func(preorder, inorder, begin1 + length + 1, end1, index + 1, end2);
                    return root;
                }
            }
            return null;
        }
    }

}
