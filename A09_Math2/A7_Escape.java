package A09_Math2;

import java.util.Scanner;

public class A7_Escape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int x1 = Math.abs(x-w)>=x?x:Math.abs(x-w);
        int y1 = Math.abs(y-h)>=y?y:Math.abs(y-h);
        System.out.println(x1>=y1?y1:x1);
    }
}
