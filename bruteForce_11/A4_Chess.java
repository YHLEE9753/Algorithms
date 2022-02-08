package bruteForce_11;

import java.util.Arrays;
import java.util.Scanner;

public class A4_Chess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        String[][] board = new String[a][b];
        String[][] answer1 = new String[8][8];
        String[][] answer2 = new String[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 1 && j % 2 == 1) {
                    answer1[i][j] = "W";
                    answer2[i][j] = "B";
                } else if (i % 2 == 1 && j % 2 == 0) {
                    answer1[i][j] = "B";
                    answer2[i][j] = "W";
                } else if (i % 2 == 0 && j % 2 == 1) {
                    answer1[i][j] = "B";
                    answer2[i][j] = "W";
                } else if (i % 2 == 0 && j % 2 == 0) {
                    answer1[i][j] = "W";
                    answer2[i][j] = "B";
                }
            }
        }

        for (int i = 0; i < a; i++) {
            board[i] = sc.nextLine().split("");
        }

        int result = 64;
        for (int i = 0; i <= a - 8; i++) {
            for (int j = 0; j <= b - 8; j++) {
                int count1 = 0;
                int count2 = 0;
                // 시작 줄 : i, 시작 열 : j
                // 체크시작
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if(!answer1[k-i][l-j].equals(board[k][l])){
                            count1 += 1;
                        }
                        if(!answer2[k-i][l-j].equals(board[k][l])){
                            count2 += 1;
                        }
                    }
                }
                int count = count1<count2 ? count1: count2;
                result = result < count ? result : count;
            }
        }
        System.out.println(result);
    }
}
