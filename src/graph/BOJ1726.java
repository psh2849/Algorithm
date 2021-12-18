package graph;

import java.util.*;
import java.io.*;

public class BOJ1726 {
	static class Point {
		int x;
		int y;
		int dir;
		int cnt;

		public Point(int x, int y, int dir, int cnt) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}

	static int n, m;
	static int sx, sy, sdir, dx, dy, ddir;
	static int[][] map;
	static boolean[][][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n + 1][m + 1][5];
		map = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sdir = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		dx = Integer.parseInt(st.nextToken());
		dy = Integer.parseInt(st.nextToken());
		ddir = Integer.parseInt(st.nextToken());

		pro(sx, sy, sdir);
	}

	static void pro(int x, int y, int d) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, d, 0));
		visit[x][y][d] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int nx = p.x;
			int ny = p.y;
			int ndir = p.dir;
			int ncnt = p.cnt;

			if (nx == dx && ny == dy && ndir == ddir) {
				System.out.println(ncnt);
				return;
			}

			for (int i = 1; i <= 3; i++) {
				int now_x = nx + (dir[ndir - 1][0] * i);
				int now_y = ny + (dir[ndir - 1][1] * i);

				if (now_x <= 0 || now_y <= 0 || now_x > n || now_y > m)
					continue;

				if (map[now_x][now_y] == 0) {
					if (!visit[now_x][now_y][ndir]) {
						visit[now_x][now_y][ndir] = true;
						queue.add(new Point(now_x, now_y, ndir, ncnt + 1));
					}
				} else {
					break;
				}
			}
			
			for(int i = 1; i <= 4; i++) {
				if(ndir != i && !visit[nx][ny][i]) {
					int turn = 1;
					if(ndir == 1) {
						if(i == 2) {
							turn++;
						}
					}
					else if(ndir == 2) {
						if(i == 1) {
							turn++;
						}
					}
					else if(ndir == 3) {
						if(i == 4) {
							turn++;
						}
					}
					else if(ndir == 4) {
						if(i == 3) {
							turn++;
						}
					}
					
					visit[nx][ny][i] = true;
					queue.add(new Point(nx, ny, i, ncnt + turn));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
