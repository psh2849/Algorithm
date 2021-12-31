package graph;

import java.util.*;
import java.io.*;

public class BOJ16918 {
	static class Bomb {
		int x;
		int y;
		int time;

		public Bomb(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int n, m, time;
	static char[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static Bomb[][] bomb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		bomb = new Bomb[n][m];

		initBomb();
		for (int i = 2; i <= time; i++) {
			if (i % 2 == 0) {
				installBomb();
			}

			if (i % 2 == 1) {
				explodeBomb();
			}

		}
		show();
	}

	static void show() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void initBomb() throws IOException {
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'O') {
					bomb[i][j] = new Bomb(i, j, 3);
				}
			}
		}
	}

	static void explodeBomb() {
		Queue<Bomb> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'O') {
					if (bomb[i][j].time >= 3) {
						int dx = bomb[i][j].x;
						int dy = bomb[i][j].y;

						for (int d = 0; d < 4; d++) {
							int nx = dx + dir[d][0];
							int ny = dy + dir[d][1];

							if (nx < 0 || ny < 0 || nx >= n || ny >= m)
								continue;
							queue.add(new Bomb(nx, ny, 0));
							queue.add(new Bomb(dx, dy, 0));
						}
					} else {
						bomb[i][j].time++;
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Bomb b = queue.poll();

			int dx = b.x;
			int dy = b.y;

			map[dx][dy] = '.';
			bomb[dx][dy] = new Bomb(dx, dy, 0);
		}
	}

	static void installBomb() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					bomb[i][j] = new Bomb(i, j, 1);
				} else {
					bomb[i][j].time++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
