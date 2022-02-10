package A17_NumberTheoryAndCombinatorics;

import java.util.*;


public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i =0;i<=arr[0];i++){
            int gcd = gcd((arr[0]-i),(arr[1]-i));
            if(gcd != 1){
                boolean flag = true;
                for(int a:arr){
                    if((a-i)%gcd!=0){
                        flag = false;
                    }
                }
                if(flag) set.add(gcd);
            }
        }
        Iterator iter = set.iterator();
        int[] result = new int[set.size()];
        int index = 0;
        while(iter.hasNext()){
            result[index++] = (int)iter.next();
        }
        Arrays.sort(result);
        for(int i : result){
            System.out.print(i+" ");
        }

    }
    static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}