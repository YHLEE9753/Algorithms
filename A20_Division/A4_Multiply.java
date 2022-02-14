package A20_Division;

import java.util.Scanner;

public class A4_Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(dfs(a, b, c));
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
