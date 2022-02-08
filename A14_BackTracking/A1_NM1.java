package A14_BackTracking;

import java.util.Scanner;
import java.util.StringTokenizer;

public class A1_NM1 {

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        arr = new int[M]; // 값을 담을 배열
        visit = new boolean[N]; // 방문한 노드인지 체크
        dfs(N,M,0);

        System.out.println(sb);
    }
    public static void dfs(int N, int M, int depth){
        // 깊이 도달 시 출력
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 깊이 도달하자 1, 2, 3, 4
        for(int i = 0;i< N;i++){
            // 쓰지 않은거면
            if(!visit[i]){
                visit[i] = true;// 중복제거를 위해
                arr[depth] = i + 1;
                dfs(N,M,depth+1);
                visit[i] = false;
            }
        }
    }

}
