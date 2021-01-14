package com.xqc.thread;

/**
 * @ClassName Test1
 * @Author Administrator
 * @Date 2020/12/23/023 17:31
 * @Description TODO
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            System.out.println(123);
        }
    }
}
