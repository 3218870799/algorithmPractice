package com.leetcode.array.easy;

import java.util.HashMap;

/**
 * @ClassName MoreThanHalfNum
 * @Author Administrator
 * @Date 2020/12/16/016 17:32
 * @Description TODO
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1,5,2,2,3,4,2,2};
        int resutl = getMoreThanHalfNum(a);
    }
    public int majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int count = map.get(nums[i]);
                map.put(nums[i],++count);
            }
        }
        int maxcount = 0;
        for (Integer count:map.values()) {
            if (maxcount<count) maxcount = count;
        }
        return maxcount;
    }

    private static Integer getMoreThanHalfNum(int[] array) {
        if (array == null)
            return null;
        Integer number = null;
        int count = 0;
        Integer resultInteger = null;
        for (int i = 0; i < array.length; i++) {
            if (number == null) {
                number = array[i];
                count++;
            } else {
                if (array[i] != number)
                    if (count == 0) {
                        number = array[i];
                        count = 1;
                    } else
                        count--;
                else
                    count++;
            }
            if (count == 1)
                resultInteger = number;
        }
        return resultInteger;

    }
}
