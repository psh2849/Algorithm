package graph;

import java.util.*;
import java.io.*;

public class BOJ5427 {

	static class Fire {
		int x;
		int y;

		public Fire(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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

	static int t;
	static int n, m, sx, sy;
	static ArrayList<Fire> fire = new ArrayList<>();
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			visit = new boolean[n][m];
			map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						sx = i;
						sy = j;
					} else if (map[i][j] == '*') {
						fire.add(new Fire(i, j));
					}
				}
			}

			pro(sx, sy);
			fire.clear();
		}

	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0));
		visit[x][y] = true;

		while (!queue.isEmpty()) {
			fireMove();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			Point p = queue.poll();
			if (p.x == 0 || p.x == n - 1 || p.y == 0 || p.y == m - 1) {
				System.out.println(p.time);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
				if(visit[dx][dy]) continue;
				if(map[dx][dy] == '#' || map[dx][dy] == '*') continue;
				
				visit[dx][dy] = true;
				queue.add(new Point(dx, dy, p.time + 1));
			}
		}
	}

	static void fireMove() {
		boolean[][] v = new boolean[n][m];
		Queue<Fire> queue = new LinkedList<>();
		
		for (Fire f : fire) {
			System.out.println(f.x + " " + f.y);
			queue.add(f);
		}

		while (!queue.isEmpty()) {
			Fire f = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = f.x + dir[i][0];
				int dy = f.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (map[dx][dy] == '#')
					continue;
				if (v[dx][dy])
					continue;

				map[dx][dy] = '*';
				v[dx][dy] = true;
				fire.add(new Fire(dx, dy));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
