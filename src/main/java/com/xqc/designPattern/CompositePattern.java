package com.xqc.designPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Composite china = new Composite();
        //为china添加省份城市等
        //进行统计
        System.out.printf(china.count()+"");
    }
}

/**
 * 人口普查接口
 */
interface Counter{
    int count();
}

/**
 * 叶子节点，城市，要实现人口普查，实际进行统计
 */
class City implements Counter{
    private int sum = 0;
    public City(int sum){
        this.sum = sum;
    }
    @Override
    public int count() {
        return sum;
    }
}
class Composite implements Counter{
    //包含城市列表
    private List<Counter> counterList = new ArrayList<>();
    @Override
    public int count() {
        int sum = 0;
        //遍历每一个城市进行求值求和
        for (Counter counter : counterList){
            sum += counter.count();
        }
        return sum;
    }
}