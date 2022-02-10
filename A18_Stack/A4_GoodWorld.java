package A18_Stack;

import java.util.Scanner;
import java.util.Stack;

public class A4_GoodWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if(s.equals("."))break;

            Stack<Character>stack = new Stack<>();
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='[' || s.charAt(i)=='('){
                    stack.push(s.charAt(i));
                }else if(s.charAt(i)==']'){
                    if (!stack.empty()){
                        if (stack.peek() == '[') stack.pop();
                        else stack.push(s.charAt(i));
                    }else{
                        stack.push(s.charAt(i));
                    }
                }else if(s.charAt(i)==')') {
                    if (!stack.empty()){
                        if (stack.peek() == '(') stack.pop();
                        else stack.push(s.charAt(i));
                    }else{
                        stack.push(s.charAt(i));
                    }

                }
            }

            if(stack.size()==0) System.out.println("yes");
            else System.out.println("no");
        }
    }
}