package com.leetcode.Graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName cloneGraph133
 * @Author Administrator
 * @Date 2020/12/16/016 20:23
 * @Description TODO
 */
public class cloneGraph133 {
    class Solution{
        //定义一个hashMap，key代表节点的值，value代表该节点，可以用于记录是否已经遍历过该节点
        Map<Integer,Node> map = new HashMap<>();
        public Node cloneGraph(Node node){
            //判空
            if (node==null)
                return null;
            //如果不为空，深度优先克隆图
            return dfsClone(node);
        }
        private Node dfsClone(Node node){
            if(node==null) return null;
            //如果该节点已经遍历过，已经存放于map中
            if (map.containsKey(node.val)){
                return map.get(node.val);
            }
            //如果没有遍历过，新建一个节点
            Node newNode = new Node(node.val,new ArrayList<>());
            //然后将该节点放入到map中
            map.put(node.val,newNode);
            for (Node neighbor:node.neighbors) {
                //然后深度优先克隆他的邻居节点
                newNode.neighbors.add(dfsClone(neighbor));
            }
            return newNode;
        }
    }
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
