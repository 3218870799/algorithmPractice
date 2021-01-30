package com.xqc.designPattern;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        Cooking cooking = new CookEgg();
        cooking.cook();

    }
}
abstract class Cooking{
    protected abstract void step1();
    protected abstract void step2();
    public void cook(){
        System.out.print("做法开始");
        step1();
        step2();
        System.out.print("做法结束");
    }
}
class CookEgg extends Cooking{

    @Override
    protected void step1() {
        System.out.println("放西红柿和鸡蛋");

    }

    @Override
    protected void step2() {
        System.out.println("少放盐多放味精");
    }
}
