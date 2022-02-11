package A20_Division;

import java.util.Scanner;

public class A1_Confetti {
    static int[][] board;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) {
        // 초기화
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // 진행
        dfs(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size / 2;

        dfs(row, col, newSize);
        dfs(row, col + newSize, newSize);
        dfs(row + newSize, col, newSize);
        dfs(row + newSize, col + newSize, newSize);
    }

    // 현재 파티션의 컬러가 같은지 체크
    private static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}
