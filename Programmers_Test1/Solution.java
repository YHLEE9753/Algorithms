package Programmers_Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(6, new int[]{7,10});
		System.out.println("!");
	}
	public long solution(int n, int[] times) {
		int interviews = times.length;
		Arrays.sort(times);
		int maxTime = times[interviews - 1];
		long number = n * maxTime / interviews;

		ArrayList<Long> list = new ArrayList<>();
		for (int i = 0; i < interviews; i++) {
			Long time = (long)times[i];
			for (Long j = time; j < number; j += time) {
				list.add(j);
			}
		}
		Collections.sort(list);

		return list.get(n-1);
	}
}