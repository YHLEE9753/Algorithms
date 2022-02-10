package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A9_Bridge {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        dp = new int[31][31];
        for(int i = 0;i<num;i++){
            int r = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(combination(n,r));
        }
    }

    private static int combination(int n, int r) {
        if(n==r||r==0) return 1;
        if(dp[n][r]>0) return dp[n][r];
        return dp[n][r] = combination(n-1,r-1) + combination(n-1,r);
    }
}
