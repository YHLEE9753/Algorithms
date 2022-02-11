package A19_QueueDeque;

import java.util.LinkedList;
import java.util.Scanner;

public class A6_RollingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> deque = new LinkedList<>();
        int[] seq = new int[m];
        // 초기화
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        for(int i = 0;i<m;i++){
            seq[i] = sc.nextInt();
        }

        // 비즈니스 로직
        int count = 0;	// 2, 3번 연산 횟수 누적 합 변수
        for (int i = 0; i < m; i++) {
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if(deque.size()%2==0){
                half_idx = deque.size()/2 -1;
            }else{
                half_idx = deque.size()/2;
            }

            // 비교
            if(target_idx <= half_idx){
                for(int j = 0;j<target_idx;j++){
                    int temp = deque.pollFirst();
                    deque.addLast(temp);
                    count++;
                }
            }else {
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
