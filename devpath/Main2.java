package devpath;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main2 {
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] result;

	public int solution(int N, int[][] fees, int dest) {
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}
		result = new int[N + 1];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			int node1 = fees[i][0];
			int node2 = fees[i][1];
			int cost = fees[i][2];
			graph.get(node1).add(new Node(node2, cost));
			graph.get(node2).add(new Node(node1, cost));
		}

		dijstrak(1);

		return -1;
	}

	private void dijstrak(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		result[start] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int index = node.index;
			int distance = node.distance;

			if (distance > result[index]) {
				continue;
			}
			for (Node linkedNode : graph.get(index)) {
				if (distance + linkedNode.distance < result[linkedNode.index]){
					result[linkedNode.index] = distance + linkedNode.distance;
					pq.offer(new Node(linkedNode.index, result[linkedNode.index]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int index;
		int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}
