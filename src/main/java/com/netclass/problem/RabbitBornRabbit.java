package com.netclass.problem;

/**
 * 
 * @author xqc
 * @data 2020年3月22日
 * Description:
 * 有一只兔子，从第3个月开始每月生1只兔子，小兔子长到第3个月开始每个月也会生1只兔子，
 * 假如兔子都不死，问每个月的兔子总数是多少？
 * 
 * 分析：
 * 乍一看觉得问题挺复杂，仔细分析之后发现，
 * 兔龄2个月及2个月以上的兔子在新的1个月每只都会生1只兔子。
 * 对于新的这个月来说，之前兔龄2个月及2个月以上的兔子就是2个月前的兔子总数，
 * 也就是说新的1个月相比上1个月增加的兔子数是2个月前的兔子数，
 * 其实就是当月的兔子数等于前两个月的兔子数之和。
 * 
 * 分类：斐波那契数
 * 
 */
public class RabbitBornRabbit {
	
	public static void main(String[] args) {
		//兔子总数
		int sum_rabbit =1;
		//一个月前兔子总数
		int one_ago = 1;
		//两个月前的兔子总数==新的一个月生的兔子总数
		int two_ago = 1;
		
		for(int i =1;i<=10;i++){
			if(i<3){
				sum_rabbit =1;
			}else{
				sum_rabbit = one_ago+two_ago;
				two_ago = one_ago;
				one_ago = sum_rabbit;
			}
		}
		System.out.println(sum_rabbit);
	}
	
	

}
