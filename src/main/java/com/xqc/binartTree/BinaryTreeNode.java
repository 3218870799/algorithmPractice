package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 二叉树节点
 */
public class BinaryTreeNode {
	//节点的权
	int value;
	//左儿子
	BinaryTreeNode leftNode;
	//右儿子
	BinaryTreeNode rightNode;
	
	public BinaryTreeNode(int value) {
		this.value=value;
	}
	
	//设置左儿子
	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//设置右儿子
	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	/**
	 * 删除二叉树以i为根节点的子树
	 * @param i
	 */
	public void delete(int i) {
		BinaryTreeNode parent = this;
		//判断左儿子
		if(parent.leftNode!=null&&parent.leftNode.value==i) {
			parent.leftNode=null;
			return;
		}
		//判断右儿子
		if(parent.rightNode!=null&&parent.rightNode.value==i) {
			parent.rightNode=null;
			return;
		}
		
		//递归检查并删除左儿子
		parent=leftNode;
		if(parent!=null) {
			parent.delete(i);
		}
		
		//递归检查并删除右儿子
		parent=rightNode;
		if(parent!=null) {
			parent.delete(i);
		}
	}
	
	
}
