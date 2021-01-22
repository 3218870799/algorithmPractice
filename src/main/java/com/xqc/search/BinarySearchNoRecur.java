package com.xqc.search;

/**
 * @ClassName:BinarySearchNoRecur.java
 * @Author qcxiao
 * @Date:2020年8月10日下午1:42:14
 * @Version:1.0
 * @Description:二分查找非递归实现
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        //测试
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);
    }

    //二分查找的非递归实现

    /**
     * @param arr    待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        //说明继续查找
        while (left <= right) {
			//当数很大时，使用（left + right）/2 容易产生溢出
            int mid = left + (right - left)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                //需要向左边查找
                right = mid - 1;
            } else {
                //需要向右边查找
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
		// 当 left > right 时，说明递归整个数组，但是没有找到
        if (left >right){
            return -1;
        }
        //当数很大时，使用（left + right）/2 容易产生溢出
        int mid = left + (right -left) / 2;
        int midVal = arr[mid];
        if (findVal >midVal){
			// 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal <midVal){
        	// 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else{
            return mid;
        }

    }


}
