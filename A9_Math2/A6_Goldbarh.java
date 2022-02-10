package A9_Math2;

import java.util.Scanner;

public class A6_Goldbarh {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        make_prime(10000);
        for(int i=0;i<n;i++){
            int number = sc.nextInt();
            for(int j = number/2;j< prime.length;j++){
                boolean flag = false;
                for(int k = j;k>0;k--){
                    if(prime[j]==false && prime[k]==false && (j+k) == number){
                        System.out.println(k+" "+j);
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
        }
    }

    private static void make_prime(int num) {
        prime = new boolean[num+1];
        prime[0] = prime[1] = true;
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(prime[i]==true)continue;
            for(int j = i*i;j<prime.length;j=j+i){
                prime[j] = true;
            }
        }
    }
}
