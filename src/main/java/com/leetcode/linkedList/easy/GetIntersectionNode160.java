package com.leetcode.linkedList.easy;

/**
 * @ClassName GetIntersectionNode160
 * @Author Administrator
 * @Date 2020/12/16/016 18:02
 * @Description TODO
 */
public class GetIntersectionNode160 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode listA = headA;
        ListNode listB = headB;

        while (listA != null) {
            listA = listA.next;
            lenA++;
        }
        while (listB != null) {
            listB = listB.next;
            lenB++;
        }

        int diff;
        if(lenA > lenB) {
            diff = lenA - lenB;
            while (diff > 0) {
                diff--;
                headA = headA.next;
            }
        } else {
            diff = lenB - lenA;
            while (diff > 0) {
                diff--;
                headB = headB.next;

            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

}
