package A09_Math2;

import java.util.Scanner;

public class A9_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 0 && b == 0 && c == 0) break;

            if(a>b &&a>c && a*a==b*b+c*c) {
                System.out.println("right");
            }else if(b>a &&b>c && b*b==a*a+c*c){
                System.out.println("right");
            }else if(c>a&&c>b && c*c == a*a+b*b){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}
