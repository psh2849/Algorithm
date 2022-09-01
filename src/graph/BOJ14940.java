package graph;

import java.util.*;
import java.io.*;

public class BOJ14940 {

	static class Point {
		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int n, m, destx, desty;
	static boolean[][] check;
	static int[][] map, result;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		result = new int[n][m];
		check = new boolean[n][m];
	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					destx = i;
					desty = j;
					
				}
			}
		}
		
		pro();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0) result[i][j] = 0;
				if(map[i][j] == 1 && !check[i][j]) result[i][j] = -1;
				
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(destx, desty, 0));
		check[destx][desty] = true;
		result[destx][desty] = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			result[p.x][p.y] = p.cnt;
			
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;
				if (map[dx][dy] == 0 || check[dx][dy]) 
					continue;
				
				check[dx][dy] = true;
				queue.add(new Point(dx, dy, p.cnt+1));
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
