package com.xqc.function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumSys {
	
	public static void main(String[] args) {
		
		//找出从101,到200的所有素数
		getPrimeNum(101,200);
		
		//求6和8的最大公约数和最小公倍数
        CommonMultiply(6, 8);
        Map map = ReturnGcdAndLcm(5,9);
        System.out.println(map.get("gcd"));
        System.out.println(map.get("lcm"));
        
        //求数组中的众数
		int[] a ={2,4,5,6,2,4,4,6};
		int most = GetMostNum(a);
		System.out.println(most);
	}

	/**
	 * 找出从low到high的所有素数
	 * @param low
	 * @param high
	 */
	private static void getPrimeNum(int low, int high) {
		boolean flag;
		//遍历每一个从low到high的数
		for (int i = low; i <high; i+=2) {
			flag=true;
			//判断该数是不是素数
			for (int j = 2; j <=Math.sqrt(i); j++) {
				//如果该数从2开始到开方数有可以除尽的，就不是，判断下一个数
				if(i%j==0){
					flag = false;
					break;
				}		
			}
			if(flag==true){
				System.out.println(i);
			}
			
		}
		
	}
	  /**
	   * 求最大公约数和最小公倍数  
	   * @param m
	   * @param n
	   * @return
	   */
	    public static int CommonMultiply(int m ,int n){
	        int r,gcd,lcm=0;

	        lcm=m*n;
	        while((r=m%n)!=0){
	              m=n;
	              n=r;
	        }
	        gcd = n;
	        lcm=lcm/gcd;
	        System.out.println("最大公约数："+gcd);
	        System.out.println("最小公倍数："+lcm);
	        return 0;
	    }
	    /**
	     * 返回最大公约数和最小公倍数
	     * @param m
	     * @param n
	     * @return
	     */
	    public static Map<String,Integer> ReturnGcdAndLcm(int m,int n){
	    	Map<String,Integer> map = new HashMap<String,Integer>();
	    	int r,gcd,lcm=0;
	    	
	    	lcm=m*n;
	    	while((r=m%n)!=0){
	    		m=n;
	    		n=r;
	    	}
	    	gcd = n;
	    	lcm=lcm/gcd;
	    	map.put("gcd", gcd);
	    	map.put("lcm", lcm);   	
	    	return map;
	    	
	    }
	    
		private static int GetMostNum(int[] array) {
			//将数组排序
	        Arrays.sort(array);
	        int count = 1;
	        int longest = 0;
	        int most = 0;
	        //遍历数组判断每个数的次数
	        for (int i = 0; i < array.length - 1; i++) {
	        	//如果等于后一个，计数加一
	            if (array[i] == array[i + 1]) {
	                count++;
	            } else {
	                count = 1;// 如果不等于，就换到了下一个数，那么计算下一个数的次数时，count的值应该重新符值为一
	                continue;
	            }
	            //判断该计数是不是最多的
	            if (count > longest) {
	                most = array[i];
	                longest = count;
	            }
	        }
	        System.out.print("出现次数:" + longest);// 打印出这个数出现的次数已判断是否正确
	        System.out.println(" ");
	        System.out.print("众数为:");
	        return most;
		}

}
