package A12_Sort;

import java.util.*;

public class A4_Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int n = sc.nextInt();
        int [] arr = new int[n];
        int sumVal = 0;
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
            sumVal += arr[i];
        }
        Arrays.sort(arr);
        for(int i = 0;i<n;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        System.out.println((int)Math.round((double)sumVal/(double)n));
        System.out.println(arr[n/2]);
        int count = 0;
        int result3 = 0;
        int doubleCount = 0;
        for(int key:map.keySet()){
            if(count<map.get(key)){
                count = map.get(key);
                result3 = key;
                doubleCount++;
            }else if(count == map.get(key) && doubleCount==1){
                result3 = key;
                doubleCount=0;
            }
        }
        System.out.println(result3);
        System.out.println(arr[n-1] - arr[0]);
    }
}
