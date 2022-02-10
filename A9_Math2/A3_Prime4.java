package A9_Math2;

import java.util.Scanner;

public class A3_Prime4 {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        make_prime(m);
        for(int i = n;i<=m;i++){
            if(!prime[i]) System.out.println(i);
        }
    }

    private static void make_prime(int num) {
        prime = new boolean[num+1];
        prime[0] = prime[1] = true;

        for(int i = 2;i<=Math.sqrt(num);i++){
            if(prime[i] ==  true) continue;
            for(int j = i*i;j<prime.length;j=j+i){
                prime[j] = true;
            }
        }
    }
}
