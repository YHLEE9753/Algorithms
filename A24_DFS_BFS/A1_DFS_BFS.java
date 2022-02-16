package A24_DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

    public class A1_DFS_BFS {

        // 인접행렬 이용하기
        // 1번 지점 부터 K 번 지점까지 연결되었는지 확인하기 위해 A[1][0~K]를 모든 갯수를 탐색행 한다.
        // 그 갯수는 v 가 많아질수록 시간이 오래걸리고 v 만큼 다 돌기 때문에 시간초과가 발생할 확률이 높다.
        // 꼭짓점(vertex) 가 적은 경우에만 사용하는 것이 좋다.

        static int graph[][];
        static boolean[] visit;
        static int n, m, start;

        public static void dfs(int v) {
            visit[v] = true;
            System.out.print(v + " ");

            for (int i = 1; i < n + 1; i++) {
                if (graph[v][i] == 1 && visit[i] == false) {
                    dfs(i);
                }
            }
        }

        public static void bfs(int v) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(v);
            visit[v] = true;
            while (!q.isEmpty()) {
                int temp = q.poll();
                System.out.print(temp + " ");

                for (int i = 1; i < n + 1; i++) {
                    if (graph[temp][i] == 1 && visit[i] == false) {
                        q.offer(i);
                        visit[i] = true;
                    }
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            start = sc.nextInt();
            graph = new int[n + 1][n + 1];
            visit = new boolean[n + 1];

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            dfs(start);
            System.out.println();
            Arrays.fill(visit, false);
            bfs(start);
        }
    }
