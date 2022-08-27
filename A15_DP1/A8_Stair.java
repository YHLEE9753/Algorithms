package A15_DP1;

import java.util.Scanner;

public class A8_Stair {
	static int[] stair;
	static int[] sol;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		stair = new int[n + 1];
		sol = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			stair[i] = sc.nextInt();
		}
		// solution
		sol[1] = stair[1];
		if (n != 1) {
			sol[2] = Math.max(stair[2], sol[1] + stair[2]);
		}
		for (int i = 3; i < n + 1; i++) {
			sol[i] = Math.max(sol[i - 3] + stair[i - 1] + stair[i], sol[i - 2] + stair[i]);
		}
		System.out.println(sol[n]);
	}
}
