package com.xqc.test;

import java.util.HashMap;
import java.util.Map;

public class Test02 {

    public static void main(String[] args) {
        String s = new String(new char[] {'j','a','v','a'});
        String si = "java";
        System.out.println(s == si);
        //intern返回规范化表示形式
        //对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。
        System.out.println(s.intern() == "java");
        System.out.println(s == si.intern());
    }

    /*public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                cnn();
            }
        };
        t.run();
        System.out.print("FakeNews ");
        System.out.print("; ");
        t.start();
        System.out.print("FakeNews ");
    }
    static void cnn() {
        System.out.print("CNN ");
    }*/
    /*public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String str = "没人比我更懂java";
        StrObject obj = new StrObject("没人比我更懂java");
        map.put("str", str);
        map.put("obj", obj);

        str = "真的没人比我更懂java";
        System.out.printf(map.get("str").toString()+"; ");

        StrObject new_obj = (StrObject) map.get("obj");
        new_obj.setStr("真的没人比我更懂java");
        System.out.printf(map.get("obj").toString()+"; ");
    }
    static class StrObject{
        String str;
        public StrObject(String str){
            this.str = str;
        }
        public void setStr(String str){
            this.str = str;
        }
        @Override
        public String toString() {
            return str;
        }
    }*/
}
