package A24_DFS_BFS;

import java.util.*;

public class A0_MakeGraph_List {

    // 인접리스트 이용하기
    // 내가 어디로 갈지를 알려주기만 하므로 어디로 갈지는 내가 찾아서 가보면 된다.
    // 한 지점에서 연결되는 지점만 있기 때문에 메모리 비율이 작어 시간복잡도가 줄어든다.
    // 단점은  A, B 노드가 연결되었는지를 알고 싶은 경우 A 에 B 가 있는지와 B 에 A 가 있는지 확인해야되므로 직접 다 뒤적거려야 한다.

    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int n, m, start;

    public static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < graph[v].size(); i++) {
            int num = graph[v].get(i);
            if(visit[num] == false){
                dfs(num);
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

            for (int i = 0; i < graph[v].size(); i++) {
                int num = graph[v].get(i);
                if(visit[num] == false) {
                    q.offer(num);
                    visit[num] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        graph = new ArrayList[n+1];
        visit = new boolean[n + 1];

        // 간선 리스트 초기화
        for(int i =1;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        // 값 할당
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(start);
        System.out.println();
        Arrays.fill(visit, false);
        bfs(start);
    }
}
