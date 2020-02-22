package com.xqc.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020年2月22日
 * Description:包含图中所有顶点并且权值之和最小
 */
class MinSpanTree {
	/**
	 * 
	 * @author xqc
	 * @data 2020年2月22日
	 * Description:
	 */
	static class Edge{
		//权重
		int weight;
		//两个顶点
		int x;
		int y;
		public Edge(int w,int a,int b){
			weight=w;
			x=a;
			y=b;
		}
	}
	/**
	 * 并查集
	 * @author xqc
	 * @data 2020年2月22日
	 * Description:
	 */
	static class DSU{
		int[] root;//父亲节点
		int[] size;//
		public DSU(int n){
			root = new int[n];
			size = new int[n];
			//初始化将根节点指向自己
			for(int i =0;i<n;i++){
				root[i]=i;
			}
			//一开始每个联通分量都是1
			Arrays.fill(size, 1);
			
		}
		public int findRoot(int x){
			if(root[x]!=x){
				root[x]=findRoot(root[x]);
			}
			return root[x];
		}
		public void union(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			if(rootX==rootY)return;
			//如果rootX更小，就把rootX的父就是rootY
			if(size[rootX]<size[rootY]){
				root[rootX]=rootY;
			}else{
				root[rootY] = rootX;
			}
		}
		
	}
	
	static class Pair{
		int weight;
		int y;
		public Pair(int w,int b){
			weight = w;
			y = b;
		}
	}
	
	
	public static void main(String[] args) {
/*#################################		
		Scanner input = new Scanner(System.in);
		//n个顶点
		int n = input.nextInt();
		//m条边
		int m = input.nextInt();
		Edge[] edges = new Edge[m];
		//读入每条边，得到一个图
		for(int i=0;i<m;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			int w = input.nextInt();
			edges[i] = new Edge(w,a,b);
		}
		

		//用lamda表达式将其按照weight排序
		Arrays.sort(edges,(a,b)->a.weight-b.weight);

		int minmumCost = Kruskal(edges);
		
		System.out.println(minmumCost);
		
##########################*/
		Scanner input = new Scanner(System.in);
		int nodes = input.nextInt();
		int edges = input.nextInt();
		//用邻接表表示图，顶点，与其相邻节点的距离list
		Map<Integer ,List<Pair>> g = new HashMap<>();
		
		for(int i=0;i<edges;i++){
			int a=input.nextInt();
			int b=input.nextInt();
			int w = input.nextInt();
			//如果没有见过就把它put
			g.putIfAbsent(a, new ArrayList<>());
			g.putIfAbsent(b, new ArrayList<>());
			
			g.get(a).add(new Pair(w,b));
			g.get(b).add(new Pair(w,b));
		}
		int minimumCost = Prim(1,g);
		System.out.println(minimumCost);
	}
	/**
	 * 小扩展：贪心选取未在集合中最短的边
	 * @return 
	 */
	private static int Prim(int x,Map<Integer,List<Pair>> g) {
		//表示是否访问过
		boolean[] visited = new boolean[10005];
		
		PriorityQueue<Pair> heap = new PriorityQueue<>((a,b)->a.weight-b.weight);
		heap.offer(new Pair(0,x));
		
		int minimumCost=0;
		while(!heap.isEmpty()){
			Pair p = heap.poll();
			//换成另外一个点
			x=p.y;
			//如果访问过就不再操作了
			if(visited[x]) continue;
			//标志已经访问
			visited[x] = true;
			minimumCost+=p.weight;
			for(int i=0;i<g.get(x).size();i++){
				if(!visited[g.get(x).get(i).y]){
					heap.offer(g.get(x).get(i));
				}
			}
		}
		return minimumCost;
	}
	/**
	 * 边联合：将最小的边加入集合使其并不能形成环
	 * 使用并查集判断其不能成环
	 * 测试用例：
	 * 4 5
	 * 1 2 7
	 * 1 4 6
	 * 4 2 9
	 * 4 3 8
	 * 2 3 6
	 */
	private static int Kruskal(Edge[] edges) {
		//使用并查集
		DSU dsu = new DSU(10005);
		
		int minimumCost = 0;
		for (Edge edge : edges) {
			int x = edge.x;
			int y = edge.y;
			//如果不属于一个联通分量
			if(dsu.findRoot(x)!=dsu.findRoot(y)){
				minimumCost+=edge.weight;
				dsu.union(x,y);
			}
		}	
		return minimumCost;
		
	}

}
