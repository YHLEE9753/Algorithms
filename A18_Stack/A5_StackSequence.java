package A18_Stack;

import java.util.Scanner;
import java.util.Stack;

public class A5_StackSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int index = 1;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            while(true){
                if(num>index){
                    System.out.println("+");
                    stack.push(index);
                    index++;
                }else if(num<index){
                    System.out.println("-");
                    stack.pop();
                    index--;
                }else{
                    System.out.println("+");
                    stack.push(index);
                    System.out.println("-");
                    index--;
                    stack.pop();
                    break;
                }
            }


        }
    }
}
