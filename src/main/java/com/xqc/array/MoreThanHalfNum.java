package com.xqc.array;


public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1,5,2,2,3,4,2,2};
        int resutl = getMoreThanHalfNum(a);
    }
    private static Integer getMoreThanHalfNum(int[] array) {
        //如果数组为空
        if (array == null)
            return null;
        Integer number = null;
        int count = 0;
        Integer resultInteger = null;
        //遍历这个数组
        for (int i = 0; i < array.length; i++) {
            //如果没有赋值
            if (number == null) {
                number = array[i];
                count++;
            } else {
                //不相同就减去，直到为0，更新该数
                if (array[i] != number){
                    if (count == 0) {
                        //如果次数为零，我们需要保存下一个数字，并把次数设为1
                        number = array[i];
                        count = 1;
                    } else {
                        count--;
                    }
                }else {
                    //相同则计数加一
                    count++;
                }
            }
            //最后一次count设为1的则为大于一半的数
            if (count == 1)
                resultInteger = number;
        }
        return resultInteger;
    }
}
