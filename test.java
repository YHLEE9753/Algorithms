import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    static boolean visit [];
    static int arr [];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        visit = new boolean[N];
        arr  = new int[M];

        dfs(N,M,0);
    }

    private static void dfs(int N, int M, int depth) {
        // 깊이 도달 시 출력
        if(depth == M){
            for(int i = 0;i<M;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 깊이 도달하자 1, 2, 3, 4
        for(int i = 0;i<N;i++){
            // 쓰지 않은거면
            if(!visit[i]){
                visit[i] = true; // 중복제거를 위해
                arr[depth] = i+1;
                dfs(N,M,depth+1);
                visit[i] = false;
            }

        }

    }

}
