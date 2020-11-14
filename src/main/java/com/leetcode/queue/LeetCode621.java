package com.leetcode.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode621 {
	
	public static void main(String[] args) {
		LeetCode621 leetcode = new LeetCode621();
		LeetCode621.Solution solution = leetcode.getSolution();
		
		char[] tasks = {'A','A','A','B','B','B'};
		int n=2;
		
		solution.leastInterval(tasks, n);
		
	}

	public Solution getSolution(){
		return new Solution();
	}

	class Solution {
	    public int leastInterval(char[] tasks, int n) {
	    	
	    	if(tasks==null)
	    		return 0;
	    	int index=0;
	    	int gas=n;
	    	int time =0;
	    	Map barried = new HashMap<Integer,Integer>();
	    	
	    	barried.put(tasks[0], gas);
	    	
	    	while(barried.size()!=0){
		    	for(int i =1;i<tasks.length;i++){
		    		
		    	}
	    	
	    	}
	    	
	    	
	    	
			return n;
	        
	    }
	}
}
