package graph;

import java.util.*;
import java.io.*;

public class BOJ3187 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visit;
	static char[][] map;
	static int w, k;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == 'k') {
					k++;
				} else if (str.charAt(j) == 'v') {
					w++;
				}
			}
		}
	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != '#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(k + " " + w);
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		int wolves = 0;
		int sheep = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m) {
					continue;
				}
				if (visit[dx][dy])
					continue;
				if (map[dx][dy] == '#')
					continue;

				visit[dx][dy] = true;
				if (map[dx][dy] == 'v') {
					wolves++;
				} else if (map[dx][dy] == 'k') {
					sheep++;
				}

				queue.add(new Point(dx, dy));
			}
		}
		
		if (wolves >= sheep) {
			k -= sheep;
		} else {
			w -= wolves;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
