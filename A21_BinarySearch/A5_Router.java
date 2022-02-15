package A21_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class A5_Router {
    private static int[] houses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        houses = new int[n];
        for(int i = 0;i<n;i++){
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);

        // upper
        int lo = 1;
        int hi = houses[n-1] - houses[0] + 1;
        while(lo < hi){
            int mid = (lo + hi) /2;

            if(canInstall(mid) < m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        System.out.println(lo-1);
    }

    private static int canInstall(int distance) {
        int count = 1;
        int lastLocate = houses[0];

        for(int i = 1;i<houses.length;i++){
            int locate = houses[i];
            if(locate-lastLocate >= distance){
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
