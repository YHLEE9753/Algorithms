package Other;

import java.util.Scanner;

public class A2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(b+c>=60){
            int aPlus = (b+c)/60;
            int bPlus = (b+c)%60;
            a = a+aPlus;
            b = bPlus;
        }else{
            b = b+c;
        }
        if(a>=24){
            a = a-24;
        }
        System.out.println(a+" "+b);
    }
}
