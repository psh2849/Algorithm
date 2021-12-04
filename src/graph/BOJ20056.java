package graph;

import java.util.*;
import java.io.*;

public class BOJ20056 {

	static class Ball {
		int x;
		int y;
		int weight;
		int speed;
		int dir;

		public Ball(int x, int y, int weight, int speed, int dir) {
			this.x = x;
			this.y = y;
			this.weight = weight;
			this.speed = speed;
			this.dir = dir;
		}
	}

	static ArrayList<Ball> ballList = new ArrayList<>();
	static ArrayList<Ball>[][] map;
	static int n, m, k;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new ArrayList[n][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			ballList.add(new Ball(x, y, m, s, d));
		}

		for (int i = 0; i < k; i++) {
			moveBall();
			gatherBall();
		}

		int answer = 0;
		for (Ball b : ballList) {
			answer += b.weight;
		}

		System.out.println(answer);
	}

	static void moveBall() {
		for (Ball b : ballList) {
			int r = (b.x + n + dx[b.dir] * (b.speed % n)) % n;
			int c = (b.y + n + dy[b.dir] * (b.speed % n)) % n;

			b.x = r;
			b.y = c;
			map[r][c].add(b);
		}
	}

	static void gatherBall() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j].size() == 1) {
					map[i][j].clear();
				}

				if (map[i][j].size() < 2) {
					continue;
				}

				int w = 0;
				int s = 0;
				int even = 0;
				int odd = 0;

				for (Ball b : map[i][j]) {
					w += b.weight;
					s += b.speed;

					if (b.dir % 2 == 0) {
						even++;
					} else {
						odd++;
					}

					ballList.remove(b);
				}
				int size = map[i][j].size();
				map[i][j].clear();
				
				if (w / 5 == 0)
					continue;

				if (even == size || odd == size) {
					for (int z = 0; z < 8; z += 2) {
						ballList.add(new Ball(i, j, w / 5, s / size, z));
					}
				} else {
					for (int z = 1; z < 8; z += 2) {
						ballList.add(new Ball(i, j, w / 5, s / size, z));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
