package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ10217 {

	static class Point implements Comparable<Point> {
		int to;
		int weight;
		int time;

		public Point(int to, int weight, int time) {
			this.to = to;
			this.weight = weight;
			this.time = time;
		}

		public int compareTo(Point o) {
			if (this.time < o.time) {
				return -1;
			} else if (this.time == o.time) {
				if (this.weight < o.weight) {
					return -1;
				}

				return 0;
			}
			return 1;
		}
	}

	static int t;
	static int n, m, k;
	static ArrayList<Point>[] list;
	static int[][] dp;
	static final int INF = Integer.MAX_VALUE / 2;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			dp = new int[n + 1][m + 1];
			list = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
				Arrays.fill(dp[i], INF);
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				list[u].add(new Point(v, c, d));
			}

			pro(1);

			int min = INF;
			for (int i = 0; i <= m; i++) {
				min = Math.min(min, dp[n][i]);
			}

			if (min == INF) {
				System.out.println("Poor KCM");
			} else {
				System.out.println(min);
			}
		}
	}

	static void pro(int start) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(start, 0, 0));
		dp[start][0] = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int nowAirport = p.to;
			int nowMoney = p.weight;
			int nowTime = p.time;

			if (nowAirport == n) {
				break;
			}

			for (Point next : list[nowAirport]) {
				int nextNum = next.to;
				int nextMoney = next.weight + nowMoney;
				int nextTime = next.time + nowTime;

				if (nextMoney > m) {
					continue;
				}

				if (dp[nextNum][nextMoney] <= nextTime) {
					continue;
				}

				for (int i = nextMoney; i <= m; i++) {
					if (dp[nextNum][i] > nextTime) {
						dp[nextNum][i] = nextTime;
					}
				}

				dp[nextNum][nextMoney] = nextTime;
				queue.add(new Point(nextNum, nextMoney, nextTime));
			}

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
