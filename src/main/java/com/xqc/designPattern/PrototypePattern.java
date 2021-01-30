package com.xqc.designPattern;

public class PrototypePattern {
    public static void main(String[] args) {
        Plane plane = new Plane();
        System.out.println(plane.getName() + " " + plane.getType());
        Plane clone = (Plane) plane.clone();
        System.out.println(clone.getName() + " " + clone.getType());
    }
}
/**
 * 原型接口
 */
interface Prototype{
    Object clone();
}
class Plane implements Prototype{
    private String name;
    private String type;
    public Plane(){
        name = "Name" + Math.random();
        type = "Type" + Math.random();
    }
    public Plane(Plane plane){
        this.name = plane.name;
        this.type = plane.type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone() {
        return new Plane(this);
    }
}
