package A20_Division;

import java.util.Scanner;

public class A9_Histogram {
    static int[]arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;

            arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(solution(0,n-1));
        }

    }

    private static long solution(int start, int end) {
        if(start == end){
            return arr[start];
        }
        int mid = (start + end)/2;

        long resultLeft = solution(start, mid);
        long resultRight = solution(mid+1,end);
        long result = Math.max(resultLeft,resultRight);

        result = Math.max(result, getMidArea(start,end,mid));
        return result;
    }

    private static long getMidArea(int start, int end, int mid) {
        int toLeft = mid;
        int toRight = mid;
        long height = arr[mid];
        long result = height;

        while(start<toLeft && toRight<end){
            if(arr[toLeft-1]<arr[toRight+1]){
                toRight++;
                height = Math.min(height, arr[toRight]);
            }else{
                toLeft--;
                height = Math.min(height, arr[toLeft]);
            }
            // 최대 넓이 갱신
            result = Math.max(result, height * (toRight-toLeft+1));
        }

        // 오른쪽 구간을 끝까지 탐색 못했다면
        while(toRight < end){
            toRight++;
            height = Math.min(height, arr[toRight]);
            result = Math.max(result, height * (toRight-toLeft+1));
        }
        // 왼쪽 구간을 끝까지 탐색 못했다면
        while(start < toLeft){
            toLeft--;
            height = Math.min(height, arr[toLeft]);
            result = Math.max(result, height * (toRight-toLeft+1));
        }
        return result;
    }

}
