package A24_DFS_BFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A11_BipartiteGraph {
    static int v, e;
    static ArrayList<Binary>[] al;
    static boolean[] visit;
    static boolean result;
    static int[] checkList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            v = sc.nextInt(); // 정점의 개수
            e = sc.nextInt(); // 간선의 개수
            al = new ArrayList[v+1];
            visit = new boolean[v+1];
            checkList = new int[v+1];
            // 그래프 초기화
            for(int j = 1;j<=v;j++){
                al[j] = new ArrayList<>();
            }
            // 인접 리스트 초기화
            int start = 0,end = 0;
            for(int j = 0;j<e;j++){
                start = sc.nextInt();
                end = sc.nextInt();
                al[start].add(new Binary(end, 0));
                al[end].add(new Binary(start, 0));
            }
            bfs(start);
            bfsCheck();
            if(result){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }

    private static void bfsCheck() {
        for(int  i = 1;i<al.length;i++){
            ArrayList<Binary> checkAl = al[i];
            int originalCheck = checkList[i];
            for(int j = 0;j<checkAl.size();j++){
                if(originalCheck == checkList[checkAl.get(j).getNumber()]){
                    result = true;
                    return;
                }
            }
        }
    }


    private static void bfs(int start) {
        Queue<Binary> q = new LinkedList<>();
        q.add(new Binary(start, 1));
        checkList[start] = 1;
        visit[start] = true;

        while(!q.isEmpty()){
            Binary temp = q.poll();
            int originalCheck = temp.getCheck();

            for(int i = 0;i<al[temp.getNumber()].size();i++){
                Binary binary = al[temp.getNumber()].get(i);
                int number = binary.getNumber();

                // 방문하지 않은경우 이분으로 처리
                if(!visit[number]){
                    if(originalCheck == 1){
                        q.add(new Binary(number,2));
                        visit[number] = true;
                        checkList[number] = 2;
                    }else if(originalCheck == 2){
                        q.add(new Binary(number,1));
                        visit[number] = true;
                        checkList[number] = 1;
                    }
                }
            }
        }
    }
}

class Binary{
    private int number;
    private int check; // 초기화 0 -> 1, 2반복

    public Binary(int number, int check) {
        this.number = number;
        this.check = check;
    }

    public int getNumber() {
        return number;
    }

    public int getCheck() {
        return check;
    }
}