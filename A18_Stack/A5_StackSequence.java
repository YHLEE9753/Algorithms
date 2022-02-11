package A18_Stack;

import java.io.*;
import java.util.*;

public class A5_StackSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        List<Character> results = new ArrayList<>();


        int count = 1;
        boolean isAble = true;

        for (int i = 0; i < N; i++) {
            int n = numbers[i];

            if (isAble) {
                while (count <= n) {
                    stack.add(count++);
                    results.add('+');
                }

                if (stack.empty()) {
                    isAble = false;
                } else {
                    while (!stack.empty() && stack.peek() >= n) {
                        stack.pop();
                        results.add('-');
                    }
                }
            }
        }

        if (isAble) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        } else {
            System.out.println("NO");
        }
    }
}