package com.xqc.binartTree;

/**
 * 判断是不是平衡二叉树：左右子树之差绝对值不大于1
 * @author xqc
 * @data 2020年2月17日
 * Description:
 */
public class IsBalancedTree {

	//二叉树节点类型
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	/**
	 * 判断是否为二叉树，是返回true，不是返回false
	 * @param head
	 * @return
	 */
	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}
	/**
	 * 递归判断左右子树高度，并在发现左右子树高度之差大于1时将res改为false
	 * @param head
	 * @param level
	 * @param res
	 * @return head树的高度
	 */
	public static int getHeight(Node head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		//递归判断左树是否平衡并得到其高度
		int lH = getHeight(head.left, level + 1, res);
		//如果不平衡则返回其左边树高度
		if (!res[0]) {
			return level;
		}
		//右树
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		//判断左右子树高度之差大于1，则判为不平衡
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		System.out.println(isBalance(head));

	}

}
