package com.leetcode.linkedList;

public class LeetCode019 {
	
	public static void main(String[] args) {
		LeetCode019 leetcode = new LeetCode019();
		LeetCode019.Solution solution = leetcode.getSolution();
		LeetCode019.ListNode head = leetcode.getListNode(1);
		LeetCode019.ListNode first = leetcode.getListNode(2);
		LeetCode019.ListNode second = leetcode.getListNode(3);
		LeetCode019.ListNode third = leetcode.getListNode(4);
		LeetCode019.ListNode fourth = leetcode.getListNode(5);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		
		solution.removeNthFromEnd(head, 2);
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
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode pre = head;
	        ListNode afterPreN = head;
	        while (n-- != 0) {
	            afterPreN = afterPreN.next;
	        }
	        if (afterPreN != null) {
	            while (afterPreN.next != null) {
	                pre = pre.next;
	                afterPreN = afterPreN.next;
	            }
	            pre.next = pre.next.next;
	        } else {
	            head = head.next;
	        }
	        return head;
	    }
	}
	
	class BestSolution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
	}

}
