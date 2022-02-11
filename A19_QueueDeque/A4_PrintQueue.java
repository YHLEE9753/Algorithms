package A19_QueueDeque;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A4_PrintQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int number = sc.nextInt();
            int wonder = sc.nextInt();

            Queue<Document> queue = new LinkedList<>();
            for(int j = 0; j<number;j++){
                queue.add(new Document(j, sc.nextInt()));
            }

            int result = 1;
            //
            while(!queue.isEmpty()){
                Document currentDoc = queue.poll(); // 가장 앞에 있는 문서를 꺼낸다.
                boolean check = true; // 자신보다 큰 우선순위가 존재하는 지 확인
                Iterator iter = queue.iterator();
                while(iter.hasNext()){
                    Document document = (Document) iter.next();
                    if(currentDoc.pri < document.pri){
                        check = false;
                        break;
                    }
                }

                // 자신보다 큰 우선 순위가 존재하면
                if(!check){
                    queue.add(currentDoc);
                }else{
                    if(wonder == currentDoc.index){// 자신이 가장 큰 우선 순위면면
                        System.out.println(result);
                    }else{
                        result++;
                    }
                }
           }
        }
    }

    static class Document{
        int index;
        int pri;

        public Document(int index, int pri) {
            this.index = index;
            this.pri = pri;
        }
    }
}
