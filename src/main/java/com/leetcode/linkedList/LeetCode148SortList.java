package com.leetcode.linkedList;

public class LeetCode148SortList {
    public static void main(String[] args) {

    }
    public ListNode sortListBottomUp(ListNode head) {
        //判空
        if (head == null) {
            return head;
        }
        //求链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

  /*  public ListNode sortListTopDown(ListNode head){
        //
        if(head == null || head.next == null){
            return head;
        }
        //使用快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //结束后慢指针正好走到中间
        ListNode l2 = slow.next;
        slow.next = null;
        return merge(sortListTopDown(head),sortListTopDown(l2));
    }*/

    //将两个已经排序的链表进行合并，并没有去重
    //如果想去重，可以在判断时加上if(temp<temp1 || temp <temp2)再进入，否则，指针只往后走
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = l1,temp2 = l2;
        while (temp1!=null && temp2!=null){
            if (temp1.val <=temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
