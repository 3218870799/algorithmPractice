package com.xqc.Heap;

//²âÊÔ´úÂë
public class Test {
    public static void main(String[] args) throws Exception {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while((del=heap.delMax())!=null){
            System.out.print(del+",");
        }
    }
}
