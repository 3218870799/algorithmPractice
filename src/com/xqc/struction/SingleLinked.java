package com.xqc.struction;

/**
 * @author xqc
 * @data 2020年5月24日
 * Description:
 * 单链表
 */
public class SingleLinked {

	//节点内容
	int data;
	//下一个节点
	SingleLinked next;
	
	public SingleLinked(int data) {
		this.data=data;
	}
	
	//为链表头节点追加节点
	public SingleLinked append(SingleLinked node) {
		//当前节点
		SingleLinked currentNode = this;
		//循环向后找
		while(true) {
			//取出下一个节点
			SingleLinked nextNode = currentNode.next;
			//如果下一个节点为null,当前节点已经是最后一个节点
			if(nextNode==null) {
				break;
			}
			//赋给当前节点
			currentNode = nextNode;
		}
		//把需要追回的节点追加为找到的当前节点的下一个节点
		currentNode.next=node;
		return this;
	}
	
	//插入一个节点做为当前节点的下一个节点
	public void after(SingleLinked node) {
		//取出下一个节点，作为下下一个节点
		SingleLinked nextNext = next;
		//把新节点作为当前节点的下一个节点
		this.next=node;
		//把下下一个节点设置为新节点的下一个节点
		node.next=nextNext;
	}
	
	//显示所有节点信息
	public void show() {
		SingleLinked currentNode = this;
		while(true) {
			System.out.print(currentNode.data+" ");
			//取出下一个节点
			currentNode=currentNode.next;
			//如果是最后一个节点
			if(currentNode==null) {
				break;
			}
		}
		System.out.println();
	}
	
	//删除下一个节点
	public void removeNext() {
		//取出下下一个节点
		SingleLinked newNext = next.next;
		//把下下一个节点设置为当前节点的下一个节点。
		this.next=newNext;
	}
	
	//获取下一个节点
	public SingleLinked next() {
		return this.next;
	}
	
	//获取节点中的数据
	public int getData() {
		return this.data;
	}
	
	//当前节点是否是最后一个节点
	public boolean isLast() {
		return next==null;
	}
	
}

