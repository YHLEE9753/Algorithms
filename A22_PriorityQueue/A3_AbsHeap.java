package A22_PriorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A3_AbsHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2){
                        if(Math.abs(o1)>Math.abs(o2)){
                            return 1; //변경
                        }else if(Math.abs(o1) == Math.abs(o2)){
                            return o1-o2;
                        }else{
                            return -1;
                        }
                    }
        });
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
