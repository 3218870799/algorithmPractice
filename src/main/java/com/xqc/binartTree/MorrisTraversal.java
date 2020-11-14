package com.xqc.binartTree;

public class MorrisTraversal {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void morrisIn(Node head){
		if(head==null){
			return;
		}
		Node cur = head;
		Node mostRight = null;
		
		while(cur!=null){
			mostRight = cur.left;
			if(mostRight!=null){
				while(mostRight!=null&&mostRight!=cur){
					mostRight=mostRight.right;
				}
				if(mostRight.right==null){
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else{
					mostRight.right=null;
				}
				cur=cur.right;

			}
		}
		
		
		
		
	}

}
