package A20_Division;

import java.util.Scanner;

public class A5_BinomialCoefficient3 {
    static int[][] dp;
    static int mod = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        dp = new int [n+1][k+1];

    }

    private static long dfs(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long temp = dfs(a, b / 2, c);
        if (b % 2 == 0) {
            return (temp % c * temp % c) % c;
        } else {
            return (temp % c * temp % c * a % c) % c;
        }
    }
}
