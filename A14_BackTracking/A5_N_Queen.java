package A14_BackTracking;

import java.util.Scanner;

public class A5_N_Queen {
    // 총 N 개 이므로 각 열당 1개씩만 놓을 수 있다.
    // 따라서 arr 에서 index 를 열, value 를 행으로 정할 수 있다.
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
        // 8 번 다 채워지면 이상 없는것
        if(depth == N){
            count++;
            return;
        }

        // 각 열을 첫 행부터 마지막 행까지 놓아보고 Possibility 로 체크를 한다.
        // 그 후 놓을 수 있는 위치이면 다음 열로 이동한다.
        for(int i =0;i<N;i++){
            arr[depth] = i;
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    private static boolean Possibility(int col) {
        for(int i = 0;i<col;i++){
            // 같은 행에 존재할 경우
            if(arr[col] == arr[i]){
                return false;
                // 대각 선에 위치하는 경우
            }else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
