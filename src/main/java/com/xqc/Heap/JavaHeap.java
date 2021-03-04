package com.xqc.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class JavaHeap {
    public static void main(String[] args) {
        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
        //小顶堆
        Queue<Integer> minHeap = new PriorityQueue<>();
        //大根堆实现
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i =0;i<arrForHeap.length;i++) {
            minHeap.add(arrForHeap[i]);
            maxHeap.add(arrForHeap[i]);
        }
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll()+" ");
        }
        System.out.println();
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll()+" ");
        }
    }
}
