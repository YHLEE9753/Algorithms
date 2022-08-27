package A15_DP1;

import java.util.Scanner;

public class A4_wave {
	static long[] memo = new long[101];

	public static void main(String[] args) {
		memo[1] = 1;
		memo[2] = 1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i<n;i++){
			int num = sc.nextInt();
			solution(num);
			System.out.println(memo[num]);
		}
	}

	private static void solution(int num) {
		for(int i = 3;i<=num;i++){
			if(memo[i]!=0) continue;
			memo[i] = memo[i-2] + memo[i-3];
		}
	}
}
