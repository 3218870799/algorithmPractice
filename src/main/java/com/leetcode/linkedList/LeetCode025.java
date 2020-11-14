package com.leetcode.linkedList;

public class LeetCode025 {
	
	public static void main(String[] args) {
		LeetCode025 leetcode = new LeetCode025();
		LeetCode025.Solution solution = leetcode.getSolution();
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
		public ListNode reverseKGroup(ListNode head, int k) {
		    ListNode root = new ListNode(-1);
		    root.next = head;
		    ListNode res = root;
		    ListNode temp = head;
		    int i = 0;
		    while(temp != null){
		        i++;
		        temp = temp.next;
		    }//i的最终结果就是链表中所有节点的总个数
		    while(i >= k){
		        for(int j = 0 ; j < k-1; j++){//按上面分析中讲的思路进行反转链表的操作
		            ListNode node = root.next;//如果以k个结点为一组进行反转，就要进行k-1次翻转操作
		            root.next = head.next;//比如k=3，就是两次操作：将2翻转到1前面+将3翻转到1前面
		            head.next = root.next.next;
		            root.next.next = node;
		        }//for循环里面是一次翻转操作
		        root = head;
		        head = head.next;//以k为一组，就要将head移动到已经反转过的结点后面继续以k个结点为一组进行反转
		        i-=k; //此时一共i个结点减去已经反转过的k个结点得到剩余节点个数
		    }
		    return res.next;
		}
	}
	
	class BestSolution {
	    public ListNode reverseKGroup(ListNode head, int k) {
	           ListNode current_node = head;
	        int count = 0;
	        while (current_node != null && count != k) {
	            current_node = current_node.next;
	            count++;
	        }
	        if (count == k) {
	            current_node = reverseKGroup(current_node, k);
	            while (count-- > 0) {
	                ListNode temp = head.next;
	                head.next = current_node;
	                current_node = head;
	                head = temp;
	            }
	            head =current_node;
	        }
	        return head;
	    }
	}
	
}
