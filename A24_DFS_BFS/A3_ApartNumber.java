package A24_DFS_BFS;

import java.awt.*;
import java.io.*;
import java.util.*;

public class A3_ApartNumber {
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static ArrayList al = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화
        int call_num = 0;
        n = Integer.valueOf(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = (s.charAt(j) - '0');
            }
        }

        // 모든 좌표를 돌면서 단지 형성이 가능한지 체크한다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j);
                    call_num++;
                }
            }
        }
        System.out.println(call_num);
        Collections.sort(al);
        al.stream().forEach(System.out::println);

    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        int nx, ny;
        int local_cnt = 1;
        q.offer(new Point(i, j));
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int h = 0; h < 4; h++) {
                nx = now.getX() + dx[h];
                ny = now.getY() + dy[h];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(map[nx][ny] == 1 && visited[nx][ny]==0){
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = 1;
                        local_cnt++;
                    }

                }
            }
        }
        al.add(local_cnt);

    }

}
