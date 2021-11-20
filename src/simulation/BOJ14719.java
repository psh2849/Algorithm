package simulation;

import java.util.*;
import java.io.*;

public class BOJ14719 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean flag1 = false;
	static boolean flag2 = false;
	static int n, m;
	static int[][] map;
	static int[] num;
	static int answer = 0;
	static int[][] dir = { { 0, -1 }, { 0, 1 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		num = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int v = num[i];

			for (int j = n - 1; j >= n - v; j--) {
				map[j][i] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					flag1 = bfs(i, j, 0);
					flag2 = bfs(i, j ,1);
					
					if(flag1 && flag2) {
						answer++;
					}
				}
			}
		}

		System.out.println(answer);
	}

	static boolean bfs(int x, int y, int d) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int dx = p.x + dir[d][0];
			int dy = p.y + dir[d][1];
			
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) return false;
			if(map[dx][dy] == 1) {
				return true;
			}
			
			queue.add(new Point(dx, dy));
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
