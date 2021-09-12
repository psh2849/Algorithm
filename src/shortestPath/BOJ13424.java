package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13424 {
	static class Point implements Comparable<Point> {
		int to;
		int weight;

		public Point(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Point>[] map;
	static int T, N, M, K;
	static int[] dist, save_dist;

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		save_dist = new int[N + 1];
		dist = new int[N + 1];
		map = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			map[s].add(new Point(d, value));
			map[d].add(new Point(s, value));
		}

		ArrayList<Integer> loc = new ArrayList<>();

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int s = Integer.parseInt(st.nextToken());
			loc.add(s);
		}

		for (int i = 0; i < loc.size(); i++) {
			dijkstra(loc.get(i));
			for (int j = 1; j < dist.length; j++) {
				save_dist[j] += dist[j];
			}
		}
		
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for(int i = 1; i < save_dist.length; i++) {
			if(min > save_dist[i]) {
				min = save_dist[i];
				idx = i;
			}
		}
		
		System.out.println(idx);
	}

	static void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(start, 0));
		dist[start] = 0;
		boolean[] visit = new boolean[N + 1];

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int dest = p.to;

			if (visit[dest])
				continue;
			visit[dest] = true;

			for (Point edge : map[dest]) {
				if (dist[edge.to] > dist[dest] + edge.weight) {
					dist[edge.to] = dist[dest] + edge.weight;
					queue.add(new Point(edge.to, dist[edge.to]));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			input();
		}

	}

}
