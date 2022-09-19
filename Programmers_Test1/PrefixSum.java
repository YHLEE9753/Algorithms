package Programmers_Test1;

import java.util.Scanner;

public class PrefixSum {
	static int[][] memo;

	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		memo = new int[board.length + 1][board[0].length + 1];

		for (int i = 0; i < skill.length; i++) {
			int[] sk = skill[i];
			int type = sk[0];
			int r1 = sk[1];
			int c1 = sk[2];
			int r2 = sk[3];
			int c2 = sk[4];
			int degree = sk[5];

			if (type == 1) {
				memo[r1][c1] -= degree;
				memo[r1][c2 + 1] += degree;
				memo[r2 + 1][c1] += degree;
				memo[r2 + 1][c2 + 1] -= degree;
			} else if (type == 2) {
				memo[r1][c1] += degree;
				memo[r1][c2 + 1] -= degree;
				memo[r2 + 1][c1] -= degree;
				memo[r2 + 1][c2 + 1] += degree;
			}
		}
    	// 행 기준 누적합
		for(int i = 0;i<memo.length-1;i++){
			for(int j = 0;j<memo[0].length-1;j++){
				memo[i][j+1] += memo[i][j];
			}
		}
		// 열 기준 누적합
		for(int i = 0;i<memo.length-1;i++){
			for(int j = 0;j<memo[0].length-1;j++){
				memo[i+1][j] += memo[i][j];
			}
		}
		// 기존 배열과 합함

		for(int i = 0;i<board.length;i++){
			for(int j = 0;j< board[0].length;j++){
				board[i][j] += memo[i][j];
				if(board[i][j]>0){
					answer+=1;
				}
			}
		}

		return answer;
	}
}
