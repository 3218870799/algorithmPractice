package com.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.linkedList.LeetCode141.ListNode;

public class LeetCode142 {
	public static void main(String[] args) {
		LeetCode142 leetcode = new LeetCode142();
		LeetCode142.Solution solution = leetcode.getSolution();
		
		LeetCode142.ListNode head = leetcode.getListNode(1);
		LeetCode142.ListNode first = leetcode.getListNode(2);
		LeetCode142.ListNode second = leetcode.getListNode(3);
		LeetCode142.ListNode third = leetcode.getListNode(2);
		LeetCode142.ListNode fourth = leetcode.getListNode(5);
		head.next = first;
		first.next = second;
		second.next = third;
		third.next = second;
		
		ListNode result = solution.detectCycle(head);
		System.out.println(result);
		
		System.out.println(result.val);
/*    	while(head.next!=null){
    		head = head.next;
    		System.out.println(head.val);
    	}*/
		
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
		public ListNode detectCycle(ListNode head) {
		    Set<ListNode> nodeSet = new HashSet<>();
		    while (head != null) {
		        if (nodeSet.contains(head)) {
		            return head;
		        } else {
		            nodeSet.add(head);
		        }
		        head = head.next;
		    }
		    return null;
		}
	}
	public class BestSolution {
	    public ListNode detectCycle(ListNode head) {
	        //设起点到第一个节点的距离a，节点快慢指针汇合距离b，环形距离减去b为c
	        //(a+b)*2 = (a + b + c + b) -> b = c
	        ListNode slow = head;
	        ListNode fast = head;
	        int flag = 0;
	        while(fast != null && fast.next != null){   //先找到汇合点
	            fast = fast.next.next;
	            slow = slow.next;
	            if(fast == slow)    {flag = 1; break;}
	        }
	        if(flag == 0)   return null;
	        ListNode node = head;
	        while(node != slow){    
	            node = node.next;
	            slow = slow.next;
	        }
	        return node;
	    }
	}

}
