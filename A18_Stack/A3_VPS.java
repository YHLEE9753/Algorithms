package A18_Stack;

import java.util.Scanner;
import java.util.Stack;

public class A3_VPS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++){
            String[] list = sc.nextLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j = 0;j<list.length;j++){
                if(stack.empty()){
                    stack.push(list[j]);
                }else if(stack.peek().equals("(") && list[j].equals(")")){
                    stack.pop();
                }else{
                    stack.push(list[j]);
                }
            }
            if(stack.size()==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
