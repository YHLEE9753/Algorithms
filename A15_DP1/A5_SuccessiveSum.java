package A15_DP1;

import java.util.Arrays;
import java.util.Scanner;

public class A5_SuccessiveSum {
	static int [] arr;
	static int [] sol;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		sol = new int[n+1];
		Arrays.fill(sol, -1001);

		for(int i = 1;i<n+1;i++){
			arr[i] = sc.nextInt();
		}

		for(int i = 1;i<n+1;i++){
			sol[i] = Math.max(arr[i], sol[i-1]+arr[i]);
		}
		Arrays.sort(sol);
		System.out.println(sol[n]);

	}
}
