package A15_DP1;

import java.util.Scanner;

public class A1_fibo {
	static int count1 = 0;
	static int count2 = 0;
	static int [] memo = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		fib(num);
		fibonacci(num);

		System.out.println(count1 + " " + count2);
	}

	private static int fib(int n) {
		if (n == 1 | n == 2) {
			count1++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private static int fibonacci(int n) {
		memo[0] = 1;
		memo[1] = 1;

		if(n<2){
			return memo[n];
		}
		for (int i = 2; i < n; i++) {
			count2++;
			memo[i] = memo[i-2] + memo[i-1];
		}
		return memo[n];
	}
}
