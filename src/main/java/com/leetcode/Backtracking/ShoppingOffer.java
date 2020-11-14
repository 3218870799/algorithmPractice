package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffer {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//这种方式初始化的list是不可改变的，无法添加和删除
		List<Integer> price = Arrays.asList(2,5);
		//
		List<Integer> libao1 = Arrays.asList(3,0,5);
		List<Integer> libao2 = Arrays.asList(1,2,10);
		List<List<Integer>> offer = new ArrayList<List<Integer>>();
		offer.add(libao1);
		offer.add(libao2);
		List<Integer> needs = Arrays.asList(3,2);
		System.out.println(solution.shoppingOffers(price, offer, needs));
	}	
}
class Solution {
	/**
	* @Return Type:int
	* @Parament:needs,购买数量
	* @Author : qcxiao
	* @Date:2020年8月29日 下午4:08:29
	 */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> offer, List<Integer> needs) {
    	//可不可以利用大礼包决定于既不能买多也不能买少

    	//如果可以利用大礼包，是不是应该利用offer呢？是否对价格降低
    	//重复判断，选择递归
		return shopping(price,offer,needs,0);
    }

	private int shopping(List<Integer> price, List<List<Integer>> offer, List<Integer> needs, int index) {
		
		//如果根本不存在特价商品offer,使用原价购买
		if(index == offer.size()){
			return purchoseWithOriginalPrice(price,needs);
		}
		//尝试是否应该使用offer，那就需要对数量进行改变，但是如果某些不合适，应该回溯到在使用到使用该offer之前
		List<Integer> clone = new ArrayList<Integer>(needs);
		int i;
		for (i = 0; i < offer.get(index).size()-1; i++) {
			//计算使用大礼包剩余需要的数量，对应的商品 - 对应大礼包对应商品的个数
			int remain = needs.get(i) - offer.get(index).get(i);
			//还需要的商品数量小于0，不能使用该礼包
			if(remain < 0){
				break;
			}else{
				//可以尝试使用大礼包，更新需要商品的数量，此时需要的商品为
				clone.set(i, remain);
			}
		}
		//如果i已经到了offer的最后一个（总价）数，说明前面的数都没有问题
		//那可以利用，那用该礼包是否可以减少价格呢？
		if(i==offer.get(index).size()-1){
			//[用这个大礼包的钱 + 后续剩余的使用的钱 ]   与  [ 没有使用该大礼包的价格的价钱 即回溯]
			return Math.min(offer.get(index).get(i) + shopping(price,offer,clone,index), shopping(price,offer,needs,index + 1));
		}else{
			//如果不能使用大礼包，即某一商品不满足，直接回溯
			return shopping(price,offer,needs,index + 1);
		}
	}
	//使用原价购买
	private int purchoseWithOriginalPrice(List<Integer> price, List<Integer> needs) {
		int sum = 0;
		//遍历需求数组，总价 = 每个商品  * 每个商品单价  之和
		for (int i = 0; i < needs.size(); i++) {
			sum += needs.get(i) * price.get(i);
 		}
		return sum;
	}
}

class Solution01 {
	//
    private int min;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        min=0;
        //求单买物品的价格
       for(int i=0;i<needs.size();i++){
            min=min+needs.get(i)*price.get(i);
       }
       //min=sum;
       dfs(price,special,needs,0,min);
       return min;
    }
      
     public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int start,int money){
         if(start>=special.size())  return;
         //选礼包
         List<Integer> libao=special.get(start);
         List<Integer> newneeds=new ArrayList<>();
         boolean flag=true;
         int tmp=0;
         for(int i=0;i<libao.size()-1;i++){
        	 //如果用了该礼包后商品的数量小于需要的数量，则不能用该礼包
             if(needs.get(i)-libao.get(i)<0){
                 flag=false;
                 break;
             }else{
                 newneeds.add(needs.get(i)-libao.get(i));
                 //这个tmp不就是礼包的最后价钱吗？
                 tmp=tmp+libao.get(i)*price.get(i);
             }
         }
         if(flag){
             int newMoney=money-tmp+libao.get(libao.size()-1);
             min=Math.min(min,newMoney);
             dfs(price, special, newneeds, start,newMoney);
         }
         //不选该礼包
          dfs(price, special, needs ,start+1,money);
     } 

}
