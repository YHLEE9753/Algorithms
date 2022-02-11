package A19_QueueDeque;

import java.util.*;

public class A7_AC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNumber = Integer.valueOf(sc.nextLine());
        StringBuilder sb;
        LinkedList<String> list2;
        StringTokenizer st;

        for(int i = 0;i<caseNumber;i++){
            // 초기화
            sb = new StringBuilder();
            String[] p_arr = sc.nextLine().split("");
            int n = Integer.valueOf(sc.nextLine());
            st = new StringTokenizer(sc.nextLine(),"[],");
            list2 = new LinkedList<>();

            while(st.hasMoreTokens()){
                list2.add(st.nextToken());
            }

            // 비즈니스 로직
            boolean flag = true;
            boolean right = true;
            for(int j = 0;j<p_arr.length;j++){
                String StringP = p_arr[j];

                if(StringP.equals("R")){
                    right = !right;
                    continue;

                }else if(StringP.equals("D")){
                    if(list2.size()==0){
                        flag = false;
                        break;
                    }else if(right){
                        list2.pollFirst();
                    }else if(!right){
                        list2.pollLast();
                    }
                }
            }
            // 마지막 체크

            // 출력
            if(flag){
                sb.append("[");

                if(right){
                    while(list2.size()!=1){
                        sb.append(list2.pollFirst());
                        sb.append(",");
                    }
                    sb.append(list2.pollFirst());
                }else{
                    while(list2.size()!=1){
                        sb.append(list2.pollLast());
                        sb.append(",");
                    }
                    sb.append(list2.pollLast());
                }

                sb.append("]");
                System.out.println(sb);
            }else{
                System.out.println("error");
            }
        }
    }
}
