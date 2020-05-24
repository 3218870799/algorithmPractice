package com.xqc.struction;


/**
 * 
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 循环链表
 */
public class LoopLinked {

	//节点内容
	int data;
	//下一个节点
	LoopLinked next=this;
	
	public LoopLinked(int data) {
		this.data=data;
	}
	
	//插入一个节点做为当前节点的下一个节点
	public void after(LoopLinked node) {
		//取出下一个节点，作为下下一个节点
		LoopLinked nextNext = next;
		//把新节点作为当前节点的下一个节点
		this.next=node;
		//把下下一个节点设置为新节点的下一个节点
		node.next=nextNext;
	}
	
	//删除下一个节点
	public void removeNext() {
		//取出下下一个节点
		LoopLinked newNext = next.next;
		//把下下一个节点设置为当前节点的下一个节点。
		this.next=newNext;
	}
	
	//获取下一个节点
	public LoopLinked next() {
		return this.next;
	}
	
	//获取节点中的数据
	public int getData() {
		return this.data;
	}
	
}
