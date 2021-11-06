package graph;

import java.util.*;
import java.io.*;

public class BOJ1743 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int max = Integer.MIN_VALUE;
	static int n, m, k;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new boolean[n + 1][m + 1];
		map = new char[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				map[i][j] = '.';
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = '#';
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (map[i][j] == '#' && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(max);
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		int cnt = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				if(dx <= 0 || dy <= 0 || dx >= n + 1 || dy >= m + 1) continue;
				if(visit[dx][dy]) continue;
				if(map[dx][dy] == '.') continue;
				
				visit[dx][dy] = true;
				cnt++;
				queue.add(new Point(dx, dy));
			}
		}

		max = Math.max(max, cnt);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
