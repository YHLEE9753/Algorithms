package A12_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] bubbleArr = bubbleSort(arr,n);
        Arrays.stream(bubbleArr).forEach(System.out::println);
    }

    private static int[] bubbleSort(int[] arr, int n) {
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

}
