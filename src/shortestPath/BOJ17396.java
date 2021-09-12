package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17396 {
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(weight, o.weight);
		}
	}

	static int N, M;
	static ArrayList<Edge>[] map;
	static long[] dist;
	static int[] sight;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
		}

		dist = new long[N];
		sight = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		sight[N - 1] = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			long value = Long.parseLong(st.nextToken());

			if (sight[d] != 1 && sight[s] != 1) {
				map[s].add(new Edge(d, value));
				map[d].add(new Edge(s, value));
			}
		}

		dijkstra(0);

		if (dist[N - 1] == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dist[N - 1]);
		}

	}

	static void dijkstra(int start) {
		boolean[] visit = new boolean[N + 1];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		Arrays.fill(dist, Long.MAX_VALUE);
		queue.add(new Edge(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			int dest = e.to;

			if (visit[dest])
				continue;
			visit[dest] = true;

			for (Edge edge : map[dest]) {
				if (dist[edge.to] > dist[dest] + edge.weight) {
					dist[edge.to] = dist[dest] + edge.weight;
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
