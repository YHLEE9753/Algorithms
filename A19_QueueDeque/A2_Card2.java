package A19_QueueDeque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A2_Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++){
            queue.add(i);
        }
        while(queue.size()!=1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
