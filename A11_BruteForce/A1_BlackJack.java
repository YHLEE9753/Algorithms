package A11_BruteForce;

import java.util.Scanner;

public class A1_BlackJack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] list = sc.nextLine().split(" ");
        String [] cards = sc.nextLine().split(" ");
        int N = Integer.valueOf(list[0]);
        int M = Integer.valueOf(list[1]);

        int result = 0;
        for(int i = 0;i<cards.length;i++){
            for(int j = i+1;j< cards.length;j++){
                for(int k = j+1;k< cards.length;k++){
                    int newValue = Integer.valueOf(cards[i]) + Integer.valueOf(cards[j]) + Integer.valueOf(cards[k]);
//                    System.out.println(newValue);
                    result = check(result,newValue,M);
                }
            }
        }
        System.out.println(result);
    }

    public static int check(int result, int newValue, int goal){
        int original = goal - result;
        int newVal = goal-newValue;
        if(newVal<0) return result;
        return original < newVal ? result : newValue;
    }
}
