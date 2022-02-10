package A17_NumberTheoryAndCombinatorics;

import java.util.Arrays;
import java.util.Scanner;

public class A2_Divisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int [] arr = new int[a];
        for(int i = 0;i<a;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[0]*arr[a-1]);

    }
}
