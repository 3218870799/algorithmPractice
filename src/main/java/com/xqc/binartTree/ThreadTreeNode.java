package com.xqc.binartTree;
/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 中序化线索二叉树节点
 */
public class ThreadTreeNode {
	//节点的权
	int value;
	//左儿子
	ThreadTreeNode leftNode;
	//右儿子
	ThreadTreeNode rightNode;
	//标识指针类型
	int leftType;
	int rightType;
	

	public ThreadTreeNode(int value) {
		this.value=value;
	}
	
	//中序线索化二叉树
	public void threadNodes() {
		threadNodes(this);
	}
	
	public void threadNodes(ThreadTreeNode node) {
		//当前节点如果为null，直接返回
		if(node==null) {
			return;
		}
		//处理左子树
		threadNodes(node.leftNode);
		//处理前驱节点
		if(node.leftNode==null){
			//让当前节点的左指针指向前驱节点
			node.leftNode=pre;
			//改变当前节点左指针的类型
			node.leftType=1;
		}
		//处理前驱的右指针，如果前驱节点的右指针是null(没有指下右子树)
		if(pre!=null&&pre.rightNode==null) {
			//让前驱节点的右指针指向当前节点
			pre.rightNode=node;
			//改变前驱节点的右指针类型
			pre.rightType=1;
		}
		//每处理一个节点，当前节点是下一个节点的前驱节点
		pre=node;
		//处理右子树
		threadNodes(node.rightNode);
	}
	
	
	
	//设置左儿子
	public void setLeftNode(ThreadTreeNode leftNode) {
		this.leftNode = leftNode;
	}
	//设置右儿子
	public void setRightNode(ThreadTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	//前序遍历
	public void frontShow() {
		//先遍历当前节点的内容
		System.out.println(value);
		//左节点
		if(leftNode!=null) {
			leftNode.frontShow();
		}
		//右节点
		if(rightNode!=null) {
			rightNode.frontShow();
		}
	}

	//中序遍历
	public void midShow() {
		//左子节点
		if(leftNode!=null) {
			leftNode.midShow();
		}
		//当前节点
		System.out.println(value);
		//右子节点
		if(rightNode!=null) {
			rightNode.midShow();
		}
	}

	//后序遍历
	public void afterShow() {
		//左子节点
		if(leftNode!=null) {
			leftNode.afterShow();
		}
		//右子节点
		if(rightNode!=null) {
			rightNode.afterShow();
		}
		//当前节点
		System.out.println(value);
	}

	//前序查找
	public ThreadTreeNode frontSearch(int i) {
		ThreadTreeNode target=null;
		//对比当前节点的值
		if(this.value==i) {
			return this;
		//当前节点的值不是要查找的节点
		}else {
			//查找左儿子
			if(leftNode!=null) {
				//有可能可以查到，也可以查不到，查不到的话，target还是一个null
				target = leftNode.frontSearch(i);
			}
			//如果不为空，说明在左儿子中已经找到
			if(target!=null) {
				return target;
			}
			//查找右儿子
			if(rightNode!=null) {
				target=rightNode.frontSearch(i);
			}
		}
		return target;
	}
	
	//删除一个子树
	public void delete(int i) {
		ThreadTreeNode parent = this;
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

