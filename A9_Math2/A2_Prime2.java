package A9_Math2;

import java.util.Scanner;

public class A2_Prime2 {
    static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        make_prime(m);

        int result = 0;
        int index = 0;
        int first = 0;
        for(int i = n;i<=m;i++){
            if(!isPrime[i]) {
                result+=i;
                index++;
            }
            if(index == 1) {
                first = i;
                index++;
            }
        }
        if(result==0){
            System.out.println(-1);
        }else{
            System.out.println(result);
            System.out.println(first);
        }

    }

    private static void make_prime(int num) {
        isPrime = new boolean[num + 1];
        isPrime[0] = isPrime[1] = true; //true 는 소수가 아니다.

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j = j+i) {
                isPrime[j] = true;
            }
        }
    }
}
