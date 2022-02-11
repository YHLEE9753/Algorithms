package A19_QueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class A5_Deque {
    static LinkedList<Integer> arr;
    static int frontPoint = 0;
    static int endPoint = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        arr = new LinkedList<>();
        for(int i = 0;i<n;i++){
            String[] line = br.readLine().split(" ");
            switch (line[0]){
                case "push_front":push_front(Integer.valueOf(line[1]));break;
                case "push_back":push_back(Integer.valueOf(line[1]));break;
                case "pop_front":pop_front();break;
                case "pop_back":pop_back();break;
                case "size":size();break;
                case "empty":empty();break;
                case "front":front();break;
                case "back":back();break;
            }
        }
        System.out.println(sb);
    }

    private static void push_front(Integer valueOf) {
        arr.addFirst(valueOf);
    }

    private static void push_back(Integer valueOf) {
        arr.add(valueOf);
    }

    private static void pop_front() {
        if(!arr.isEmpty()){
            System.out.println(arr.getFirst());
            arr.removeFirst();
        }else{
            System.out.println(-1);
        }
    }

    private static void pop_back() {
        if(!arr.isEmpty()){
            System.out.println(arr.getLast());
            arr.removeLast();
        }else{
            System.out.println(-1);
        }
    }

    private static void size() {
        System.out.println(arr.size());
    }

    private static void empty() {
        if(arr.isEmpty()) System.out.println(1);
        else System.out.println(0);
    }

    private static void front() {
        if(arr.isEmpty()) System.out.println(-1);
        else System.out.println(arr.getFirst());
    }

    private static void back() {
        if(arr.isEmpty()) System.out.println(-1);
        else System.out.println(arr.getLast());
    }

}
