package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A9_BreakWall {
    static int n;
    static int m;
    static int[][] map;
    static int[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }

        bfs(0,0);
    }

    private static void bfs(int startX, int startY) {
        Queue<Integer> q = new LinkedList<>();
        q.add()
    }
}

class Point1{
    private int x;
    private int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}