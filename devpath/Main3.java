package devpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main3 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] edgeCount = new int[9];

	public static void main(String[] args) {
		for(int i =0;i<9;i++){
			graph.add(new ArrayList<>());
		}
		// 그래프 각 노드별 인접한 노드정보 초기화
		graph.get(1).add(2);
		graph.get(1).add(4);
		graph.get(2).add(5);
		graph.get(2).add(6);
		graph.get(3).add(6);
		graph.get(4).add(2);
		graph.get(4).add(8);
		graph.get(7).add(3);
		graph.get(8).add(6);

		// 진입차수 테이블 초기화
		edgeCount[2] = 2;
		edgeCount[3] = 1;
		edgeCount[4] = 1;
		edgeCount[5] = 1;
		edgeCount[6] = 3;
		edgeCount[8] = 1;



		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0;i<9;i++){
			if(edgeCount[i]==0){
				q.offer(i);
			}
		}

		while(!q.isEmpty()){
			Integer temp = q.poll();
			System.out.println(temp);
			for(Integer num : graph.get(temp)){
				edgeCount[num]--;
				if(edgeCount[num] == 0){
					q.offer(num);
				}
			}
		}
	}
}
