package Programmers_Test1;

import java.util.Arrays;

public class Solution1 {
	public static String solution(String number, int k) {
		String answer = "";
		// 1. 맨 앞자리부터 k 개까지 가장 큰수를 파악
		while (k > 1) {
			int bigIndex = 0;
			int bigValue = 0;
			for (int i = 0; i < k; i++) {
				int num = number.charAt(i) - 48;
				if (bigValue < num) {
					bigIndex = i;
					bigValue = num;
				}
			}
			answer += number.charAt(bigIndex);
			number = number.substring(bigIndex+1);
			k = k - bigIndex;
		}
		return answer + number.substring(1);
	}

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
	}
}
