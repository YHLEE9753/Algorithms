package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A8_HideAndSeek {
    static int[] visit = new int[100001];
    static int b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        b = sc.nextInt();
        if (a == b) {
            System.out.println(0);
        } else {
            bfs(a);
        }
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visit[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                if (next == b) {
                    System.out.println(visit[temp]);
                    return;
                }
                if (next >= 0 && next < 100001 && visit[next] == 0) {
                    q.add(next);
                    visit[next] = visit[temp] + 1;
                }
            }
        }
    }
}