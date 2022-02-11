package A18_Stack;

import java.util.Arrays;
import java.util.Scanner;

public class A6_BigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int [] result = new int[n];
        for(int i = 0;i<n;i++){
            boolean flag = true;
            for(int j = i+1;j<n;j++){
                if((arr[j] > arr[i]) && flag){
                    result[i] = arr[j];
                    flag = false;
                }
            }
            if(result[i] == 0) result[i] = -1;
        }

        for(int i = 0;i<n;i++){
            System.out.print(result[i]+" ");
        }
    }
}
