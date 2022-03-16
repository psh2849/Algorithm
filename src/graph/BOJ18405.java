package graph;

import java.util.*;
import java.io.*;

public class BOJ18405 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Point> list = new ArrayList<>();
	static int n, k;
	static boolean[][] visit;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int s, destx, desty;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		destx = Integer.parseInt(st.nextToken()) - 1;
		desty = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < s; i++) {
			for (int j = 0; j < k; j++) {
				pro(j + 1);

				if (map[destx][desty] != 0) {
					System.out.println(map[destx][desty]);
					return;
				}
			}
		}
		
		System.out.println(map[destx][desty]);
	}

	static void pro(int virus) {
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == virus) {
					queue.add(new Point(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n)
					continue;
				
				if(map[dx][dy] == 0) {
					map[dx][dy] = virus;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
