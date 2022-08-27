package A15_DP1;

import java.util.Scanner;

public class A2_funFib {
	static int memo[][][] = new int[51][51][51];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		memo[0][0][0] = 1;
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == -1 & b == -1 & c == -1) {
				break;
			}
			int result = w(a, b, c);
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + result);
		}
	}

	private static int w(int a, int b, int c) {
		if (a <= 0 | b <= 0 | c <= 0) {
			return 1;
		}
		int memorization = checkMemo(a, b, c);
		if (memorization != -1) {
			return memorization;
		}
		if (a > 20 | b > 20 | c > 20) {
			return w(20, 20, 20);
		}
		if (a < b & b < c) {
			memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			return memo[a][b][c];
		}
		memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		return memo[a][b][c];
	}

	private static int checkMemo(int a, int b, int c) {
		int memoValue = memo[a][b][c];
		if (memoValue != 0) {
			return memoValue;
		}
		return -1;
	}
}
