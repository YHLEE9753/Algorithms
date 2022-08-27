package A15_DP1;

import java.util.Arrays;
import java.util.Scanner;

public class A7_IntegerTriangle {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				int value = sc.nextInt();
				arr[i][j] = Math.max(arr[i-1][j-1] + value, arr[i-1][j] + value);
			}
		}
		Arrays.sort(arr[n]);
		System.out.println(arr[n][n]);
	}
}
