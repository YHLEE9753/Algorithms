package A24_DFS_BFS;

import java.sql.SQLOutput;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class A0_DFS_BFS {
    // 각 노드개 방문한 정보
    private static boolean[] visited;
    // 그래프 2차원 배열 자료형으로표현
    private static int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};

    public static void main(String[] args) {
        visited = new boolean[9];
        int start = 1; // 시작 노드
        dfs(start);
        System.out.println();

        visited = new boolean[9];
        dfsStack(graph,start,visited);
        System.out.println();

        visited = new boolean[9];
        bfs(start);
        System.out.println();
    }

    private static void dfs(int v) {
        // 현재 방문 노드 방문 처리
        visited[v] = true;
        // 방문 노드 출력
        System.out.print(v + " ");
        // 인접 노드 탐색
        for (int i : graph[v]) {
            // 방문하지 않은 인접 노드중 가장 작은 노드 스택에 넣기
            if (visited[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");
            for (int i : graph[v]) {
                if (visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    private static void dfsStack(int[][] graph, int start, boolean[] visited) {
        //시작 노드를 방문 처리
        visited[start] = true;
        System.out.print(start + " ");//방문 노드 출력

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start); //시작 노드를 스택에 입력

        while (!stack.isEmpty()) {
            int now = stack.peek();

            boolean hasNearNode = false; // 방문하지 않은 인접 노드가 있는지 확인
            //인접한 노드를 방문하지 않았을 경우 스택에 넣고 방문처리
            for (int i : graph[now]) {
                if (!visited[i]) {
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");//방문 노드 출력
                    break;
                }
            }
            //반문하지 않은 인접 노드가 없는 경우 해당 노드 꺼내기
            if (hasNearNode == false)
                stack.pop();
        }
    }
}

