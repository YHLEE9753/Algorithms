package A14_BackTracking;

import java.util.Scanner;

public class A5_N_Queen {
    static int[] arr; //index = 열, 원소값 = 행
    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if(depth == N){
            count++;
            return;
        }

        for(int i =0;i<N;i++){
            arr[depth] = i;
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    private static boolean Possibility(int col) {
        for(int i = 0;i<col;i++){
            if(arr[col] == arr[i]){
                return false;
            }else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
