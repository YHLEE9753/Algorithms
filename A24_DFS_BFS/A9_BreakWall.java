package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A9_BreakWall {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

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
        int result = map[n-1][m-1];
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void bfs(int col, int row) {
        Queue<Point1> q = new LinkedList<>();
        q.add(new Point1(col, row, 1,1));
        visit[col][row] = true;
        int c, r;

        while (!q.isEmpty()) {
            Point1 temp = q.poll();

            if(temp.getCol()== n-1 && temp.getRow()== m-1){
                answer = temp.getWalk();
                break;
            }
            for (int i = 0; i < 4; i++) {
                c = dx[i] + temp.getCol();
                r = dy[i] + temp.getRow();

                if (c >= 0 && r >= 0 && c < n && r < m) {
                    if(map[c][r] == 0 && !visit[c][r]) {
                        q.add(new Point1(c,r,temp.getBomb(),temp.getWalk()+1));
//                        map[c][r] = map[temp.getCol()][temp.getRow()] + 2;
                        visit[c][r] = true;
                    }
                    else if(map[c][r] == 1 && !visit[c][r] && temp.getBomb()==1){
                        q.add(new Point1(c,r,0, temp.getWalk()+1));
//                        map[c][r] = map[temp.getCol()][temp.getRow()] + 2;
                        visit[c][r] = true;
                    }
                }
            }

        }
    }
    static class Point1 {
        private int col;
        private int row;
        private int bomb;
        private int walk;

        public Point1(int col, int row, int bomb, int walk) {
            this.col = col;
            this.row = row;
            this.bomb = bomb;
            this.walk = walk;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        public int getBomb() {
            return bomb;
        }

        public int getWalk() {
            return walk;
        }
    }
}

