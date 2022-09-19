package graph;

import java.util.*;
import java.io.*;

public class BOJ13901 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m, k, startX, startY, endX, endY;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] d = new int[4];

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
		}

		st = new StringTokenizer(br.readLine(), " ");
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		map[startX][startY] = 2;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			d[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		pro();
		
		System.out.println(endX + " " + endY);
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(startX, startY));
		int count = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int direction = d[(count + i) % 4];
				int dx = p.x + dir[direction][0];
				int dy = p.y + dir[direction][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				
				if(map[dx][dy] > 0) continue;
				
				map[dx][dy] = 2;
				queue.add(new Point(dx, dy));
				count = (count + i) % 4;
				endX = dx;
				endY = dy;
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
