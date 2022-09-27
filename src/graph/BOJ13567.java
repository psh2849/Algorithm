package graph;

import java.util.*;
import java.io.*;

public class BOJ13567 {
	static class Point {
		int x;
		int y;
		int d;
		int cnt;
		
		public Point(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

	static int n, m, sx, sy, sd;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		sx = n;
		sy = 0;
		sd = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			String str = st.nextToken();
			int command = Integer.parseInt(st.nextToken());
			
			if(!pro(str, command)) {
				return;
			}
		}
		System.out.println(sy + " " + (n - sx));
	}

	static boolean pro(String str, int command) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sx, sy, sd, 0));
		
		if (str.equals("MOVE")) {
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				if(p.cnt == command) {
					sx = p.x;
					sy = p.y;
					return true;
				}
				
				int dx = p.x + dir[p.d][0];
				int dy = p.y + dir[p.d][1];
				
				if(dx < 0 || dy < 0 || dx > n || dy > n) {
					System.out.println(-1);
					return false;
				}
				
				queue.add(new Point(dx, dy, p.d, p.cnt + 1));
			}
		} else {
			if(command == 0) {
				sd = (sd + 1) % 4;
			} else {
				sd = (sd + 3) % 4;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
