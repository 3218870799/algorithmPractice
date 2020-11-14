package com.xqc.classic;

/**
 *查找第K小的数
 */
public class BFPRT {
	
	
	public static int getMinKthByBFPRT(int[] arr,int K){
		int[] copyArr = copyArray(arr);
		return bfprt(copyArr, 0, copyArr.length, K-1);
	}
	
	private static int[] copyArray(int[] arr) {
		int[] res = new int[arr.length];
		for(int i=0;i!=res.length;i++){
			res[i] = arr[i];
		}
		return res;
	}

	public static int bfprt(int[] arr,int begin,int end,int i){
		
		if(begin==end)
			return arr[begin];
		int pivot = medianOfMedians(arr,begin,end);
		int[] pivotRange = partition(arr,begin,end,pivot);
		if(i>=pivotRange[0] && i<=pivotRange[1]){
			return arr[i];
		}else if(i<pivotRange[0]){
			return bfprt(arr,begin,pivotRange[0]-1,i);
		}else{
			return bfprt(arr, pivotRange[1]+1, end, i);
		}	
	}

	private static int[] partition(int[] arr, int begin, int end, int pivot) {
		//TODO
		return null;
	}

	private static int medianOfMedians(int[] arr, int begin, int end) {
		int num = end-begin+1;
		int offset = num%5==0?0:1;
		int[] mArr = new int[num/5+offset];
		for(int i=0;i<mArr.length;i++){
			int beginI = begin + i *5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr,beginI,Math.min(end, endI));
		}
		return bfprt(mArr, 0, mArr.length-1, mArr.length/2);
	}

	private static int getMedian(int[] arr, int beginI, int min) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
