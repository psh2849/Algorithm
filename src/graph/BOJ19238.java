package graph;

import java.util.*;
import java.io.*;

public class BOJ19238 {

	static class Taxi implements Comparable<Taxi> {
		int x;
		int y;
		int dist;

		public Taxi(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		public int compareTo(Taxi o) {
			if (this.dist != o.dist) {
				return this.dist - o.dist;
			} else {
				if (this.x != o.x) {
					return this.x - o.x;
				} else {
					return this.y - o.y;
				}
			}
		}
	}

	static class Passenger {
		int startX;
		int startY;
		int destX;
		int destY;

		public Passenger(int startX, int startY, int destX, int destY) {
			this.startX = startX;
			this.startY = startY;
			this.destX = destX;
			this.destY = destY;
		}
	}

	static int tx, ty;
	static int n, m, k;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	static ArrayList<Taxi> t_list = new ArrayList<>();
	static ArrayList<Passenger> p_list = new ArrayList<>();

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new boolean[n + 1][n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		tx = Integer.parseInt(st.nextToken());
		ty = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			p_list.add(new Passenger(a, b, c, d));
			map[a][b] = i;
		}

		pro();
	}

	static void pro() {
		while (true) {
			if (p_list.size() == 0) {
				System.out.println(k);
				return;
			}
			
			t_list.clear();
			visit = new boolean[n + 1][n + 1];

			findShortestPath(tx, ty);
			
			if(t_list.size() == 0) {
				System.out.println(-1);
				return;
			}
			
			Taxi start = t_list.get(0);
			map[start.x][start.y] = 0;
			k -= start.dist;

			if (k < 0) {
				System.out.println(-1);
				return;
			}

			visit = new boolean[n + 1][n + 1];
			int dist = 0;
			for (int i = 0; i < p_list.size(); i++) {
				Passenger p = p_list.get(i);

				if (p.startX == start.x && p.startY == start.y) {
					dist = goDestination(p.startX, p.startY, p.destX, p.destY);

					if (dist == -1) {
						System.out.println(-1);
						return;
					}
					tx = p.destX;
					ty = p.destY;
					p_list.remove(p);
					break;

				}
			}

			k -= dist;

			if (k < 0) {
				System.out.println(-1);
				return;
			}

			k += dist * 2;
		}
	}

	static void findShortestPath(int x, int y) {
		PriorityQueue<Taxi> queue = new PriorityQueue<>();
		queue.add(new Taxi(x, y, 0));

		while (!queue.isEmpty()) {
			Taxi t = queue.poll();

			if (map[t.x][t.y] >= 1) {
				t_list.add(new Taxi(t.x, t.y, t.dist));
				break;
			}

			for (int i = 0; i < 4; i++) {
				int dx = t.x + dir[i][0];
				int dy = t.y + dir[i][1];

				if (dx <= 0 || dy <= 0 || dx > n || dy > n)
					continue;
				if (visit[dx][dy] || map[dx][dy] == -1)
					continue;

				visit[dx][dy] = true;
				queue.add(new Taxi(dx, dy, t.dist + 1));
			}
		}
	}

	static int goDestination(int sx, int sy, int dx, int dy) {
		Queue<Taxi> queue = new LinkedList<>();
		queue.add(new Taxi(sx, sy, 0));

		while (!queue.isEmpty()) {
			Taxi t = queue.poll();

			if (t.x == dx && t.y == dy) {
				return t.dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = t.x + dir[i][0];
				int ny = t.y + dir[i][1];

				if (nx <= 0 || ny <= 0 || nx > n || ny > n)
					continue;
				if (visit[nx][ny] || map[nx][ny] == -1)
					continue;

				visit[nx][ny] = true;
				queue.add(new Taxi(nx, ny, t.dist + 1));
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
