package com.xqc.bishi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String test1 = "k1=v1;k2=v2;k3=v3;k4=v41,v42";

        String test2 = "k1=v1;k2=v2;k3=v3;k4=\"v41=v42\"";

        String test3 = "k1=; k2=v2;k3=v3;k4=\"k5=v5¡±\n";

        Map map = parseKV(test2);
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("<" + entry.getKey() + "," + entry.getValue()+">");
        }

    }

    public static Map<String,String> parseKV(String input){
        String[] temp = input.split(";");
        if (temp.length <=1){
            return null;
        }
        Map<String,String> result = new HashMap<String,String>();
        for (String entry: temp) {
            String key = null;
            String val = null;
            char[] mapString = entry.toCharArray();
            for (int i = 0; i < mapString.length; i++) {
                if (mapString[i]=='='){
                     key = entry.substring(0,i);
                     if (mapString[i+1] =='\"' && i+2<mapString.length){
                         val = entry.substring(i+2,mapString.length-1);
                     }else if(i+1<mapString.length){
                         val = entry.substring(i + 1, mapString.length);
                     }
                    break;
                }
            }
            if (key!=null && val !=null){
                result.put(key,val);
            }
        }
        return result;
    }


}
