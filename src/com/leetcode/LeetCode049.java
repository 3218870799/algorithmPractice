package com.leetcode;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode049 {
	
	public static void main(String[] args) {
		LeetCode049 leetcode = new LeetCode049();
		LeetCode049.Solution solution = leetcode.getSolution();
		String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> strs = solution.groupAnagrams(str);
		System.out.println(strs);
		
	}
	
	public Solution getSolution(){
		return new Solution();
	}
	
	
	/**
	 * 按排序分类
	 *
	 */
	class Solution1{
		public List<List<String>> groupAnagrams(String[] strs){
			//判断
			if(strs.length==0) return new ArrayList();
			Map<String,List> ans = new HashMap<String,List>();
			for(String s:strs){
				char[] ca = s.toCharArray();
				//char[] ca = Arrays.sort(s.toCharArray()); sort不返回该字符串，不能用 
				Arrays.sort(ca);
				//String key = ca.toString();
				String key = String.valueOf(ca);
				if(!ans.containsKey(ca))
					ans.put(key, new ArrayList());
				ans.get(key).add(s);
			}
			return new ArrayList(ans.values());
			
		}
	}
	
	/**
	 * 按计数分类
	 *
	 */
	class Solution{
		public List<List<String>> groupAnagrams(String[] strs){
			if(strs.length==0) return new ArrayList<>();
			Map<String,List> ans = new HashMap<String,List>();
			int[] count = new int[26];
			for(String s:strs){
				Arrays.fill(count, 0);
				for(char c : s.toCharArray())
					count[c-'a']++;
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<26;i++){
					sb.append("#");
					sb.append(count[i]);
				}
				String key = sb.toString();
				if(ans.containsKey(key))
					ans.put(key, new ArrayList<>());
				ans.get(key).add(s);
			}
			return new ArrayList(ans.values());
			
		}
		
		
	}
	
	
}
