package A20_Division;

import java.util.Scanner;
import java.util.Stack;

public class A9_HistogramStack {
    static int[]arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getArea(n));
        }
    }

    private static long getArea(int len) {
        Stack<Integer> stack = new Stack<Integer>();

        long maxArea = 0;

        for(int i = 0;i<len;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int height = arr[stack.pop()];
                long width = stack.isEmpty() ? i: i-1-stack.peek();
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = arr[stack.pop()];

            long width = stack.isEmpty() ? len: len-1 -stack.pop();
            maxArea = Math.max(maxArea, width * height);
        }
        return maxArea;
    }

}
