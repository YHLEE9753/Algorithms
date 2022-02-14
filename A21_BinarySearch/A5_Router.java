package A21_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class A5_Router {
    private static int[] houses;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int c = sc.nextInt();
        houses = new int[n];
        for(int i = 0;i<n;i++){
            houses[i] = sc.nextInt();
        }
        Arrays.sort(houses);


    }
}
