package graph;

import java.util.*;
import java.io.*;

public class BOJ1303 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int white = 0;
		int blue = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j])
					continue;
				
				if(map[i][j] == 'W') {
					int num = pro(i, j, map[i][j]);
					white += Math.pow(num, 2);
				} else {
					int num = pro(i, j, map[i][j]);
					blue += Math.pow(num, 2);
				}
			}
		}
		
		System.out.println(white + " " + blue);
	}

	static int pro(int x, int y, int ch) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;
		int count = 1;
		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (visit[dx][dy] || map[dx][dy] != ch)
					continue;

				visit[dx][dy] = true;
				queue.add(new Point(dx, dy));
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
