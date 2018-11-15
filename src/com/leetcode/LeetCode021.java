package com.leetcode;

public class LeetCode021 {
	
	public static void main(String[] args) {
		LeetCode021 leetcode = new LeetCode021();
		LeetCode021.Solution solution = leetcode.getSolution();
		
		
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
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode head = new ListNode(0);
	        ListNode temp = head;
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                temp.next = l1;
	                l1 = l1.next;
	            } else {
	                temp.next = l2;
	                l2 = l2.next;
	            }
	            temp = temp.next;
	        }
	        temp.next = l1 != null ? l1 : l2;
	        return head.next;
	    }
	}
}
