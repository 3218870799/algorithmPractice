package com.xqc.test;

// 本试卷唯一 ID: A747EE5FEFB1EB1B7650B6CE0B5CA7C8, 请勿修改本行内容
/* 注意, 这里不要写包名. 留空 */
/* 这里如果用到其他的类, 记得要引用, 否则编译不过 */
import java.util.*;
/**
 * 回答方式: 直接保存或者复制本java文件, 然后在原处作答. 建议重命名成 meta-java-<姓名>.java
 * 选择题改变量赋值的字符串
 * 实现题在原本的函数体里返回正确答案, 注意不要改动函数结构. 用这一个Java文件完成
 * 本卷直接用代码判卷, 没有人工干预. 格式错误, 语法错误, 格式改动会导致试卷无效
 *
 * 注: 一个java文件可以有多个类, 但只能有一个public类. 所以你的实现中可以建内部类, 辅助类. 可以javac编译确认自己语法无误
 * 以下带public static修饰的实现题方法, 不要改变这个签名
 *
 *
 * 这里不要更改默认的类名, 也不要更改修饰符不要加public. 类名保持为 MetaJavaQuestionSheet
 * 可以改文件名, 建议改为 meta-java-<姓名>.java
 */
class MetaJavaQuestionSheet {
    /*
     * 以下是实现题
     */
    /**
     * <b>注意! 本题不要遍历二维数组. 要求时间复杂度严格低于n^2, 否则视为不得分 </b>
     *
     * 现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度；
     * @param int[][] nums
     * @param int x 目标数
     * @return boolean
     */
    public static boolean searchMatrix(int[][] nums, int x) {
        //递增排列
        //行数
        int rows = nums.length;
        //列数
        int cols = nums[0].length;
        int row = 0;
        int col = cols -1;
        //boolean result = false;
        //[0][0]最小
        if (x<nums[0][0]){
            return false;
        }
        //从第一行最大的开始找
        //如果比目标大，往左找，否则玩下找
        while(row<rows&&col>=0){
            if(nums[row][col]==x){
                return true;
            }
            if(nums[row][col]>x){
                col--;
            }else{
                row++;
            }
        }
        //没找到
        return false;
    }
    /**
     * 对任意一个Map<String, Object>, 其 key 为 String,
     * 其 value 为 Map<String, Object> Object[] Number String 中的任意一种,
     * 显然叶子节点是 value 类型为 Number 或 String的节点,
     * 将 Map 转为多条字符串, 每条字符串表达其中一个叶子节点,
     * 比如:
     * {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
     * 将转化为以下这些字符串
     * a.b[0] = v
     * a.b[1] = 2
     * a.b[2].c = 0
     * d[0] = 1
     * d[1] = null
     * d[2] = 3
     *
     * @param map 上述的 map
     * @return 所有的字符串
     */
    public static Set<String> showMap(Map<String, Object> map) {
        //
        HashSet<String> result = new HashSet<String>();
        //遍历map
        //key拼接，value直取
        for (String s : map.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            Object obj = map.get(s);
            //若单——key=value
            if (obj instanceof String || obj instanceof Number){
                stringBuilder.append("=").append(obj);
                result.add(stringBuilder.toString());
            }else if(obj instanceof Object[]){
                //如果是Array——key[i]=value
                addArray(result, stringBuilder, (Object[]) obj);
            }else {
                //如果是Map——key.(递）=value
                addMap(result,stringBuilder,(Map<String, Object>) obj);
            }
        }
        return result;
    }

    private static void addMap(HashSet<String> hashSet, StringBuilder stringBuilder, Map<String, Object> hashMap) {
        for (String ss : hashMap.keySet()) {
            stringBuilder.append(".").append(ss);
            Object object = hashMap.get(ss);
            if (object instanceof String || object instanceof Number){
                stringBuilder.append("=").append(object);
                hashSet.add(stringBuilder.toString());
            }else if (object instanceof Object[]){
                addArray(hashSet,stringBuilder,(Object[]) object);
            }else{
                addMap(hashSet,stringBuilder,(Map<String, Object>) object);
            }
        }

    }

    private static void addArray(HashSet<String> set, StringBuilder stringBuilder, Object[] obj) {
        Object[] objects= obj;
        String str="";
        for (int i = 0; i < objects.length; i++) {
            str=stringBuilder.toString();
            stringBuilder.append("[").append(i).append("]");
            Object object = objects[i];
            if (object instanceof String || object instanceof Number || object==null){
                stringBuilder.append("=").append(object);
                set.add(stringBuilder.toString());
            }else if (object instanceof Map){
                addMap(set, stringBuilder, (Map<String, Object>) object);
            }else {
                addArray(set,stringBuilder,(Object[]) object);
            }
            stringBuilder=new StringBuilder(str);
        }
    }

    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     * 例如以下是镜像对称的
     *      1
     *     / \
     *    2   2
     *   / \ / \
     *  3  4 4  3
     *
     * 下面这个则不是镜像对称的
     *      1
     *     / \
     *    2   2
     *     \   \
     *      3   3
     *
     * TreeNode类的定义:
     *
     * @param TreeNode 一颗二叉树
     * @return boolean 是否是对称的
     */

    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        //如果为空，一定是镜像
        if(root == null||(root.left==null&&root.right==null))
            return true;
        //递归
        return changeLR(root.left,root.right);
    }

    private static boolean changeLR(TreeNode left, TreeNode right) {
        if (left==null && right==null) return true;
        //左右的值相同且左右子树相同
        return left.val == right.val && changeLR(left.left,left.right) && changeLR(right.left,right.right);
    }
}
