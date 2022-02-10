package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A7_BinomialCoefficient1 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dp = new int[n+1][r+1];
        System.out.println(combination(n,r));
    }

    private static int combination(int n, int r) {
        if(n==r||r==0) return 1;
        if(dp[n][r]>0) return dp[n][r];
        return (combination(n-1,r-1)+combination(n-1,r));
    }
}
