package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A6_Ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int start = sc.nextInt();
        for(int i = 1;i<n;i++){
            int now = sc.nextInt();
            int gcdVal = gcd(Math.max(start, now), Math.min(start,now));
            System.out.println(start/gcdVal+"/"+now/gcdVal);
        }
    }
    static int gcd(int a, int b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
}
