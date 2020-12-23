package com.leetcode.Graph.medium;

import javafx.beans.binding.MapExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName cloneGraphSolution
 * @Author Administrator
 * @Date 2020/12/16/016 19:59
 * @Description TODO
 */
public class cloneGraphSolution {
    private static MapExpression<Node, Node> map;

    public static void main(String[] args) {

    }
    public static Node cloneGraph(Node node) {
        if(node.neighbors.size()==0)return new Node(node.val,new ArrayList<>());
        dfs(node);
        return node;

    }

    private static void dfs(Node node) {
 /*       for (Node n:node.neighbors) {
            if(!map.containsKey(n)){
                Node t = new Node(n.val,)
            }

        }*/
    }


     static class Node {
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
