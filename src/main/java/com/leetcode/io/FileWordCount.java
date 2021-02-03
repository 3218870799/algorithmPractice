package com.leetcode.io;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java实现读取英文文章，统计其中每个单词出现的次数并输出
 *
 */
public class FileWordCount {

    public void count() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("F:\\test\\english.txt"));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while( (line = reader.readLine()) != null ){
            buffer.append(line);
        }
        reader.close();
        //定义正则表达式匹配单词
        Pattern expression = Pattern.compile("[a-zA-Z]+");
        String string = buffer.toString();
        Matcher matcher = expression.matcher(string);
        TreeMap<String,Integer> map = new TreeMap<>();
        String word = "";
        int n = 0;
        Integer times = 0;
        while(matcher.find()){		//是否匹配单词
            word = matcher.group();		//得到一个单词，树映射中的键
            n++;
            if( map.containsKey(word) ){	//如果该键存在，则表示单词出现过
                times = map.get(word);		//得到单词出现的次数
                map.put(word, times+1);
            } else {
                map.put(word, 1);	//否则单词是第一次出现，直接放入map
            }
        }
        //根据Map的value进行排序
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String,Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator);
        for (int i = list.size()-1; i > list.size() - 11; i--) {
            System.out.println(list.get(i).toString());
        }
        System.out.println("统计分析如下：");
        System.out.println("t 文章中单词总数" + n + "个");
        System.out.println("具体的信息在原文件目录的result.txt文件中");
        BufferedWriter bufw = new BufferedWriter(new FileWriter("F:\\test\\result.txt"));
        for(Map.Entry<String,Integer> me : list){
            bufw.write(me+"");
            bufw.newLine();
        }
        bufw.write("english.txt中的单词总数" + n + "个");
        bufw.newLine();
        bufw.write("english.txt中不同单词" + map.size() + "个");
        bufw.close();
    }


    public static void main(String[] args) {
        try {
            FileWordCount fwc = new FileWordCount();
            fwc.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
