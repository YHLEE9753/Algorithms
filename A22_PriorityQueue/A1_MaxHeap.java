package A22_PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A1_MaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            if(num==0 && pq.isEmpty()){
                System.out.println(0);
            }else if(num==0 && !pq.isEmpty()){
                System.out.println(pq.poll());
            }else{
                pq.add(num);
            }
        }

    }
}
