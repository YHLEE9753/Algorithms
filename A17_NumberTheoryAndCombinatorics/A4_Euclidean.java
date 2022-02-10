package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A4_Euclidean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(x*y/gcd(x,y));
        }
    }

    private static int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b , a%b);
    }
}
