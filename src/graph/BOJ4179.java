package graph;

import java.util.*;
import java.io.*;

public class BOJ4179 {

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

	static class Fire {
		int x;
		int y;

		public Fire(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, sx, sy;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static ArrayList<Fire> list = new ArrayList<>();

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
				if (map[i][j] == 'J') {
					map[i][j] = '.';
					sx = i;
					sy = j;
				} else if (map[i][j] == 'F') {
					list.add(new Fire(i, j));
				}
			}
		}

		pro(sx, sy);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0));
		visit[x][y] = true;
		int save = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.time != save) {
				save = p.time;
				moveFire();
			}
			
			if ((p.x == 0 || p.x == n - 1 || p.y == 0 || p.y == m - 1) && map[p.x][p.y] != 'F') {
				System.out.println(p.time + 1);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (visit[dx][dy] || map[dx][dy] == '#' || map[dx][dy] == 'F')
					continue;

				queue.add(new Point(dx, dy, p.time + 1));
				visit[dx][dy] = true;
			}
		}

		System.out.println("IMPOSSIBLE");
	}

	static void moveFire() {
		Queue<Fire> queue = new LinkedList<>();

		for (Fire f : list) {
			queue.add(f);
		}
		list.clear();

		while (!queue.isEmpty()) {
			Fire f = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = f.x + dir[i][0];
				int dy = f.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if(map[dx][dy] == '#' || map[dx][dy] == 'F') continue;
				
				map[dx][dy] = 'F';
				list.add(new Fire(dx, dy));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
