package A11_BruteForce;

import java.util.Scanner;

public class A5_MovieDriector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int count = 0;
        String check = "666";
        for(int i = 1;i<1000000000;i++){
            String str = String.valueOf(i);
            if(str.contains(check)){
                count++;
            }
            if(count == n){
                System.out.println(i);
                break;
            }
        }
    }
}
