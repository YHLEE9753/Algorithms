package A14_BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class AA7 {
    static int n;
    static int [] arr;
    static int [] operators;

    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }
        dfs(arr[0], 1);
        System.out.println(maxVal);
        System.out.println(minVal);

    }
    private static void dfs(int value, int depth){
        if(depth == n){
            maxVal = Math.max(maxVal, value);
            minVal = Math.min(minVal, value);
            return;
        }
        for(int i = 0;i<4;i++){
            if(operators[i]>0){
                operators[i]--;
                switch (i){
                    case 0:dfs(value + arr[depth],depth+1); break;
                    case 1:dfs(value - arr[depth],depth+1); break;
                    case 2:dfs(value * arr[depth],depth+1); break;
                    case 3:dfs(value / arr[depth],depth+1); break;
                }
                operators[i]++;
            }
        }
    }
}
