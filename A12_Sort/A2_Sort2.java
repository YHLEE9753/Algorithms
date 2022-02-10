package A12_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class A2_Sort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
