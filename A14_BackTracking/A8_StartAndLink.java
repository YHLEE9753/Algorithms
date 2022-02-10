package A14_BackTracking;

import java.util.Scanner;

public class A8_StartAndLink {

    static int[][] ability;
    static int n;
    static boolean[] visit;

    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];
        visit = new boolean[n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                ability[i][j] = sc.nextInt();
            }
        }

        combi(0,0);
    }
    private static void combi(int idx, int count){
        if(count == n/2){
            diff();
            return;
        }
        for(int i = idx;i<n;i++){
            if(!visit[i]){
                visit[i] = true;
                combi(i+1, count+1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
                if (visit[i] == true && visit[j] == true) {
                    team_start += ability[i][j];
                    team_start += ability[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
                else if (visit[i] == false && visit[j] == false) {
                    team_link += ability[i][j];
                    team_link += ability[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        int val = Math.abs(team_start - team_link);

        /*
         * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
         * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
         */
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        Min = Math.min(val, Min);


    }
}
