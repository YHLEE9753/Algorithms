package A24_DFS_BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class A0_BFS_Array{
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
            int start = 1; // 시작 노드
            visited = new boolean[9];
            bfs(start);
            System.out.println();
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

}

