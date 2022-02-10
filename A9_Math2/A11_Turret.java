package A9_Math2;

import java.util.Scanner;

public class A11_Turret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int raiderDistance = (r1 + r2);
            double realDistance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            } else if (x1 == x2 && y1 == y2){
                System.out.println(0);
            } else if (raiderDistance < realDistance) {
                System.out.println(0);
            } else if (raiderDistance == realDistance) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
