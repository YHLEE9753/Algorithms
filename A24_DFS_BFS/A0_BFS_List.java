package A24_DFS_BFS;

import java.util.*;

public class A0_BFS_List {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int n, m, start;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

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
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]); // 방문 순서를 위해 오름차순 정렬
        }

        bfs(start);
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.println(temp + " ");
            for (int i = 0; i < graph[temp].size(); i++) {
                int num = graph[temp].get(i);
                if (visit[num] == false) {
                    q.add(num);
                    visit[num] = true;
                }
            }
        }
    }

}
