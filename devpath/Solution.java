package devpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] values;
	static int[] edge;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int result = -2;
	public long solution(int[] a, int[][] edges) {
		values = a;
		edge = new int[edge.length+1];
		for(int i = 0;i<edges.length+1;i++){
			graph.add(new ArrayList<>());
		}
		for(int i = 0;i<edges.length; i++){
			int node1 = edges[i][0];
			int node2 = edges[i][1];
			edge[node1]++;
			edge[node2]++;
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i = 1;i<edge.length;i++){
			if(edge[i]==1){
				q.offer(i);
			}
		}

		while(!q.isEmpty()){
			Integer temp = q.poll();
			result++;
			for(Integer num : graph.get(temp)){
				edge[num]--;
				values[num] += values[temp];
				q.offer(num);
			}
		}

		return result;
	}
}