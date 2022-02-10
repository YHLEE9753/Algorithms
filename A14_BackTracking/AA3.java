package A14_BackTracking;

import java.util.Scanner;

public class AA3 {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(n, m, depth + 1);
        }
    }
}
