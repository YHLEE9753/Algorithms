package A12_Sort;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    static int maxVal = 1_000_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] countingSort = countingSort(arr, n);
        Arrays.stream(countingSort).forEach(System.out::println);
    }

    private static int[] countingSort(int[] arr, int n) {
        int[] counting = new int[maxVal];
        int[] result = new int[n];

        // 1. 갯수 세기
        for (int i = 0; i < n; i++) {
            counting[arr[i]]++;
        }
        // 2. counting 배열을 누적합으로 변환
        for (int i = 1; i <= n; i++) {
            counting[i] += counting[i - 1];
        }


        // 2. 값을 비교하여 result 배열에 담아보자
        for (int i = n - 1; i >= 0; i--) {
            int number = arr[i];
            counting[number]--;
            result[counting[number]] = number;
        }
        return result;
    }
}
