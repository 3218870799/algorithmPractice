package com.leetcode.linkedList;


public class LeetCode024 {
	
	public static void main(String[] args) {
		LeetCode024 leetcode = new LeetCode024();
		LeetCode024.Solution solution = leetcode.getSolution();
	}

	public Solution getSolution(){
		return new Solution();
	}
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	
	class Solution {
	    public ListNode swapPairs(ListNode head) {
	        ListNode preHead = new ListNode(0), cur = preHead;
	        preHead.next = head;
	        while (cur.next != null && cur.next.next != null) {
	            ListNode temp = cur.next.next;
	            cur.next.next = temp.next;
	            temp.next = cur.next;
	            cur.next = temp;
	            cur = cur.next.next;
	        }
	        return preHead.next;
	    }
	}
}
