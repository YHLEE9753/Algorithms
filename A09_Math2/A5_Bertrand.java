package A09_Math2;

import java.util.Scanner;

public class A5_Bertrand {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        make_prime(123456*2+1);

        while(true){
            int num = sc.nextInt();
            if(num == 0) break;

            int result = 0;
            for(int i = num+1;i<=num*2;i++){
                if(prime[i]==false)result++;
            }
            System.out.println(result);
        }
    }

    private static void make_prime(int n) {
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;
        for(int i = 2;i<Math.sqrt(n);i++){
            if(prime[i] == true)continue;
            for(int j = i*i;j< prime.length;j=j+i){
                prime[j] = true;
            }
        }
    }
}
