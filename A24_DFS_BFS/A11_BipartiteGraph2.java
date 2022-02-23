package A24_DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A11_BipartiteGraph2 {
    static int v, e;
    static ArrayList<Integer>[] al;
    static int[] visit;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            v = sc.nextInt(); // 정점의 개수
            e = sc.nextInt(); // 간선의 개수
            al = new ArrayList[v + 1];
            visit = new int[v + 1];
            // 그래프 초기화
            for (int j = 1; j <= v; j++) {
                al[j] = new ArrayList<Integer>();
            }
            // 인접 리스트 초기화
            int start = 0, end = 0;
            for (int j = 0; j < e; j++) {
                start = sc.nextInt();
                end = sc.nextInt();
                al[start].add(end);
                al[end].add(start);
            }
            bfs(start);

        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (visit[i]==0) {
                q.add(i);
                visit[i] = 1;
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int j = 0; j < al[now].size(); j++) {
                    if (visit[al[now].get(j)]==0){
                        q.add(al[now].get(j));
                    }
                    if(visit[al[now].get(j)] == visit[now]){
                        System.out.println("NO");
                        return;
                    }
                    if(visit[now]==1 && visit[al[now].get(j)]==0){
                        visit[al[now].get(j)] = 2;
                    }else if(visit[now]==2 && visit[al[now].get(j)]==0){
                        visit[al[now].get(j)] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }

}