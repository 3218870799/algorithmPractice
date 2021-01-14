package com.xqc.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//时间复杂度主要为排序O(nlogn)
public class ListUnion {

    public static void main(String[] args) {
        //?union([?2,?1,?3],?[?2,?3,?4])?==??[1,?2,?3,?4]
        System.out.println(union(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 4)));
    }

    static List<Integer> union(List<Integer> a, List<Integer> b) {
        //?在这儿实现
        //将两个链表分别排序
        a = sortListTopDown(a);
        b = sortListTopDown(b);

        //合并两个排序的链表
        return merge(a,b);
    }

    public static List<Integer> sortListTopDown(List<Integer> head) {
        //
        if (head == null || head.size()==1) {
            return head;
        }
        int mid = head.size()/2;

        //结束后慢指针正好走到中间
        List<Integer> l1 = head.subList(0, mid);
        List<Integer> l2 = head.subList(mid, head.size());
        List<Integer> l1result = sortListTopDown(l1);
        List<Integer> l2result = sortListTopDown(l2);
        return merge(l1result, l2result);
    }

    //如果想去重，可以在判断时加上if(temp<temp1 || temp <temp2)再进入，否则，指针只往后走
    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> dummyHead = new ArrayList<Integer>();
        //初始化添加一个小的数
        dummyHead.add(0);
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        //将较小的一个加入新的链表中
        while (index1 < l1.size() && index2 < l2.size()) {
            //
            if (l1.get(index1) < l2.get(index2) && dummyHead.get(index) < l1.get(index1)) {
                dummyHead.add(l1.get(index1));
                index1++;
            } else if (l1.get(index1) > l2.get(index2) && dummyHead.get(index) < l2.get(index2)) {
                dummyHead.add(l2.get(index2));
                index2++;
            } else if(l1.get(index1) == l2.get(index2) && dummyHead.get(index) < l2.get(index2)){
                dummyHead.add(l2.get(index2));
                index1++;
                index2++;
            }
            index++;
        }
        //如果l1有剩余，将l1中剩余的加入到链表中，否则将l2加入到链表中
        if (index1 < l1.size()) {
            while (index1 < l1.size()) {
                if (dummyHead.get(index) < l1.get(index1)) {
                    dummyHead.add(l1.get(index1));
                    index++;
                }
                index1++;
            }
        } else {
            while (index2 < l2.size()) {
                if (dummyHead.get(index) < l2.get(index2)) {
                    dummyHead.add(l2.get(index2));
                    index++;
                }
                index2++;
            }
        }
        return dummyHead.subList(1, dummyHead.size());
    }
}
