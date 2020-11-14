package com.xqc.test;

/**
 * @ClassName resume
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/5/005 10:27
 * @Version 1.0
 **/
public class resume {
	public static void main(String[] args){
        boolean ApplicationResult = false;
        while(!ApplicationResult) {
            ApplicationResult = SendApplication("字节跳动");
            if (ApplicationResult) {
                //log.info("successful!");
                StriveToRealizeYourValue();
                break;
            } else {
                //log.error("weak capacity");
                Improvetechnology();
            }
        }
    }
    public static boolean SendApplication(String company){
        return false;

    }
    public static void StriveToRealizeYourValue(){
        System.out.println("努力实现自己的价值");

    }
    public static void Improvetechnology(){
    	System.out.println("努力学习，改善自己！");
    }
}
