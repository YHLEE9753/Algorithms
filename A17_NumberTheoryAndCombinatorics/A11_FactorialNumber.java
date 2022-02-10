package A17_NumberTheoryAndCombinatorics;

import java.util.Scanner;

public class A11_FactorialNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for(int i = 1;i<n+1;i++){
            if(i%5==0){
                int number = i;
                while(number%5==0){
                    result++;
                    number = number/5;
                }
            }
        }
        System.out.println(result);
    }
}
