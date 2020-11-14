package com.leetcode.linkedList;

public class LeetCode206 {
	
	public static void main(String[] args) {
		LeetCode206 leetcode = new LeetCode206();
		LeetCode206.Solution solution = leetcode.getSolution();
		LeetCode206.ListNode head = leetcode.getListNode(1);
		LeetCode206.ListNode first = leetcode.getListNode(2);
		LeetCode206.ListNode second = leetcode.getListNode(3);
		LeetCode206.ListNode third = leetcode.getListNode(4);
		LeetCode206.ListNode fourth = leetcode.getListNode(5);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		
		head = solution.reverseList(head);
		
		System.out.println(head.val);
    	while(head.next!=null){
    		head = head.next;
    		System.out.println(head.val);
    	}
		
	}
	
	public ListNode getListNode(int x){
		return new ListNode(x);
	}
	
	public Solution getSolution() {
		return new Solution();
	}

	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){ val = x; }
	}
	class Solution {
	    public ListNode reverseList(ListNode head) {
	    	ListNode cur = head;
	    	ListNode pre = null;
	    	if(cur==null)
	    		return null;
	    	while(cur.next!=null){
	    		ListNode next = cur.next;
	    		cur.next=pre;
	    		pre=cur;
	    		cur=next;
	    		next=next.next;
	    	}
	    	cur.next=pre;
			return cur;
	        
	    }
	}
}
