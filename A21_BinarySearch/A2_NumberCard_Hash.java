package A21_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A2_NumberCard_Hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // 초기화
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(st.nextToken());
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        // 정렬
        int m = Integer.valueOf(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            int num = Integer.valueOf(st.nextToken());
            if(!map.containsKey(num)){
                sb.append(0+" ");
            }else{
                sb.append(map.get(num)+" ");
            }
        }
        System.out.println(sb);
        // 진행
    }
}
