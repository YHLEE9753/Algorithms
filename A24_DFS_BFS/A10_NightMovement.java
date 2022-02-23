package A24_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A10_NightMovement {
    static boolean[][] visit;
    static int size;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            size = sc.nextInt();
            visit = new boolean[size][size];
            Position now = new Position(sc.nextInt(), sc.nextInt(), 0);
            Position goal = new Position(sc.nextInt(), sc.nextInt(), 0);
            bfs(now, goal);
        }
    }

    private static void bfs(Position now, Position goal) {
        Queue<Position> q = new LinkedList<>();
        q.add(now);
        visit[q.peek().getX()][q.peek().getY()] = true;

        while (!q.isEmpty()) {
            Position temp = q.poll();

            // 탈출포인트
            if (temp.getX() == goal.getX() && temp.getY() == goal.getY()) {
                System.out.println(temp.getCount());
                break;
            }

            int x, y;
            for (int i = 0; i < 8; i++) {
                x = dx[i] + temp.getX();
                y = dy[i] + temp.getY();

                if (x >= 0 && y >= 0 && x < size && y < size) {
                    if(!visit[x][y]){
                        q.add(new Position(x,y,temp.getCount()+1));
                        visit[x][y] = true;
                    }
                }
            }
        }

    }
}
class Position {
    private int x;
    private int y;
    private int count;

    public Position(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }
}