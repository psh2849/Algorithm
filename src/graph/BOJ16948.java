package graph;

import java.util.*;
import java.io.*;

public class BOJ16948 {
	static class Point {
		int x;
		int y;
		int time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int n;
	static int r1, r2, c1, c2;
	static int[][] map;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };
	static boolean[][] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];
		map = new int[n][n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		pro();
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(r1, c1, 0));
		visit[r1][c1] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == r2 && p.y == c2) {
				System.out.println(p.time);
				return;
			}

			for (int i = 0; i < 6; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;
				if (visit[dx][dy])
					continue;
				queue.add(new Point(dx, dy, p.time + 1));
				visit[dx][dy] = true;
			}
		}

		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
