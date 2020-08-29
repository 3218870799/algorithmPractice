package com.xqc.classic;

/**
 * 
 * @author xqc
 * @data 2020年3月21日
 * Description:Manacher算法，主要解决如何找到字符串中的最长回文子串
 * 暴力解：找中间，判断i+1和i-1个是否相等，奇偶问题加上#号完全变成奇数
 * [L          x= 2*id -i        id        i          R]
 * [左边界                i关于id的对称点x      中点id     i点            右边界]
 * 情况一：以x为中心的回文子串包含在id的范围内
 * 情况二：以x为中心的回文子串超过id的回文子串的左边界
 * 
 */
public class Manacher {
	
	public static void main(String[] args) {
		String str = "abc1234321ab";
		System.out.println(maxLcpsLength(str));
	}
	
	public static char[] manacharString(String str){
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length()*2+1];
		int index = 0;
		for(int i = 0;i!=res.length;i++){
			res[i] = (i&1)==0?'#':charArr[index++];
		}
		return res;
	}
	
	
	public static int maxLcpsLength(String str){
		if(str == null|| str.length()==0)
			return 0;
		char[] charArr = manacharString(str);
		int[] pArr = new int[charArr.length];
		int C = -1;
		int R = -1;
		int max = Integer.MAX_VALUE;
		for(int i = 0;i!=charArr.length;i++){
			pArr[i] = R>i?Math.min(pArr[2*C-i], R-i) : 1;
			while(i+pArr[i]<charArr.length && i-pArr[i]>-1){
				if(charArr[i+pArr[i]]==charArr[i-pArr[i]])
					pArr[i]++;
				else{
					break;
				}
			}
			if(i+pArr[i]>R){
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		
		return max-1;
		
	}

}
