package com.leetcode.queue;

public class LeetCode622 {
	
	static class testMain{
		
		public static void main(String[] args) {
			
			LeetCode622 leetCode = new LeetCode622();
			
			LeetCode622.MyCircularQueue circularQueue = leetCode.getSolution(3);

			System.out.println(circularQueue.enQueue(1));  // 返回true

			System.out.println(circularQueue.enQueue(2));  // 返回true

			System.out.println(circularQueue.enQueue(3));  // 返回true

			System.out.println(circularQueue.enQueue(4));  // 返回false,队列已满

			System.out.println(circularQueue.Rear());  // 返回3

			System.out.println(circularQueue.isFull());  // 返回true

			System.out.println(circularQueue.deQueue());  // 返回true

			System.out.println(circularQueue.enQueue(4));  // 返回true

			System.out.println(circularQueue.Rear());  // 返回4
		}
	}
	
	class MyCircularQueue {
	    
	    private int[] data;
	    private int pHead;
	    private int pTail;
	    private int size;

	    /** Initialize your data structure here. Set the size of the queue to be k. */
	    public MyCircularQueue(int k) {
	        data = new int[k];
	        pHead = 0;
	        pTail = k - 1;
	        size = 0;
	    }
	    
	    /** Insert an element into the circular queue. Return true if the operation is successful. */
	    public boolean enQueue(int value) {
	        if (isFull()) return false;
	        data[nextTail()] = value;
	        size++;
	        return true;
	    }
	    
	    /** Delete an element from the circular queue. Return true if the operation is successful. */
	    public boolean deQueue() {
	        if (isEmpty()) return false;
	        nextHead();
	        size--;
	        return true;
	    }
	    
	    /** Get the front item from the queue. */
	    public int Front() {
	        if (isEmpty()) return -1;
	        return data[pHead];
	    }
	    
	    /** Get the last item from the queue. */
	    public int Rear() {
	        if (isEmpty()) return -1;
	        return data[pTail];
	    }
	    
	    /** Checks whether the circular queue is empty or not. */
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    /** Checks whether the circular queue is full or not. */
	    public boolean isFull() {
	        return size == data.length;
	    }
	    
	    private int nextTail() {
	        if (pTail == data.length - 1) {
	            pTail = 0;
	        } else {
	            pTail++;
	        }
	        return pTail;
	    }
	    
	    private int nextHead() {
	        if (pHead == data.length - 1) {
	            pHead = 0;
	        } else {
	            pHead++;
	        }
	        return pHead;
	    }
	}

	/**
	 * Your MyCircularQueue object will be instantiated and called as such:
	 * MyCircularQueue obj = new MyCircularQueue(k);
	 * boolean param_1 = obj.enQueue(value);
	 * boolean param_2 = obj.deQueue();
	 * int param_3 = obj.Front();
	 * int param_4 = obj.Rear();
	 * boolean param_5 = obj.isEmpty();
	 * boolean param_6 = obj.isFull();
	 */

	public MyCircularQueue getSolution(int k) {
		return new MyCircularQueue(k);
	}

}
