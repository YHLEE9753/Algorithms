package A17_NumberTheoryAndCombinatorics;

import java.util.*;

public class A10_FashionKing {
    static int [][]dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0;i<n;i++){
            int nn = sc.nextInt();
            sc.nextLine();
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0;j<nn;j++){
                String[] line = sc.nextLine().split(" ");
                if(map.get(line[1])==null){
                    map.put(line[1], 1);
                }else{
                    map.put(line[1], map.get(line[1])+1);
                }
            }
            int result = 1;
            // 계산
            for(String key:map.keySet()){
                result *= (map.get(key)+1);
            }
            System.out.println(result-1);
        }
    }
}
