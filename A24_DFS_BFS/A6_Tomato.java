package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A6_Tomato {
    static int[][] map;
    static boolean[][] visit;
    static int m;
    static int n;
    static int result = 0;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Queue<Point> q;
    public static void main(String[] args) {
        // 초기화
        Scanner sc = new Scanner(System.in);
        q = new LinkedList<>();
        m = sc.nextInt();
        n = sc.nextInt();
        visit = new boolean[n][m];
        map = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                map[i][j] = sc.nextInt();
                // 1인 값들은 미리 큐에 집어 넣는다.
                if(map[i][j]==1){
                    q.add(new Point(i,j));
                }
            }
        }
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        // 1인 값들을 전부 가지고 온다.
        while(!q.isEmpty()){
            Point temp = q.poll();
            int x,y;
            for(int i = 0;i<4;i++){
                x = temp.getX() + dx[i];
                y = temp.getY() + dy[i];

                if(x>=0&& y>=0 && x<n&&y<m){
                    // 그 상하좌우로 0 인 값이 있으면 값을 +1 해준다.
                    if(!visit[x][y] && map[x][y]==0){
                        map[x][y] = map[temp.getX()][temp.getY()]+1;
                        visit[x][y] = true;
                        // 그리고 다시 큐에 추가한다.
                        q.add(new Point(x,y));
                    }
                }
            }
        }

        // map 을 한번 다시 탐색하면서 체크한다.
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                result = Math.max(result, map[i][j]);
                if(map[i][j]==0) {
                    result = -1;
                    return;
                }
            }
        }
        result--;
    }
}
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
