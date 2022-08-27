package A15_DP1;

import java.util.Arrays;
import java.util.Scanner;

public class A9_Make1 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[1] = 0;

		for (int i = 1; i < n + 1; i++) {
			if(i*3<n+1) memo[i*3] = Math.min(memo[i*3], memo[i]+1);
			if(i*2<n+1) memo[i*2] = Math.min(memo[i*2], memo[i]+1);
			if(i+1<n+1) memo[i+1] = Math.min(memo[i+1], memo[i]+1);
		}
		System.out.println(memo[n]);
	}
}
