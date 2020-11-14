package com.xqc.mapStruction;
/**
 * @ClassName:DFS.java
 * @Author qcxiao
 * @Date:2020年8月13日下午5:09:41
 * @Version:1.0
 * @Description:深度优先搜索
 */
public class DFS {
	
	private void dfs(boolean[] isVisited,int i) {
		//首先访问该节点
		System.out.println(getValueByIndex(i)+"-->");
		//将节点设置为已经访问
		isVisited[i] = true;
		//查找节点i的第一个邻接节点w
		int w = getFirstNeighbor(i);
		//说明有w
		while(w!=-1){
			if(!isVisited[w]){
				dfs(isVisited,w);
			}
			//如果w节点已经被访问过
			w = getNextNeighbor(i,w);
		}
	}

	private int getNextNeighbor(int i, int w) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getFirstNeighbor(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getValueByIndex(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
