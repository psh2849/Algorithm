package simulation;

import java.util.*;
import java.io.*;

public class BOJ2174 {

	static class Robot {
		int x;
		int y;
		int dir;

		public Robot(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static boolean isCrashed = false;
	static int a, b, n, m;
	static int[][] map;
	static Robot[] robot;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[b + 1][a + 1];
		robot = new Robot[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);

			int dir = -1;
			if (d == 'N') {
				dir = 0;
			} else if (d == 'E') {
				dir = 1;
			} else if (d == 'S') {
				dir = 2;
			} else if (d == 'W') {
				dir = 3;
			}

			map[y][x] = i;
			robot[i] = new Robot(x, y, dir);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			char com = st.nextToken().charAt(0);
			int time = Integer.parseInt(st.nextToken());

			move(num, com, time);

			if (isCrashed) {
				break;
			}
		}

		if (!isCrashed) {
			System.out.println("OK");
		}
	}

	static void move(int num, char order, int time) {
		for (int i = 0; i < time; i++) {
			Robot r = robot[num];

			if (order == 'R' || order == 'L') {
				int dir = getDir(r.dir, order);
				robot[num] = new Robot(r.x, r.y, dir);
			} else if (order == 'F') {
				int nx = r.x + dx[r.dir];
				int ny = r.y + dy[r.dir];

				if (nx >= 1 && ny >= 1 && nx <= a && ny <= b) {
					if (map[ny][nx] != 0) {
						System.out.println("Robot " + num + " crashes into robot " + map[ny][nx]);
						isCrashed = true;
						return;
					} else {
						map[ny][nx] = num;
						map[r.y][r.x] = 0;
						robot[num] = new Robot(nx, ny, r.dir);
					}
				} else {
					System.out.println("Robot " + num + " crashes into the wall");
					isCrashed = true;
					return;
				}
			}
		}
	}

	static int getDir(int dir, char order) {
		if (order == 'L') {
			if (dir == 0) {
				dir = 3;
			} else {
				dir--;
			}
		} else if (order == 'R') {
			if (dir == 3) {
				dir = 0;
			} else {
				dir++;
			}
		}

		return dir;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
