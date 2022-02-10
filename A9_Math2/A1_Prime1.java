package A9_Math2;

import java.util.Scanner;

public class A1_Prime1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = 0;i<n;i++){
            int m = sc.nextInt();

            boolean isPrime = true; // 소수 : true
            if(m==1) {
                isPrime = false;
            }
            else{
                for(int j=2;j<=Math.sqrt(m);j++){
                    if(m%j==0){
                        isPrime = false;
                    }
                }
            }
            if(isPrime) result++;
        }
        System.out.println(result);
    }
}
