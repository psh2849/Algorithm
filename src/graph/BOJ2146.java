package graph;

import java.util.*;
import java.io.*;

public class BOJ2146 {

	static class Point {
		int x;
		int y;
		int cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int min = Integer.MAX_VALUE;
	static int cnt = 1;
	static int n;
	static boolean[][] visit;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		visit = new boolean[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && map[i][j] != 0) {
					pro(i, j);
					cnt++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					path(i, j, map[i][j]);
				}
			}
		}
		
		System.out.println(min);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0));
		map[x][y] = cnt;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;
				if (visit[dx][dy] || map[dx][dy] == 0)
					continue;

				map[dx][dy] = cnt;
				visit[dx][dy] = true;
				queue.add(new Point(dx, dy, 0));
			}
		}
	}

	static void path(int x, int y, int idx) {
		Queue<Point> queue = new LinkedList<>();
		visit = new boolean[n][n];
		visit[x][y] = true;
		queue.add(new Point(x, y, 0));
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n || visit[dx][dy])
					continue;
				if(map[dx][dy] == idx) continue;
				
				visit[dx][dy] = true;
				if (map[dx][dy] == 0) {
					queue.add(new Point(dx, dy, p.cnt + 1));
				} else {
					min = Math.min(min, p.cnt);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
