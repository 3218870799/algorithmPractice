package com.xqc.recursion;
/**
 * @ClassName:Hanoi.java
 * @Author qcxiao
 * @Date:2020年8月10日下午1:50:11
 * @Version:1.0
 * @Description:经典汉诺塔问题
 */
public class Hanoi {
	//汉诺塔的移动的方法
	//使用分治算法
	/**
	* @Function: Hanoi.java
	* @Description: 输出汉诺塔移动的过程
	*
	* @Return Type:void
	* @Parament:num代表盘的数量
	* @Parament:from代表开始移动的柱子
	* @Parament:help代表辅助的柱子
	* @Parament:to 代表目的柱子
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020年8月10日 下午1:51:09
	 */
	public static void hanoiTower(int num,String from,String help,String to) {
		//如果只有一个盘
		if(num == 1) {
			System.out.println("第1个盘从 " + from + "->" + to);
		} else {
			//如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
			//1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
			hanoiTower(num - 1, from, to, help);
			//2. 把最下边的盘 A->C
			System.out.println("第" + num + "个盘从 " + from + "->" + to);
			//3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔  
			hanoiTower(num - 1, help, from , to);
			
		}
	}
	public static void main(String[] args) {
		hanoiTower(3, "左", "中", "右");
	}
}

