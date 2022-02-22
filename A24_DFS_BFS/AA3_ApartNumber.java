package A24_DFS_BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AA3_ApartNumber {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 좌표 돌면서 체크
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                    totalCount++;
                }
            }
        }
        System.out.println(totalCount);
        Collections.sort(result);
        result.stream().forEach(System.out::println);
    }

    private static void bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        int x, y;
        q.add(new Point(i, j));
        visited[i][j] = true;
        int local_count = 1;

        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int h = 0; h < 4; j++) {
                x = temp.getX() + dx[h];
                y = temp.getY() + dy[h];

                if (x >= 0 && y >= 0 && x < n && y < n) {
                    if(!visited[x][y] && map[x][x] == 1){
                        q.add(new Point(x,y));
                        visited[x][y] = true;
                        local_count++;
                    }
                }
            }
        }
        result.add(local_count);

    }
}
