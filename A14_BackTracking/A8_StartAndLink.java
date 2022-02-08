package A14_BackTracking;

import java.util.Scanner;

public class A8_StartAndLink {

    static int[][] ability;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ability = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                ability[i][j] = sc.nextInt();
            }
        }


    }
}
