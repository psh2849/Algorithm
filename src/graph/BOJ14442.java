package graph;

import java.util.*;
import java.io.*;

public class BOJ14442 {

	static class Point implements Comparable<Point>{
		int x;
		int y;
		int time;
		int cnt;

		public Point(int x, int y, int time, int cnt) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.cnt = cnt;
		}
		
		public int compareTo(Point o) {
			return time - o.time;
		}
	}

	static int n, m, k;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		
		pro(1, 1);
	}

	static void pro(int x, int y) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(x, y, 1, 0));
		visit[1][1][0] = true;

		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == n && p.y == m) {
				min = Math.min(min, p.time);
				System.out.println(min);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx <= 0 || dy <= 0 || dx > n || dy > m)
					continue;

				if (map[dx][dy] == 0 && !visit[dx][dy][p.cnt]) {
					queue.add(new Point(dx, dy, p.time + 1, p.cnt));
					visit[dx][dy][p.cnt] = true;
				}

				else if (p.cnt + 1 <= k && map[dx][dy] == 1 && !visit[dx][dy][p.cnt + 1]) {
					queue.add(new Point(dx, dy, p.time + 1, p.cnt + 1));
					visit[dx][dy][p.cnt + 1] = true;
				}
			}
		}

		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
