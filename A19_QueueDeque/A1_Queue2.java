package A19_QueueDeque;

import java.io.*;


public class A1_Queue2 {
    static int[] arr;
    static int frontPoint = 0;
    static int endPoint = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        arr = new int[n+1];
        for(int i = 0;i<n;i++){
            String[] line = br.readLine().split(" ");
            switch (line[0]){
                case "push":push(Integer.valueOf(line[1]));break;
                case "pop":pop();break;
                case "size":size();break;
                case "empty":empty();break;
                case "front":front();break;
                case "back":back();break;
            }
        }
        System.out.println(sb);
    }

    private static void empty() {
        if(frontPoint==endPoint) sb.append("1"+"\n");
        else sb.append("0"+"\n");
    }


    private static void push(int n) {
        arr[endPoint++] = n;
    }
    private static void pop() {
        if(frontPoint == endPoint){
            sb.append("-1"+"\n");
        }else{
            sb.append(arr[frontPoint++]+"\n");
        }
    }
    private static void size() {
        sb.append(endPoint-frontPoint+"\n");
    }
    private static void front() {
        if(frontPoint==endPoint){
            sb.append("-1"+"\n");
        }else{
            sb.append(arr[frontPoint]+"\n");
        }
    }
    private static void back() {
        if(frontPoint==endPoint){
            sb.append("-1"+"\n");
        }else{
            sb.append(arr[endPoint-1]+"\n");
        }
    }


}
