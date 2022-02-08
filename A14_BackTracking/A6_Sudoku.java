package A14_BackTracking;

import java.util.Scanner;

public class A6_Sudoku {
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
    }

    private static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // 출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (possibility(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }
        dfs(row, col + 1);
    }

    private static boolean possibility(int row, int col, int value) {
        // 행 체크
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        // 열 체크
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }
        // 3*3 box 체크
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
