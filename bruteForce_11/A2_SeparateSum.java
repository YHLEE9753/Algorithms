package bruteForce_11;

import java.util.Scanner;

public class A2_SeparateSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result;
        int final_result = 0;
        for(int i = 1;i<n;i++){
            result = i;
            int count = i;
            while(count != 0){
                result += (count - (count/10)*10);
                count = count/10;
            }

            if(result == n) {
                final_result = i;
                break;
            }
        }
        System.out.println(final_result);

    }
}
