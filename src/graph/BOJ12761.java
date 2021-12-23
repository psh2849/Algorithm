package graph;

import java.util.*;
import java.io.*;

public class BOJ12761 {

	static class Point {
		int x;
		int time;

		public Point(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	static int[] arr = new int[100001];
	static int a, b, n, m;
	static final int INF = 100001;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pro();
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visit = new boolean[INF];

		queue.add(new Point(n, 0));
		visit[n] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == m) {
				System.out.println(p.time);
				return;
			}

			if (p.x + a < INF && !visit[p.x + a]) {
				visit[p.x + a] = true;
				queue.add(new Point(p.x + a, p.time + 1));
			}
			if (p.x + b < INF && !visit[p.x + b]) {
				visit[p.x + b] = true;
				queue.add(new Point(p.x + b, p.time + 1));
			}
			if (p.x * a < INF && !visit[p.x * a]) {
				visit[p.x * a] = true;
				queue.add(new Point(p.x * a, p.time + 1));
			}
			if (p.x * b < INF && !visit[p.x * b]) {
				visit[p.x * b] = true;
				queue.add(new Point(p.x * b, p.time + 1));
			}
			if (p.x + 1 < INF && !visit[p.x + 1]) {
				visit[p.x + 1] = true;
				queue.add(new Point(p.x + 1, p.time + 1));
			}
			if (p.x - 1 >= 0 && !visit[p.x - 1]) {
				visit[p.x - 1] = true;
				queue.add(new Point(p.x - 1, p.time + 1));
			}
			if (p.x - a >= 0 && !visit[p.x - a]) {
				visit[p.x - a] = true;
				queue.add(new Point(p.x - a, p.time + 1));
			}
			if (p.x - b >= 0 && !visit[p.x - b]) {
				visit[p.x - b] = true;
				queue.add(new Point(p.x - b, p.time + 1));
			}

		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
