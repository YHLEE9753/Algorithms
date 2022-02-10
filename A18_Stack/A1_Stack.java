package A18_Stack;

import java.io.*;
import java.util.Scanner;

public class A1_Stack {
    static int point = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[100001];
        for(int i = 0;i<n;i++){
            String[] line = br.readLine().split(" ");
            switch (line[0]){
                case("push"):push(stack,Integer.valueOf(line[1]));break;
                case("pop"):pop(stack);break;
                case("size"):size(stack);break;
                case("empty"):empty(stack);break;
                case("top"):top(stack);break;
            }
        }
    }

    private static void pop(int[] stack) {
        if(point == 0) System.out.println("-1");
        else {
            System.out.println(stack[point-1]);
            point--;
        }
    }

    private static void push(int[] stack, int number) {
        stack[point++] = number;
    }

    private static void size(int[] stack) {
        System.out.println(point);
    }

    private static void empty(int[] stack) {
        if(point==0) System.out.println("1");
        else {
            System.out.println("0");
        }
    }

    private static void top(int[] stack) {
        if(point == 0) System.out.println("-1");
        else System.out.println(stack[point-1]);
    }
}
