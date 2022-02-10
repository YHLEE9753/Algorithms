package A09_Math2;

import java.util.Scanner;

public class A11_Turret {

    static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
        //점과 점사이 거리
        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        int min = r1;
        int max = r2;
        int cmp = 0;
        if (min > r2) {
            cmp = max;
            max = min;
            min = cmp;
        }
        if (d == 0 && r1 == r2) return -1;

        if (d > r1 + r2) {
            return 0;
        } else if (d == r1 + r2) {
            return 1;
        } else if (d > max - min && d < max + min) {
            return 2;
        } else if (d == max - min) {
            return 1;
        } else if (max - min > d) {
            return 0;
        } else if (d == 0 && r1 != r2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(solve(x1, y1, r1, x2, y2, r2));

        }
    }
}