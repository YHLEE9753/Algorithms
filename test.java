import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    static int[] arr;
    static int N;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if(Possibility(depth)){
                nQueen(depth+1);
            }

        }

    }

    private static boolean Possibility(int col) {
        for(int i = 0;i<col;i++){
            if(arr[i] == arr[col]){
                return false;
            }else if(Math.abs(arr[i]-arr[col]) == Math.abs(i-col)){
                return false;
            }
        }
        return true;
    }
}
