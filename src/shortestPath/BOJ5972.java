package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ5972 {

	static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}

	static int N, M;
	static ArrayList<Edge>[] adj;
	static boolean[] visit;
	static int[] dist;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		visit = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adj[x].add(new Edge(y, cost));
			adj[y].add(new Edge(x, cost));
		}

		dijkstra(1);
		
		sb.append(dist[N] + "\n");
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(start, 0));
		dist[start] = 0;
		
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			int cur = e.to;
			
			if (visit[cur])
				continue;
			visit[cur] = true;

			for (Edge edge : adj[cur]) {
				if (dist[edge.to] > dist[cur] + edge.weight) {
					dist[edge.to] = dist[cur] + edge.weight;
					queue.add(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();

	}

}
