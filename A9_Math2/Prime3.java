package A9_Math2;

import java.util.Scanner;

public class Prime3 {

    public static boolean[] prime;    // 소수를 체크할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        make_prime(n);

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] == false) {    // 소수(false)일 경우 출력
                System.out.println(i);
            }
        }
    }

    private static void make_prime(int n) {
        prime = new boolean[n + 1];// 0 ~ n
        // false = 소수
        // true = 소수X

        // 0, 1 은 소수가 아니다.
        prime[0] = prime[1] = true;

        // 제곱까지만 검사하면 된다.
        for(int i = 0;i<=Math.sqrt(n);i++){
            // 소수가 아니면 넘어간다.
            if(prime[i] == true){
                continue;
            }

            // 2가 소수이면 2의 배수는 전부 소수가 아니다.
            for(int j = i*i;j< prime.length;j=j+i){
                System.out.println(j);
                prime[j] = true;
            }
        }

    }
}
