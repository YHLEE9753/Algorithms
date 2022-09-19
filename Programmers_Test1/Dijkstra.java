package Programmers_Test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	static final int INF = Integer.MAX_VALUE;
	static List<List<Node>> graph = new ArrayList<>();
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String [] info = sc.next().split(" ");
		int startIndex = sc.nextInt();

		for(int i = 0;i<Integer.parseInt(info[0])+1;i++){
			graph.add(new ArrayList<>());
		}

		result = new int[Integer.parseInt(info[0])+1];
		Arrays.fill(result, INF);


		for(int i = 0;i<Integer.parseInt(info[1]); i++){
			String[] temp = sc.next().split(" ");
			graph.get(Integer.parseInt(temp[0])).add(new Node(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
		}

		dijkstra(startIndex);
		for (int i = 1; i < result.length; i++) {
			if(result[i] == INF) {
				System.out.print("INF");
				System.out.println();
			}else {
				System.out.print(result[i]);
				System.out.println();
			}
		}
	}

	private static void dijkstra(int index) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		result[index] = 0;
		pq.offer(new Node(index,0));

		while(!pq.isEmpty()){
			Node node = pq.poll();
			int nodeIndex = node.index;
			int distance = node.distance;

			if(distance > result[nodeIndex]){
				continue;
			}
			for(Node linkedNode : graph.get(nodeIndex)){
				if(distance + linkedNode.distance < result[linkedNode.index]){
					result[linkedNode.index] = distance + linkedNode.distance;
					pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
}
