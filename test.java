import java.util.*;

public class test {
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }

    private static void dfs(int N, int M, int depth) {
        if(depth == M){
            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        for(int i = 0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;


            }
        }
    }
}
