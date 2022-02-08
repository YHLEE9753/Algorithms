package A11_BruteForce;

import java.util.Scanner;

public class A3_DungChi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[][] people = new int[n][2];
        // 초기화
        for (int i = 0; i < n; i++) {
            String[] scan = sc.nextLine().split(" ");
            int weight = Integer.valueOf(scan[0]);
            int height = Integer.valueOf(scan[1]);
            people[i] = new int[]{weight, height};
        }

        // 일일히 비교
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int myWeight = people[i][0];
                int myHeight = people[i][1];
                if(myWeight < people[j][0] && myHeight < people[j][1]){
                    rank+=1;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
