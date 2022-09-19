package Programmers_Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Implement {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();

		graph = new ArrayList[n + 1];
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
		bfs(v);
		dfs(v);

	}

	private static void dfs(int start) {
		visited[start] = true;
		for(int i = 0;i<graph[start].size();i++){
			int num = graph[start].get(i);
			if(!visited[num]){
				dfs(num);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < graph[temp].size(); i++) {
				int num = graph[temp].get(i);
				if (!visited[num]) {
					q.add(num);
					visited[num] = true;
				}
			}

		}
	}
}
/*

package Programmers_Test1;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[][] graph;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visit;
	static boolean endGame = false;
	static int result = 0;

	public int solution(int[][] board, int r, int c) {
		graph = board;
		Pointer start = new Pointer(c, r, graph[c][r]);
		while (true) {
			visit = new boolean[4][4];

			// 가장 가까운 그림 찾기
			Pointer closePointer = bfs(start);
			if (endGame) {
				break;
			}
			// 첫 그림을 찾은 경우
			result += findShortPath(start, closePointer) + 1;

			// 첫 그림과 같은 그림을 찾기
			visit = new boolean[4][4];
			Pointer secondPicture = bfsWithCard(closePointer);

		}
		int answer = 0;
		return answer;
	}

	private Pointer bfsWithCard (Pointer pointer) {
		// 가장 가까우면서 같은 그림을 찾아라
		int card = pointer.card;
		Queue<Pointer> q = new LinkedList<>();
		q.add(pointer);
		visit[pointer.x][pointer.y] = true;
		while (!q.isEmpty()) {
			Pointer temp = q.poll();
			int xx;
			int yy;
			for (int i = 0; i < 4; i++) {
				xx = temp.x + dx[i];
				yy = temp.y + dy[i];
				if (xx >= 0 && yy >= 0 && xx < 4 && yy < 4) {
					if (!visit[xx][yy] && graph[xx][yy] == card) {
						return new Pointer(xx, yy, graph[xx][yy]);
					}
				}
			}
		}
		// 그림이 없으면 게임 끝
		endGame = true;
		return null;

	}

	private Pointer bfs(Pointer pointer) {
		// 처음 시작할때 그림위에 존재하는 경우
		if (graph[pointer.x][pointer.y] != 0) {
			return pointer;
		}
		// 가장 가까운 그림을 찾아라
		Queue<Pointer> q = new LinkedList<>();
		q.add(pointer);
		visit[pointer.x][pointer.y] = true;
		while (!q.isEmpty()) {
			Pointer temp = q.poll();
			int xx;
			int yy;
			for (int i = 0; i < 4; i++) {
				xx = temp.x + dx[i];
				yy = temp.y + dy[i];
				if (xx >= 0 && yy >= 0 && xx < 4 && yy < 4) {
					if (!visit[xx][yy] && graph[xx][yy] != 0) {
						return new Pointer(xx, yy, graph[xx][yy]);
					}
				}
			}
		}
		// 그림이 없으면 게임 끝
		endGame = true;
		return null;
	}

	private int findShortPath(Pointer start, Pointer closePointer) {
		int x = start.x - closePointer.x;
		int y = start.y - closePointer.y;
		int count1 = 0;
		// case1
		if (x > 0) {
			for (int i = start.x - 1; i >= start.x - x; i--) {
				if (graph[i][start.y] != 0)
					count1++;
			}
			count1++;
		} else if (x < 0) {
			for (int i = start.x + 1; i <= start.x - x; i++) {
				if (graph[i][start.y] != 0)
					count1++;
			}
			count1++;
		}

		if (y > 0) {
			for (int i = start.y - 1; i >= start.y - y; i--) {
				if (graph[closePointer.x][i] != 0)
					count1++;
			}
			count1++;
		} else if (y < 0) {
			for (int i = start.y + 1; i <= start.y - x; i++) {
				if (graph[closePointer.x][i] != 0)
					count1++;
			}
			count1++;
		}
		// case 2
		int count2 = 0;

		if (y > 0) {
			for (int i = start.y - 1; i >= start.y - y; i--) {
				if (graph[closePointer.x][i] != 0)
					count2++;
			}
			count2++;
		} else if (y < 0) {
			for (int i = start.y + 1; i <= start.y - x; i++) {
				if (graph[closePointer.x][i] != 0)
					count2++;
			}
			count2++;
		}
		if (x > 0) {
			for (int i = start.x - 1; i >= start.x - x; i--) {
				if (graph[i][start.y] != 0)
					count2++;
			}
			count2++;
		} else if (x < 0) {
			for (int i = start.x + 1; i <= start.x - x; i++) {
				if (graph[i][start.y] != 0)
					count2++;
			}
			count2++;
		}
		return count1 < count2 ? count1 : count2;
	}

	class Pointer {
		int x;
		int y;
		int card;

		public Pointer(int x, int y, int card) {
			this.x = x;
			this.y = y;
			this.card = card;
		}
	}
}
 */