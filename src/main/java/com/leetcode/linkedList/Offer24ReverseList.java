package com.leetcode.linkedList;

public class Offer24ReverseList {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;

/*        ListNode pre = head;
        ListNode cur = head.next;
        ListNode aft = head.next.next;
        while (aft!=null){
            cur.next = pre;
            pre.next = aft;
            pre = cur;
            cur = aft;
            aft = aft.next;

        }*/


    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
