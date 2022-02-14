package A21_BinarySearch;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1_FindNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr); // 정렬 꼭

        int m = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int key = Integer.valueOf(st.nextToken());
            //// method 1
//            int result = binarySearch1(arr, key);
//            if (result < 0) {
//                sb.append(0 + "\n");
//            } else {
//                sb.append(1 + "\n");
//            }
            //// method 2
            int result = binarySearch2(arr, key);
            if (result < 0) {
                sb.append(0 + "\n");
            } else {
                sb.append(1 + "\n");
            }
        }
        System.out.println(sb);
    }

    private static int binarySearch1(int[] arr, int key) {
        return Arrays.binarySearch(arr, key);
    }

    private static int binarySearch2(int[] arr, int key) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start+end)/2;
            if(key < arr[mid]){
                end = mid-1;
            }else if(key > arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        // 찾고자 하는 값이 존재하지 않을 경우
       return -1;
    }

}
