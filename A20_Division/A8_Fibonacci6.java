package A20_Division;
import java.util.Scanner;

public class A8_Fibonacci6 {
    static long mod = 1_000_000_007;
    static long[][] start = {{1, 1}, {1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[][] A = {{1, 1} , {1, 0}};
        if(n==0){
            System.out.println(0);
        }else if(n==1){
            System.out.println(1);
        }else{
            long [][]result = dfs(A,(n-1));
            System.out.println(result[0][0]);
        }
    }

    private static long[][] dfs(long[][] mat, long n) {
        if(n==1){
            return start;
        }

        long[][] temp = dfs(mat,n/2);
        if(n%2==1){
            return simple_mul(simple_mul(temp,temp),start);
        }else{
            return simple_mul(temp,temp);
        }
    }

    // 다른 매트릭스간의 곱
    private static long[][] simple_mul(long[][] matrix1, long[][] matrix2){
        int size = matrix1.length;
        long [][] result = new long[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                long resultVal = 0;
                for(int k = 0;k<size;k++)
                    resultVal += matrix1[i][k]*matrix2[k][j];
                result[i][j] = resultVal%mod;
            }
        }
        return result;
    }
}
