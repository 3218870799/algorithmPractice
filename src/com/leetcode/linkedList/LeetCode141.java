package com.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {
	public static void main(String[] args) {
		LeetCode141 leetcode = new LeetCode141();
		LeetCode141.Solution solution = leetcode.getSolution();
		
		LeetCode141.ListNode head = leetcode.getListNode(1);
		LeetCode141.ListNode first = leetcode.getListNode(2);
		LeetCode141.ListNode second = leetcode.getListNode(1);
		LeetCode141.ListNode third = leetcode.getListNode(2);
		LeetCode141.ListNode fourth = leetcode.getListNode(5);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		
		boolean result = solution.hasCycle(head);
		System.out.println(result);
		
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
	
	public class Solution {
		public boolean hasCycle(ListNode head) {
		    Set<ListNode> nodeSet = new HashSet<>();
		    while (head != null) {
		        if (nodeSet.contains(head)) {
		            return true;
		        } else {
		            nodeSet.add(head);
		        }
		        head = head.next;
		    }
		    return false;
		}
	}
	
	public class BestSolution {
	    public boolean hasCycle(ListNode head) {
	        if (head == null || head.next == null) {
	            return false;
	        }
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while (slow != fast) {
	            if (fast == null || fast.next == null) {
	                return false;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return true;
	    }
	}

}
