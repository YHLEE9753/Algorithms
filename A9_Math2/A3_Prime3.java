package A9_Math2;

import java.util.Scanner;

public class A3_Prime3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(true){
            boolean flag = false;
            for(int i = 2;i<=n;i++){
                if(n%i == 0){
                    System.out.println(i);
                    n = n/i;
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            break;

        }
    }
}
