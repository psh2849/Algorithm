package graph;

import java.util.*;
import java.io.*;

public class BOJ17391 {

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

	static int n, m;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 1, 0 } };

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

		pro(0, 0);
	}

	static void pro(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0));
		boolean[][] visit = new boolean[n][m];
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(p.x == n - 1 && p.y == m - 1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i = 0; i < 2; i++) {
				int dx, dy;
				
				for(int j = 1; j <= map[p.x][p.y]; j++) {
					if(i == 0) {
						dx = p.x + dir[i][0];
						dy = p.y + j + dir[i][1] - 1; 
					} else {
						dx = p.x + j + dir[i][0] - 1;
						dy = p.y + dir[i][1];
					}
					
					if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
					if(visit[dx][dy]) continue;
					visit[dx][dy] = true;
					queue.add(new Point(dx, dy, p.cnt + 1));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
