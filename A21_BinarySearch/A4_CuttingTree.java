package A21_BinarySearch;

import java.util.Scanner;

public class A4_CuttingTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(); long m = sc.nextLong();
        long[] trees = new long[(int)n];
        long max = 0;
        for(int i = 0;i<n;i++){
            trees[i] = sc.nextInt();
            max = Math.max(max, trees[i]);
        }
        long result = upper(trees, m, max);
        System.out.println(result-1);
    }

    private static long upper(long[] trees, long key, long max) {
        long start = 0;
        long end = max+1;

        long myTree = 0;

        while(start<end){
            long mid = (start+end)/2;
            myTree = calculate(mid,trees);
            if(myTree<key){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    private static long calculate(long mid,long[] trees) {
        long result = 0;
        for(int i = 0;i<trees.length;i++){
            if(mid<trees[i]){
                result += (trees[i]-mid);
            }
        }
        return result;
    }
}
