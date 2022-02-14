package A21_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class A3_LanCable {
    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long b = sc.nextLong();
        arr = new long[(int)k];

        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
            max = Math.max(max, arr[i]);
        }
        System.out.println(upper(max, b)-1);
    }

    private static long upper(long max, long key) {
        long start = 0;
        long end = max+1;

        while(start<end){
            long mid = (start+end)/2;
            long midNumber = calMidNum(mid);
            if(midNumber < key){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    private static long calMidNum(long mid) {
        long result = 0;
        for(int i = 0;i<arr.length;i++){
            result += arr[i]/mid;
        }
        return result;
    }

}

