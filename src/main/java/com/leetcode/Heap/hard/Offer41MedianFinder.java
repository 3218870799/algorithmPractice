package com.leetcode.Heap.hard;

import java.util.PriorityQueue;

public class Offer41MedianFinder {

    //定义小顶堆
    private PriorityQueue<Integer> MinHeap;
    //重写比较器，定义大顶堆
    private  PriorityQueue<Integer> MaxHeap;
    //计数
    private Integer count = 0;

    public Offer41MedianFinder() {
        MinHeap = new PriorityQueue<>();
        MaxHeap = new PriorityQueue<>((o1,o2) -> o2-o1);
    }

    public void addNum(int num) {
        if (MinHeap.size() == MaxHeap.size()){
            MaxHeap.add(num);
            MinHeap.add(MaxHeap.poll());
        }else{
            MinHeap.add(num);
            MaxHeap.add(MinHeap.poll());
        }
    }

    public double findMedian() {
        if (MinHeap.size() ==MaxHeap.size()){
            return (MinHeap.peek() + MaxHeap.peek()) / 2.0;
        }else {
            return MinHeap.peek()/1.0;
        }
    }

}
