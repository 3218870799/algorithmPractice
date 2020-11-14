package com.xqc.binartTree;

/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 二叉树顺序存储方式
 * 	前序遍历
 */
public class ArrayBinaryTree {

	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data=data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	
	//前序遍历
	public void frontShow(int index) {
		if(data==null||data.length==0) {
			return;
		}
		//先遍历当前节点的内容
		System.out.println(data[index]);
		//2*index+1:处理左子树
		if(2*index+1<data.length) {
			frontShow(2*index+1);
		}
		//2*index+2:处理右子树
		if(2*index+2<data.length) {
			frontShow(2*index+2);
		}
	}
	
}
