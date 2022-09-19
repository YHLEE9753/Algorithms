package A24_DFS_BFS.복습;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class A1_2667 {
	static int[][] graph;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static List<Integer> countList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int[n][n];
		visit = new boolean[n][n];

		int count = 0;
		countList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1 && !visit[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
		Collections.sort(countList);
		countList.stream().forEach(System.out::println);
	}

	private static void bfs(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(a, b));
		visit[a][b] = true;
		int count = 0;

		while (!q.isEmpty()) {
			Point temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (graph[nx][ny] == 1 && !visit[nx][ny]) {
						q.add(new Point(nx, ny));
						visit[nx][ny] = true;
						count++;
					}
				}
			}
		}
		countList.add(count+1);
	}

	static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
