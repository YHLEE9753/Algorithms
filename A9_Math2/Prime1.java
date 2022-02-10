package A9_Math2;

import java.util.Scanner;

public class Prime1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 0 ~ N 까지 수 중 소수를 구하는 반복문
        for(int i = 0; i <= n; i++) {
            make_prime(i);
        }
    }

    private static void make_prime(int num) {
        // 2보다 작으면 소수가 아니다.
        if(num < 2){
            return;
        }
        // 2 이면 소수이다
        if(num == 2){
            System.out.println(num);
            return;
        }
        // 2 보다 큰 경우 2 부터 그 숫자까지 전부 나머지를 구해본다.
        for(int i =2;i<=Math.sqrt(num);i++){
            if(num % i == 0){
                return;
            }
        }
        // 이 모든 경우가 아니면 소수이다.
        System.out.println(num);
        return;
    }
}
