package com.xqc.function;

public class Calauate{

    public static void main(String[] args){
          CommonMultiply(5, 9);
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
}
