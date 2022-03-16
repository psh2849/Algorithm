package graph;

import java.io.*;
import java.util.*;

public class BOJ17086 {

	static class Point {
		int x;
		int y;
		int count;
		
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static int[][] dir = { { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int n, m;
	static int max = -1;
	static int[][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					pro(i, j);
				}
			}
		}
		
		System.out.println(max);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		queue.add(new Point(x, y, 0));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(map[p.x][p.y] == 1) {
				max = Math.max(max, p.count);
				return;
			}
			
			for(int i = 0; i < 8; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
				if(visit[dx][dy]) continue;
				
				visit[dx][dy] = true;
				queue.add(new Point(dx, dy, p.count + 1));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
