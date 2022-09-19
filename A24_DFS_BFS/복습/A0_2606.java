package A24_DFS_BFS.복습;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A0_2606 {
	static ArrayList<Integer>[] graph;
	static boolean visit[];
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점 개수
		int m = sc.nextInt(); // 간선 개수
		graph = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(graph[i]);
		}
		bfs(1);
		System.out.println(count-1);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			Integer temp = q.poll();
			count++;
			for (int i = 0; i < graph[temp].size(); i++) {
				Integer num = graph[temp].get(i);
				if (!visit[num]) {
					q.add(num);
					visit[num] = true;
				}
			}
		}

	}
}
