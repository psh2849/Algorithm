package graph;

import java.util.*;
import java.io.*;

public class BOJ14923 {

	static class Point {
		int x;
		int y;
		int cnt;
		int broke;

		public Point(int x, int y, int cnt, int broke) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.broke = broke;
		}
	}

	static int n, m, sx, sy, ex, ey;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro();
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[2][n][m];

		queue.add(new Point(sx, sy, 0, 0));
		visit[0][sx][sy] = true;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.x == ex && p.y == ey) {
				System.out.println(p.cnt);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				
				if(visit[p.broke][dx][dy]) continue;
				
				if(map[dx][dy] == 1 && p.broke == 0) {
					visit[p.broke][dx][dy] = true;
					queue.add(new Point(dx, dy, p.cnt + 1, p.broke + 1));
				}
				
				else if(map[dx][dy] == 0) {
					visit[p.broke][dx][dy] = true;
					queue.add(new Point(dx, dy, p.cnt + 1, p.broke));
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
