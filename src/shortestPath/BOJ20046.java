package shortestPath;

import java.util.*;
import java.io.*;

public class BOJ20046 {

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public int compareTo(Point o) {
			return this.cost - o.cost;
		}

	}

	static int n, m;
	static int[][] map;
	static int[][] value;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		value = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(value[i], Integer.MAX_VALUE);
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}

		if (map[0][0] == -1) {
			System.out.println(-1);
		} else {
			pro();
			if(value[n-1][m-1] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(value[n-1][m-1]);
			}
		}

	}

	static void pro() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		value[0][0] = map[0][0];
		queue.add(new Point(0, 0, map[0][0]));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				
				if(map[dx][dy] == -1) continue;
				
				int newCost = p.cost + map[dx][dy];
				if(value[dx][dy] > newCost) {
					value[dx][dy] = newCost;
					queue.add(new Point(dx, dy, newCost));
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
