package graph;

import java.util.*;
import java.io.*;

public class BOJ17070 {

	static class Pipe {
		int x;
		int y;
		int dir;

		public Pipe(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	static int n, count;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (map[n][n] == 1) {
			System.out.println(0);
			return;
		}

		pro(1, 2, 0);
	}

	static void pro(int x, int y, int dir) {
		Queue<Pipe> queue = new LinkedList<>();
		queue.add(new Pipe(x, y, dir));

		while (!queue.isEmpty()) {
			Pipe p = queue.poll();

			if (p.x == n && p.y == n && map[p.x][p.y] != 1) {
				count++;
				continue;
			}

			if (p.dir == 0) {
				if (p.y + 1 <= n && map[p.x][p.y + 1] != 1) {
					queue.add(new Pipe(p.x, p.y + 1, 0));
				}

				if (p.y + 1 <= n && p.x + 1 <= n && map[p.x + 1][p.y + 1] != 1 && map[p.x + 1][p.y] != 1
						&& map[p.x][p.y + 1] != 1) {
					queue.add(new Pipe(p.x + 1, p.y + 1, 2));
				}
			}
			else if (p.dir == 1) {
				if (p.x + 1 <= n && map[p.x + 1][p.y] != 1) {
					queue.add(new Pipe(p.x + 1, p.y, 1));
				}

				if (p.x + 1 <= n && p.y + 1 <= n && map[p.x][p.y + 1] != 1 && map[p.x + 1][p.y] != 1
						&& map[p.x + 1][p.y + 1] != 1) {
					queue.add(new Pipe(p.x + 1, p.y + 1, 2));
				}
			} 
			else if (p.dir == 2) {
				if (p.y + 1 <= n && map[p.x][p.y + 1] != 1) {
					queue.add(new Pipe(p.x, p.y + 1, 0));
				}

				if (p.x + 1 <= n && map[p.x + 1][p.y] != 1) {
					queue.add(new Pipe(p.x + 1, p.y, 1));
				}

				if (p.x + 1 <= n && p.y + 1 <= n && map[p.x + 1][p.y + 1] != 1 && map[p.x + 1][p.y] != 1
						&& map[p.x][p.y + 1] != 1) {
					queue.add(new Pipe(p.x + 1, p.y + 1, 2));
				}
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
