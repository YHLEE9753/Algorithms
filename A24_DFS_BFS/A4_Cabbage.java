package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A4_Cabbage {
    static int [][] map;
    static boolean [][] visit;
    static int totalCount;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0;i<testCase;i++){
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            map = new int [n][m];
            visit = new boolean [n][m];
            totalCount = 0;
            for(int j = 0;j<k;j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            // 전체 탐색
            for(int j = 0;j<n;j++){
                for(int l = 0;l<m;l++){
                    if(map[j][l] == 1 && !visit[j][l]){
                        bfs(j,l);
                        totalCount++;
                    }
                }
            }
            System.out.println(totalCount);
        }
    }

    private static void bfs(int a, int b) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a,b));
        visit[a][b] = true;
        int x,y;

        while(!q.isEmpty()){
            Point temp = q.poll();
            for(int i = 0;i<4;i++){
                x = temp.getX() + dx[i];
                y = temp.getY() + dy[i];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(map[x][y]==1 && !visit[x][y]){
                        q.add(new Point(x,y));
                        visit[x][y] = true;
                    }
                }
            }
        }
    }
}

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
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
