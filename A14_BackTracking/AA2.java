package A14_BackTracking;

import java.util.Scanner;

public class AA2 {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0, 0);
    }

    private static void dfs(int N, int M, int depth, int before) {
        if(depth == M){
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 0;i<N;i++){
            if(!visit[i] && i+1>before){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(N,M,depth+1, i+1);
                visit[i] = false;
            }
        }
    }
}