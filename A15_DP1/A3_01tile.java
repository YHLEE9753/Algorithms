package A15_DP1;

import java.util.Scanner;

public class A3_01tile {
	static int [] memo = new int[1000001];
	static final int DIVIDE = 15746;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		memo[1] = 1;
		memo[2] = 2;
		for(int i = 3; i<=n;i++){
			memo[i] = (memo[i-1] + memo[i-2])%DIVIDE;
		}
		System.out.println(memo[n]);
	}
}
