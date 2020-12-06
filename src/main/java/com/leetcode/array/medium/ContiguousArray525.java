package com.leetcode.array.medium;

import java.util.HashMap;

public class ContiguousArray525 {
    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,1,1,0,0,0,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,0};
        System.out.println(findMaxLength2(a));
    }

    /**
     * 使用Array进行优化
     * @param a
     * @return
     */
    private static int  findMaxLength2(int[] a) {
        return 0;
    }

    /**
     * 将0变成-1
     * 使用hashtable，将和作为key，位置作为value，
     * 如果遍历时和已经存在，说明从value到该位置的和为0，则result = 该位置index - value，判断哪个result最长
     * @param nums
     * @return
     */
    private static int findMaxLength(int[] nums) {
        if(nums.length<=1) return 0;
        HashMap<Integer,Integer> pos = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]==1?1:-1;
            //如果和为0，则也是其中一种结果
            if(sum==0){
                ans=i+1;
            }else if(pos.containsKey(sum)){
                //如果和已经存在，则取以前结果 和现在位置差最大的一个
                ans = Math.max(ans,i-pos.get(sum));
            }else{
                //如果没有，就放到hashMap里
                pos.put(sum,i);
            }
        }
        return ans;
    }

}
