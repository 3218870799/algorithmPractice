package com.xqc.function;
/**
 * 
 * @author xqc
 * @data 2020年2月17日
 * Description:大数相关计算
 */
public class BigNumber {
	/**
	 * 大数加法
	 * @param a
	 * @param b
	 * @return 加法接过字符串
	 */
	public static String BigNumberAdd(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		//最高位可能进位，最长位数加一
		int maxL = Math.max(len1, len2)+1;
		int[] a1 = new int[maxL];
		int[] b1 = new int[maxL];
		//将字符串逆序转为数组
		for(int i =0;i<len1;i++){			
			a1[i] = a.toCharArray()[len1-1-i]-'0';
		}
		for(int j =0;j<len2;j++){
			b1[j] = b.toCharArray()[len2-1-j]-'0';
		}
		//数组逆序相加，结果存放在a1中
		for(int k=0;k<maxL;k++){
			if(a1[k]+b1[k]>=10){
				int temp=a1[k]+b1[k];
				a1[k]=temp%10;
				a1[k+1]+=(temp/10);
			}else{
				a1[k]+=b1[k];
			}
		}
		StringBuffer c = new StringBuffer();
		//预存进位位不为0则拼接进c否则逆序拼接并返回
		if(a1[maxL-1]!=0)
			c.append(a1[maxL-1]);
		for(int l=maxL-2;l>=0;l--)
			c.append(a1[l]);
		return c.toString();	
	}
	/**
	 * 大数乘法
	 * @param a
	 * @param b
	 * @return
	 */
	public static String BigNumberMul(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int[] a1 = new int[len1];
		int[] b1 = new int[len2];
		//定义结果数组，len1位乘以len2位结果最多为len1+len2位
		int[] c1 = new int[len1+len2];
		//倒置转数组
		for(int i = 0;i<len1;i++)
			a1[i]=a.toCharArray()[len1-1-i]-'0';
		for(int i = 0;i<len2;i++)
			b1[i]=b.toCharArray()[len2-1-i]-'0';
		//列竖式
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++)
				c1[i+j]+=a1[i]*b1[j];
		}
		//竖式求和
		for(int i=0;i<len1+len2;i++){
			if(c1[i]>=10){
				c1[i+1]+=c1[i]/10;
				c1[i]%=10;
			}
		}
		//倒置拼接
		StringBuffer c = new StringBuffer();
		int i;
		//找到第一个不为0的
		for(i =len1+len2-1;i>=0;i--){
			if(c1[i]!=0)break;
		}
		for(;i>=0;i--){
			c.append(c1[i]);
		}
		return c.toString();
	}
	/**
	 * 大数减法
	 * @param big
	 * @param small
	 * @return
	 */
	public static String BigNumberSub(String big, String small) {
		if(big==small)
			return "0";
		int len1 = big.length();
		int len2 = small.length();
		int[] bigArr = new int[len1];
		int[] smallArr = new int[len2];
		//将字符串逆序转为数组
		for(int i =0;i<len1;i++)		
			bigArr[i] = big.toCharArray()[len1-1-i]-'0';
		for(int i=0;i<len2;i++)
			smallArr[i] = small.toCharArray()[len2-1-i]-'0';
		//挨个减去短的
		for(int i=0;i<len2;i++){
			if(bigArr[i]<smallArr[i]){
				bigArr[i]=bigArr[i+10]-smallArr[i];
				bigArr[i+1]-=1;
			}else{
				bigArr[i]-=smallArr[i];
			}
		}
		//倒置拼接
		StringBuffer c = new StringBuffer();
		int i;
		//找到第一个不为0的
		for(i =len1-1;i>=0;i--){
			if(bigArr[i]!=0)break;
		}
		for(;i>=0;i--){
			c.append(bigArr[i]);
		}
		return c.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(BigNumberAdd("9999919999","2632432"));
		System.out.println(BigNumberMul("9999","99999"));
		System.out.println(BigNumberSub("99999","90000"));
	
	}


}
