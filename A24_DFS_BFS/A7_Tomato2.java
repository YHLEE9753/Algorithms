package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A7_Tomato2 {
    static int m;
    static int n;
    static int h;
    static int[][][] map;
    static boolean[][][] visit;
    static Queue<Tomato> q;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        // 초기화
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();
        map = new int[h][n][m];
        visit = new boolean[h][n][m];
        q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    map[i][j][k] = sc.nextInt();
                    if(map[i][j][k] == 1){
                        q.add(new Tomato(k, j, i));
                    }
                }
            }
        }

        // bfs
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Tomato temp = q.poll();
            int xx, yy, hh;
            for (int i = 0; i < 6; i++) {
                xx = dx[i] + temp.getX();
                yy = dy[i] + temp.getY();
                hh = dh[i] + temp.getH();
                if (xx >= 0 && yy >= 0 && hh >= 0 && xx < m && yy < n && hh < h) {
                    if (map[hh][yy][xx] == 0 && !visit[hh][yy][xx]) {
                        q.add(new Tomato(xx, yy, hh));
                        map[hh][yy][xx] = map[temp.getH()][temp.getY()][temp.getX()] + 1;
                        visit[hh][yy][xx] = true;
                    }
                }
            }

        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int num = map[i][j][k];
                    if (num == 0) {
                        result = -1;
                        return;
                    }
                    result = Math.max(result, num);
                }
            }
        }
        result--;
    }
}

class Tomato {
    private int x;
    private int y;
    private int h;

    public Tomato(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }
}