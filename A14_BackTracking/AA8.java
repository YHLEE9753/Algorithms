package A14_BackTracking;

import java.util.Scanner;

public class AA8 {
    static boolean [] visit;
    static int[][] score;
    static int minVal = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n];
        score = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                score[i][j] = sc.nextInt();
            }
        }


        dfs(0,0); // n 개중 m 개를 뽑는다. depth 가 m 이 되면 종료한다.
        System.out.println(minVal);
    }

    private static void dfs(int index, int depth) {
        if(depth == n/2){
            minVal = minVal>diff(n)?diff(n):minVal;
        }

        for(int i = index;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i+1,depth+1);
                visit[i] = false;
            }
        }
    }

    private static int diff(int n) {
        int arr1Score = 0;
        int arr2Score = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(visit[i] == true  && visit[j] == true){
                    arr1Score += score[i][j];
                    arr1Score += score[j][i];
                }else if(visit[i] == false  && visit[j] == false){
                    arr2Score += score[i][j];
                    arr2Score += score[j][i];
                }
            }
        }
        return Math.abs(arr1Score-arr2Score);
    }
}
