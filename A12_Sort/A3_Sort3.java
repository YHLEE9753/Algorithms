package A12_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A3_Sort3 {
    static int maxVal = 10_001;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        countingSort(arr, n);

    }

    private static void countingSort(int[] arr, int n) {
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

        for(int i = 0; i<result.length;i++){
            sb.append(result[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
