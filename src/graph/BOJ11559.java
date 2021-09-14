package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ11559 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean[][] visit = new boolean[12][6];
	static char[][] map = new char[12][6];
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int cnt = 0, check = 0;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		while (true) {
			visit = new boolean[12][6];

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						checkBlock(i, j);
					}
				}
			}

			int dropCnt = dropBlock();
		
			if (dropCnt == 0) {
				System.out.println(cnt);
				return;
			}
			cnt++;
		}
	}

	static void checkBlock(int x, int y) {
		boolean[][] check = new boolean[12][6];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		check[x][y] = true;
		boolean flag = true;
		int count = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (count >= 3) {
				flag = true;
			} else {
				flag = false;
			}
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dir[i][0];
				int ny = p.y + dir[i][1];

				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) {
					continue;
				}
				if (check[nx][ny]) {
					continue;
				}
				if (map[nx][ny] != map[p.x][p.y]) {
					continue;
				}
				count++;
				check[nx][ny] = true;
				queue.add(new Point(nx, ny));
			}
		}

		if (flag) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (check[i][j]) {
						visit[i][j] = true;
					}
				}
			}
		} 
	}

	static int dropBlock() {
		int count = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 12; j++) {
				if (visit[j][i]) {
					count++;
					for (int z = j; z >= 0; z--) {
						if (z == 0) {
							map[z][i] = '.';
						} else {
							map[z][i] = map[z - 1][i];
						}
					}
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
