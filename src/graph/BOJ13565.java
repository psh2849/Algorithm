package graph;

import java.util.*;
import java.io.*;

public class BOJ13565 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine() , " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < m; i++) {
			if(visit[0][i] || map[0][i] == 1) continue;
			
			if(pro(0, i)) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	
	static boolean pro(int x, int y) { 
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x == n - 1) {
				return true;
			}
			
			for(int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				if(dx < 0 || dy < 0 || dx>= n || dy >= m) continue;
				if(visit[dx][dy]) continue;
				if(map[dx][dy] == 1) continue;
				
				visit[dx][dy] = true;
				queue.add(new Point(dx, dy));
			}
		}
		
		return false;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
