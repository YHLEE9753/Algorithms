package A14_BackTracking;

import java.util.Scanner;

public class A7_Operator {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] number;
    static int[] operator = new int[4];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        dfs(number[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void dfs(int num, int idx) {
        // 종료
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {
                // 해당 연산자를 1 감소시킨다
                operator[i]--;

                switch (i) {
                    case 0: dfs(num + number[idx], idx + 1);break;
                    case 1: dfs(num - number[idx], idx + 1);break;
                    case 2: dfs(num * number[idx], idx + 1);break;
                    case 3: dfs(num / number[idx], idx + 1);break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}
