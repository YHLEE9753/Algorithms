package A20_Division;

import java.util.Scanner;

public class A3_NumberOfPaper {
    static int [][] board;
    static int numMinus1 = 0;
    static int num0 = 0;
    static int num1 = 0;
    static int first;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0,0,n);
        System.out.println(numMinus1);
        System.out.println(num0);
        System.out.println(num1);
    }

    private static void dfs(int row, int col, int size) {
        if(isCheck(row, col, size)){
            if(first == -1) numMinus1+=1;
            if(first == 0) num0+=1;
            if(first == 1) num1+=1;
            return;
        }

        int newSize = size/3;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                dfs(row + newSize*i, col+newSize*j,newSize);
            }
        }
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
