package graph;

import java.util.*;
import java.io.*;

public class BOJ16173 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pro();
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		queue.add(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int point = map[p.x][p.y];

			if (visit[p.x][p.y])
				continue;
			visit[p.x][p.y] = true;
	
			if (point == -1) {
				System.out.println("HaruHaru");
				return;
			}

			if (p.x + point < n) {
				queue.add(new Point(p.x + point, p.y));
			}

			if (p.y + point < n) {
				queue.add(new Point(p.x, p.y + point));
			}
		}

		System.out.println("Hing");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
