package graph;

import java.util.*;
import java.io.*;

public class BOJ2234 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean[][] visit;
	static int[][] map;
	static int n, m;
	static int[] dx = { 0, -1, 0, 1 }; // ºÏ, ¼­, ³², µ¿
	static int[] dy = { -1, 0, 1, 0 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		visit = new boolean[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int room = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					max = Math.max(max, pro(i, j));
					room++;
				}
			}
		}

		System.out.println(room);
		System.out.println(max);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int bit = 1; bit <= 8; bit <<= 1) {
					if ((map[i][j] & bit) != 0) {
						visit = new boolean[n][m];
						map[i][j] -= bit;
						max = Math.max(max, pro(i, j));
						map[i][j] += bit;
					}
				}
			}
		}

		System.out.println(max);
	}

	static int pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int bit = 1;

			for (int i = 0; i < 4; i++) {
				if ((map[p.x][p.y] & bit) == 0) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
				
					if (ny >= 0 && nx >= 0 && nx < n && ny < m && !visit[nx][ny]) {
						visit[nx][ny] = true;
						count++;
						queue.add(new Point(nx, ny));
					}
				}
				bit <<= 1;
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
