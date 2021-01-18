package com.xqc.Graph;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Digraph
 * @Author Administrator
 * @Date 2020/12/22/022 21:47
 * @Description TODO
 */
public class Digraph {
    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;
    public Digraph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        //初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            //adj[i] = new Queue<Integer>();
            adj[i] = new PriorityQueue<>();

        }
    }

    //获取顶点数目
    public int V() {
        return V;
    }

    //获取边的数目
    public int E() {
        return E;
    }

    //向有向图中添加一条边 v->w
    public void addEdge(int v, int w) {
        //由于有向图中边是有向的，v->w 边，只需要让w出现在v的邻接表中，而不需要让v出现在w的邻接表中
        adj[v].add(w);
        //边的数目自增1
        E++;
    }

    //获取由v指出的边所连接的所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    //该图的反向图
    private Digraph reverse() {
        //创建新的有向图对象
        Digraph r = new Digraph(V);
        //遍历0~V-1所有顶点,拿到每一个顶点v
        for (int v = 0; v < V; v++) {
            //得到原图中的v顶点对应的邻接表,原图中的边为 v->w,则反向图中边为w->v;
            for (Integer w : adj(v)) {
                r.addEdge(w, v);
            }
        }
        return r;
    }
}
