package com.xqc.function;

import java.util.Scanner;

/**
 * 
 * @author xqc
 * @data 2020年2月18日
 * Description:
 * 并查集
 * 1:判断两个点是不是在一个集合
 * 2:把两个点加入到一个集合
 */
public class DisJointSet {
	static int maxn = 10000+10;
	//保存祖先
	static int[] parent;
	//rank记录每个树的高度
	static int[] rank ;
	/**
	 * 并查集初始化
	 */
	public static void init(){
		parent = new int[maxn];
		rank =new int[maxn];
		for(int i = 0;i<maxn;i++){
			//初始化父节点为自己
			parent[i]=i;
		    rank[i]=1;
		}
	}
	/**
	 * 查找根节点并进行路径压缩
	 * @param x
	 * @return
	 */
	public int findRoot(int x){
		//return parent[x] == x ? x : ((int)parent[x]=findRoot(parent[x]));
		while(parent[x]!=x){
			parent[x]=parent[parent[x]];//路径压缩
			x=parent[x];
		}
		return x;
	}
	//判断两个原数是否在同一个集合中
	public boolean isSameSet(int x,int y){
		return findRoot(x)==findRoot(y);
	}
	//合并两个集合
	public void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        //若果是属于一个集合，直接退出
        if (xRoot == yRoot) {
            return;
        }
        //x的树高，y的根接到x的根上，yRoot的父指针指向xRoot
        if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else if (rank[yRoot] > rank[xRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] ++;
        }
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		System.out.println(str);
		
		
	}

}
