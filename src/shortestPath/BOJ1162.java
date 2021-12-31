package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ1162 {
	static class Point implements Comparable<Point> {
		int to;
		int count;
		long weight;

		public Point(int to, int count, long weight) {
			this.to = to;
			this.count = count;
			this.weight = weight;
		}

		public int compareTo(Point o) {
			if (this.weight == o.weight) {
				return 0;
			} else if (this.weight > o.weight) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	static int n, m, k;
	static long MAX = Long.MAX_VALUE;
	static ArrayList<Point>[] list;
	static long[][] dp;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new long[n + 1][k + 1];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Point>();
			Arrays.fill(dp[i], MAX);
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Point(dest, 0, cost));
			list[dest].add(new Point(start, 0, cost));
		}

		dijkstra();
	}

	static void dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(1, 0, 0));
		dp[1][0] = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (dp[p.to][p.count] < p.weight)
				continue;

			for (Point e : list[p.to]) {
				if (p.count + 1 <= k && dp[e.to][p.count + 1] > p.weight) {
					dp[e.to][p.count + 1] = p.weight;
					queue.add(new Point(e.to, p.count + 1, p.weight));
				}

				if (dp[e.to][p.count] > dp[p.to][p.count] + e.weight) {
					dp[e.to][p.count] = dp[p.to][p.count] + e.weight;
					queue.add(new Point(e.to, p.count, dp[e.to][p.count]));
				}
			}
		}

		long max = MAX;
		for (int i = 0; i <= k; i++) {
			max = Math.min(dp[n][i], max);
		}

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
