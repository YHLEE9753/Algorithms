package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        ////////////////////
        int min = Math.min(a,b);
        int gcd = 0;
        for(int i = 1;i<=min;i++){
            if(a%i==0 && b%i == 0){
                gcd = i;
            }
        }
        System.out.println("최대공약수 : "+gcd);
        System.out.println("최소공배수 : "+a*b/gcd);

        /////////////////////
        gcd = gcd(a, b);
        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }

    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }
}
