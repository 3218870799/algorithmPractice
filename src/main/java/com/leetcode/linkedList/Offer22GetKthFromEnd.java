package com.leetcode.linkedList;

public class Offer22GetKthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head ,int k){
        ListNode first = head;
        ListNode sencond = head;
        for (int i = 0; i < k-1; i++) {
            sencond = sencond.next;
        }
        while(sencond.next!=null){
            first = first.next;
            sencond = sencond.next;
        }
        return first;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
