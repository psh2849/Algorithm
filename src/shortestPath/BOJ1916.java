/*
 * 1916. 최소비용 구하기
 */
package shortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge {
	int to, weight;

	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

class Info {
	int idx, dist;

	public Info(int idx, int dist) {
		this.idx = idx;
		this.dist = dist;
	}
}

public class BOJ1916 {

	static int N, M, start, dest;
	static ArrayList<Edge>[] edge;
	static int[] dist;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		dist = new int[N + 1];
		edge = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			edge[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int cost = sc.nextInt();

			edge[x].add(new Edge(y, cost));

		}
		start = sc.nextInt();
		dest = sc.nextInt();
	}

	static void pro() {
		PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

		for (int i = 1; i <= N; i++) {
			if (i == start) {
				dist[i] = 0;
			} else {
				dist[i] = Integer.MAX_VALUE;
			}
		}

		pq.add(new Info(start, 0));

		while (!pq.isEmpty()) {
			Info info = pq.poll();

			if (dist[info.idx] < info.dist)
				continue;

			for (Edge edge : edge[info.idx]) {
				if (edge.weight + dist[info.idx] < dist[edge.to]) {
					dist[edge.to] = edge.weight + dist[info.idx];
					pq.add(new Info(edge.to, dist[edge.to]));
				}
			}
		}

		System.out.println(dist[dest]);
	}

	public static void main(String[] args) {
		input();
		pro();
	}
}
