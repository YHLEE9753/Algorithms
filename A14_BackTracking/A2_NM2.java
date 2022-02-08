package A14_BackTracking;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A2_NM2 {

    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        dfs(N,M,0);
        System.out.println(sb);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =0;i<N;i++){
            if(!visit[i]){
                // 이전 값과 비교 로직 추기
                if(depth > 0){
                    int before = arr[depth-1];
                    if(before > i) continue;
                }
                arr[depth] = i+1;
                visit[i] = true;
                dfs(N,M,depth+1);
                visit[i] = false;
            }
        }
    }
}
