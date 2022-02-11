package A19_QueueDeque;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A4_PrintQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0;i<n;i++){
            LinkedList<Integer> queue = new LinkedList<>();
            String[] line = sc.nextLine().split(" ");
            int want = Integer.valueOf(line[1]);

            for(int j = 0;j<Integer.valueOf(line[0]);j++){
                queue.add(sc.nextInt());
            }
            sc.nextLine();
            want = queue.get(want);

            while(!queue.isEmpty()){


            }

        }
    }
}
