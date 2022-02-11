package A18_Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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
    }
}
