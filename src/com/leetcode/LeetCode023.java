package com.leetcode;

public class LeetCode023 {
	
	public static void main(String[] args) {
		LeetCode023 leetcode = new LeetCode023();
		LeetCode023.Solution solution = leetcode.getSolution();
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
	    public ListNode mergeKLists(ListNode[] lists) {
	    	ListNode head = new ListNode(0);
	    	int len = lists.length;
	    	int MinVal = Integer.MAX_VALUE;
	    	int i=0;
	    	
	    	for(;i<len;i++){
	    		if(lists[i].val<MinVal){
	    			MinVal = lists[i].val;
	    			ListNode temp = lists[i];
	    		}
	    		//head.next = temp;
	    	}
	    	
	    	
	    	
			return null;
	        
	    }
	}
}
