package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 二叉树节点
 */
public class TreeNode {
	//节点的权
	int value;
	//左儿子
	TreeNode leftNode;
	//右儿子
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	//设置左儿子
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//设置右儿子
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
}
