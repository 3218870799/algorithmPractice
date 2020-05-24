package com.xqc.struction;
/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 双向循环链表
 */
public class DoubleLinked {
	//上一个节点
	DoubleLinked pre=this;
	//下一个节点
	DoubleLinked next=this;
	//节点数据
	int data;
	
	public DoubleLinked(int data) {
		this.data=data;
	}
	
	//增节点
	public void after(DoubleLinked node) {
		//原来的下一个节点
		DoubleLinked nextNext = next;
		//把新节点做为当前节点的下一个节点
		this.next=node;
		//把当前节点做新节点的前一个节点
		node.pre=this;
		//让原来的下一个节点作新节点的下一个节点
		node.next=nextNext;
		//让原来的下一个节点的上一个节点为新节点
		nextNext.pre=node;
	}
	
	//下一个节点
	public DoubleLinked next() {
		return this.next;
	}
	
	//上一个节点
	public DoubleLinked pre() {
		return this.pre;
	}
	
	//获取数据
	public int getData() {
		return this.data;
	}
	
}
