package com.xqc.classic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 广度优先遍历
 * @author xqc
 * @data 2020年2月17日
 * Description:
 */
public class BFS {
	
	private void bfs1(boolean[] isVisited,int i) {
		//表示队列的头节点对应的下标
		int u;
		//邻接节点w
		int w;
		//队列，记录节点访问的顺序
		LinkedList queue = new LinkedList();
		//访问节点，输出节点信息
		System.out.println(i+"--->");
		//标记为已访问
		isVisited[i] = true;
		//将节点加入到队列
		queue.addLast(i);
		while(!queue.isEmpty()){
			//取出队列的头节点的下标
			u = (Integer)queue.removeFirst();
			//得到第一个邻接节点的下标w
			w = getFirstNeighbor(u);
			//找到
			while(w!= -1){
				//是否被访问过
				if(!isVisited[w]){
					System.out.println(w+" ——>");
					//标记为已经访问
					isVisited[w] = true;
					//入队
					queue.addLast(w);
				}
				//以u为前驱点，找到w后面的下一个邻接点
				w = getNextNeighbor(u,w);
			}
		}
		
	}
	
	
	
	
    private int getNextNeighbor(int u, int w) {
		// TODO Auto-generated method stub
		return 0;
	}




	private int getFirstNeighbor(int u) {
		// TODO Auto-generated method stub
		return 0;
	}




	/**
     * 存放节点关系的hashtable，图以邻接表（出边表）表示
     * @param graph
     * @param dist 顶点s到各边的距离
     * @param s 顶点
     * Description:使用队列实现，将第一个加入到队列，
     * 当队列不为空，取出一个节点，将其未访问过的子节点加入到队列中
     * 直至队列为空
     * 
     */
    public static void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, Character s) {
        //建立队列
        Queue<Character> q = new LinkedList<>();
        //给定起始节点
        Character start = s;
        //起始节点放到距离表中
        dist.put(start, 0);
        ((LinkedList<Character>) q).add(start);
        //当队列不为空时
        while (q != null) {
            //取出队首元素
            Character poll = q.poll();
            if(poll == null){
                break;
            }
            Integer distance = dist.get(poll);
            System.out.println("节点" + poll + "到起始节点" + start + "的距离为" + distance);
            distance++;
            //遍历该节点的邻接表中的每一个节点，如未访问过，将邻接节点加入
            for (Character c : graph.get(poll)) {
                //未访问过即节点距离没有加入到dist的hashmap中
                if (!dist.containsKey(c)) {
                    dist.put(c, distance);
                    //当队列为空时候，使用add方法会报错，而offer方法会返回false。
                    //作为List使用时,一般采用add / get方法来 压入/获取对象。
                    //作为Queue使用时,才会采用 offer/poll/take等方法作为链表对象时,
                    //offer等方法相对来说没有什么意义这些方法是用于支持队列应用的。
                    q.offer(c);
                   
                }
            }
        }

    }
    
    public static void main(String[] args) {
        HashMap<Character, LinkedList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> dist = new HashMap<>();

        // s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();

        list_s.add('A');

        list_s.add('B');

        LinkedList<Character> list_a = new LinkedList<Character>();

        list_a.add('C');

        list_a.add('D');

        LinkedList<Character> list_b = new LinkedList<Character>();

        list_b.add('D');

        list_b.add('E');

        LinkedList<Character> list_c = new LinkedList<Character>();

        list_c.add('E');

        LinkedList<Character> list_d = new LinkedList<Character>();

        list_c.add('E');


        //构造图

        graph.put('S', list_s);

        graph.put('A', list_a);

        graph.put('B', list_b);

        graph.put('C', list_c);

        graph.put('D', list_d);

        graph.put('E', new LinkedList<Character>());


        //调用

       BFS.bfs(graph, dist, 'S');

    }

}




