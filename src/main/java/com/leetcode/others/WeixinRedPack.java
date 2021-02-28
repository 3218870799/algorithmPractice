package com.leetcode.others;

public class WeixinRedPack {

    public static void main(String[] args) {
        //红包金额
        double money = 20;
        //红包数量
        int totalCount = 5;
        //把金额变成分
        int smallMoney = (int)(money * 100);
        //剩余金额
        int remainMoney = smallMoney;
        //剩余人数
        int remainCount = totalCount;

        for (int i = 1; i <= totalCount; i++) {
            int amount = 0;
            //除了最后一个人，都随机抢红包，最后一个人要剩下的
            if(i!=totalCount){
                amount = (int)(Math.random() * (remainMoney -remainCount * 100)) + 1;
                System.out.printf(String.valueOf(amount/100.00));
            }else {
                amount = remainMoney;
                System.out.printf(String.valueOf(amount/100.00));
            }
            //减掉余额
            remainMoney = remainMoney - amount;
        }
    }
}
