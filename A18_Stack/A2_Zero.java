package A18_Stack;

import java.util.Scanner;
import java.util.Stack;

public class A2_Zero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int result = 0;
        for(int i:stack){
            result+=i;
        }
        System.out.println(result);
    }
}
