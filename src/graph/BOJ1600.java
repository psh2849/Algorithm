package graph;

import java.util.*;
import java.io.*;

public class BOJ1600 {

	static class Point {
		int x;
		int y;
		int move;
		int time;

		public Point(int x, int y, int move, int time) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.time = time;
		}
	}

	static int k, n, m;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] dir2 = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m][k + 1];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro(0, 0);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0, 0));
		int answer = Integer.MAX_VALUE;
		visit[x][y][0] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == n - 1 && p.y == m - 1) {
				answer = p.time;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (map[dx][dy] == 1)
					continue;
				if (visit[dx][dy][p.move])
					continue;

				visit[dx][dy][p.move] = true;
				queue.add(new Point(dx, dy, p.move, p.time + 1));
			}

			for (int i = 0; i < 8; i++) {
				int dx = p.x + dir2[i][0];
				int dy = p.y + dir2[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (map[dx][dy] == 1)
					continue;
				if (p.move >= k)
					continue;
				if (visit[dx][dy][p.move + 1])
					continue;

				visit[dx][dy][p.move + 1] = true;
				queue.add(new Point(dx, dy, p.move + 1, p.time + 1));
			}
		}

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
