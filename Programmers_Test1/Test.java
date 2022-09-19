package Programmers_Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	static int n, m, start;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		start = sc.nextInt();

		graph = new ArrayList[n+1];
		visit = new boolean[n+1];

		for(int i =1;i<n+1;i++){
			graph[i] = new ArrayList<>();
		}
		for(int i = 0;i<m;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i = 1;i<n+1;i++){
			Collections.sort(graph[i]);
		}
		bfs(start);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while(!q.isEmpty()){
			int temp = q.poll();
			for(int i = 0;i<graph[temp].size();i++){
				int num = graph[temp].get(i);
				if(visit[num] == false){
					q.add(num);
					visit[num] = true;
				}
			}
		}
	}
}
