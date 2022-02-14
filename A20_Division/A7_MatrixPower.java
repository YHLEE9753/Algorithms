package A20_Division;

import java.util.Scanner;


public class A7_MatrixPower {
    static long[][] matrix;
    static int size = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long b = sc.nextLong();
        size = (int)n;
        matrix = new long[size][size];
        // 초기화
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextLong();
            }
        }
        // 함수호출
        long[][] result = multiply(matrix,b);
        // 출력
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static long[][] multiply(long [][]matrix, long b) {
        if(b==1){
            return mod_function(matrix);
        }
        long[][] temp = multiply(matrix,b/2);
        if(b%2 == 1){
            return mod_function(simple_mul(matrix, mat_mul(size,mod_function(temp))));
        }else{
            return mod_function(mat_mul(size, mod_function(temp)));
        }
    }
    // 다른 매트릭스간의 곱
    private static long[][] simple_mul(long[][] matrix1, long[][] matrix2){
        int size = matrix1.length;
        long [][] result = new long[size][size];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                int resultVal = 0;
                for(int k = 0;k<size;k++)
                    resultVal += matrix1[i][k]*matrix2[k][j];
                result[i][j] = resultVal%1000;
            }
        }
        return result;
    }

    // 1000 나눈 나머지
    private static long[][] mod_function(long[][] matrix) {
        for(int i = 0;i<size;i++){
            for(int k =0;k<size;k++){
                matrix[i][k] %= 1000;
            }
        }
        return matrix;
    }

    // 매트릭스 제곱
    private static long[][] mat_mul(int n, long[][]matrix) {
        long[][] result = new long[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                long val = 0;
                for(int k = 0;k<n;k++){
                    val += matrix[i][k] * matrix[k][j];
                }
                result[i][j] = val%1000;
            }
        }
        return result;
    }
}
