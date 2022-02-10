import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        System.out.println("start");
        for(int i = 0;i<=10;i++){
            // 소수가 아니면 넘어간다.

            // 2가 소수이면 2의 배수는 전부 소수가 아니다.
            for(int j = i*i;j< 10;j=j+1){
                System.out.println(j);
            }
            System.out.println();
        }
        System.out.println("end");
    }
}
