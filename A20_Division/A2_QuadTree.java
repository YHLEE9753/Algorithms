package A20_Division;

import java.util.Scanner;

public class A2_QuadTree {
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static int first;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        board = new int[n][n];

        // 초기화
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.valueOf(line[j]);
            }
        }

        dfs(0, 0, n);
        System.out.println(sb);
    }

    private static void dfs(int row, int col, int size) {
        if (isCheck(row, col, size)) {
            sb.append(first);
            return;
        }
        if(size==1) return;

        int newSize = size / 2;
        sb.append("(");
        dfs(row, col, newSize);
        dfs(row, col + newSize, newSize);
        dfs(row + newSize, col, newSize);
        dfs(row + newSize, col + newSize, newSize);
        sb.append(")");
    }

    private static boolean isCheck(int row, int col, int size) {
        first = board[row][col];
        for(int i = row;i<row+size;i++){
            for(int j = col;j<col+size;j++){
                if(first!=board[i][j]) return false;
            }
        }
        return true;
    }
}
