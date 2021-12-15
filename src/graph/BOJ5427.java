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
			
			fire = new ArrayList<>();
			visit = new boolean[n][m];
			map = new char[n][m];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						map[i][j] = '.';
						sx = i;
						sy = j;
					} else if (map[i][j] == '*') {
						fire.add(new Fire(i, j));
					}
				}
			}

			pro(sx, sy);
		}
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 1));
		visit[x][y] = true;
		int save = 1;
		int answer = Integer.MAX_VALUE;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if(save == 1 || save != p.time) {
				save = p.time;
				fireMove();
			}

			if (p.x == 0 || p.x == n - 1 || p.y == 0 || p.y == m - 1) {
				answer = p.time;
				break;
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
		
		if(answer == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(answer);
		}
	}

	static void fireMove() {
		Queue<Fire> queue = new LinkedList<>();
		
		for (Fire f : fire) {
			queue.add(f);
		}
		
		fire.clear();
		
		while (!queue.isEmpty()) {
			Fire f = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = f.x + dir[i][0];
				int dy = f.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (map[dx][dy] == '#' || map[dx][dy] == '*')
					continue;

				map[dx][dy] = '*';
				fire.add(new Fire(dx, dy));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
