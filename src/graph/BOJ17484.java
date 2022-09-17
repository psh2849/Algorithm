package graph;

import java.util.*;
import java.io.*;

public class BOJ17484 {

	static class Point {
		int x;
		int y;
		int d;
		int fuel;

		public Point(int x, int y, int d, int fuel) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.fuel = fuel;
		}
	}

	static int n, m;
	static int[][] map;
	static int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int min = Integer.MAX_VALUE;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			pro(0, i);
		}

		System.out.println(min);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, -1, map[x][y]));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
	
			if (p.x == n - 1) {
				min = Math.min(min, p.fuel);
			}

			for (int i = 0; i < 3; i++) {
				if (p.d != i) {
					int dx = p.x + dir[i][0];
					int dy = p.y + dir[i][1];

					if (dx < 0 || dy < 0 || dx >= n || dy >= m)
						continue;

					queue.add(new Point(dx, dy, i, p.fuel + map[dx][dy]));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
