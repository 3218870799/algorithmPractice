package com.xqc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class PracticeTest {
	
	public static void main(String[] args) {

	}	

	class Solution01 {
	    public int[] twoSum(int[] nums, int target) {
	    	int i;
	    	int j;
	        for(i = 0; i < nums.length; i++) {
	            for(j = i + 1; j < nums.length; j ++) {
	                if(nums[j] == target - nums[i]) {
	                    return new int[]{i,j};
	                }
	            }
	        }
			return null;
	    }
	}
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	class Solution02 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		    ListNode result = new ListNode(0);
		    ListNode p = l1, q = l2, curr = result;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.val : 0;
		        int y = (q != null) ? q.val : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new ListNode(sum % 10);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    if (carry > 0) {
		        curr.next = new ListNode(carry);
		    }
		    return result.next;
		}
/*	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    	
	    	int carry =0;
	        while(l1 != null || l2 != null){

	            //取到两个链表当前的数值
	        	int num1 = (l1 == null) ? 0 : l1.val;
	        	int num2 = l2 == null ? 0 : l2.val;
	            //求和
	            int sum = num1 + num2 + carry;
	            //对进位标志的验证
	            carry = sum >= 10 ? 1 : 0;
	            cur.next = new ListNode(sum % 10);
	            cur = cur.next;
	            l1 = l1 ? l1.next : l1;
	            l2 = l2 ? l2.next : l2;
	        }
	    	
	    	
	    	ListNode result=new ListNode(0);
	    	int carry = 0;
	    	
	    	while(l1.next!=null||l2.next!=null){
	    		result.val=l1.val+l2.val+carry;
	    		if(result.val>=10){
	    			carry=1;
	    			result.val=result.val%10;
	    		}else{
	    			carry=0;
	    		}
	    		
	    		result=result.next;
	    		l1=l1.next;
	    		l2=l2.next;
	    		
	    		System.out.println();
	    		
	    		if(result.val>=10){
	    			result.val=result.val%10;
	    			result=result.next;
	    			result.val=result.val+1;
	    		}else{
	    			result=result.next;
	    		}
	    		l1=l1.next;
	    		l2=l2.next;
	    	}
	    	result.next = (l1.next==null) ? l2.next: l1.next;
			return result;
	        
	    }*/
	}
	
/*	class Solution03 {
	    public int lengthOfLongestSubstring(String s) {
	    	 byte[] str = s.getBytes();
	    	 ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
	    	//List queue = new ArrayList();
	    	 int Maxlength=0;
	    	 for(int i =0;i>str.length;i++){
	    		 char c = (char) str[i];
	    		 queue.add(c);
	    		 for(int j=0;j<queue.size();j++){
	    			 if(queue.contains(c)){
	    				 
	    			 }
	    		 }
	    		
	    		 
	    	 }
	    	
			return 0;
	        
	        
	    }
	}*/
	public class Solution03 {
	    public int lengthOfLongestSubstring(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
	}
	
/*	class Solution04 {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    	int[] temp = new int[nums1.length+nums2.length];
	    	int temp1 = 0;
	    	int temp2 = 0;
	    	int temp3 = 0;
	    	int length1= nums1.length;
	    	int length2=nums2.length;
	    	while(temp1<length1 || temp2<length2){
	    		if(nums1[temp1]>nums2[temp2]){
	    			temp[temp3]=nums1[temp1];
	    			temp1++;
	    			temp3++;
	    		}else{
	    			temp[temp3]=nums2[temp2];
	    			temp2++;
	    			temp3++;
	    		}
	    	}
	    	double mid =0;
	    	if(temp.length%2==0){
	    		mid = (temp[(temp.length/2+1)]+temp[(temp.length/2-1)])/2;
	    	}else{
	    		mid = temp[(int)(temp.length/2+0.5)];
	    	}
			return mid;
	        
	    }
	}*/
	
	
	
	
	
	

}
