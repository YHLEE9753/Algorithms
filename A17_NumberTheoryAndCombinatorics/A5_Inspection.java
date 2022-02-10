package A17_NumberTheoryAndCombinatorics;

import java.util.*;


public class A5_Inspection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int[] arr = new int[n-1];
        int before = sc.nextInt();
        for (int i = 0; i < n-1; i++) {
            int now = sc.nextInt();
            arr[i] = Math.abs(now-before);
            before = now;
        }
        // 최대공약수
        Arrays.sort(arr);
        int gcd = arr[0];
        for(int i = 1;i<arr.length;i++){
            gcd = gcd(gcd,arr[i]);
        }
        // 최대 공약수의 약수 찾기
        for(int i = 2;i<=gcd;i++){
            if(gcd%i==0){
                System.out.print(i+" ");
            }
        }
    }
    private static int gcd(int a, int b) {
        if(b==0) return a;
        else return gcd(b , a%b);
    }
}
