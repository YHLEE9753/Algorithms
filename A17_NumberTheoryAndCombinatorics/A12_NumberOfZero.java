package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A12_NumberOfZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long r = sc.nextLong();
        long five = find5(n) - find5(n-r) - find5(r);
        long two = find2(n) - find2(n-r) - find2(r);
        System.out.println(Math.min(five,two));
    }

    private static long find5(long n) {
        long result = 0;
        while(n>=5){
            result += n/5;
            n /= 5;
        }
        return result;
    }

    private static long find2(long n) {
        long result = 0;
        while(n>=2){
            result += n/2;
            n /= 2;
        }
        return result;
    }
}
