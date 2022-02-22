package A24_DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A5_MazeSearch {
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        int xx, yy;

        while(!q.isEmpty()){
            Point temp = q.poll();
            for (int h = 0; h < 4; h++) {
                xx = temp.getX() + dx[h];
                yy = temp.getY() + dy[h];
                if (xx >= 0 && yy >= 0 && xx < n && yy < m) {
                    if(map[xx][yy] == 1 && !visit[xx][yy]){
                        q.add(new Point(xx,yy));
                        visit[xx][yy] = true;
                        // map 을 최신화
                        map[xx][yy] = map[temp.getX()][temp.getY()]+1;
                    }
                }
            }
        }

    }
}
//
//class Point{
//    private int x;
//    private int y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//}
