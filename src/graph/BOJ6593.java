package graph;

import java.util.*;
import java.io.*;

public class BOJ6593 {

	static class Point {
		int x;
		int y;
		int h;
		int cnt;

		public Point(int x, int y, int h, int cnt) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.cnt = cnt;
		}
	}

	static int k, r, c;
	static int sx, sy, sh;
	static int[] dx = { -1, 0, 1, 0, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static boolean[][][] visit;
	static char[][][] map;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (k == 0 && r == 0 && c == 0) {
				return;
			}

			map = new char[k][r][c];
			visit = new boolean[k][r][c];

			for (int i = 0; i < k; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int z = 0; z < c; z++) {
						map[i][j][z] = str.charAt(z);
						if (map[i][j][z] == 'S') {
							sh = i;
							sx = j;
							sy = z;
						}
					}
				}
				br.readLine();
			}

			pro();
		}
	}

	static void pro() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(sx, sy, sh, 0));
		visit[sh][sx][sy] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			if(map[p.h][p.x][p.y] == 'E') {
				System.out.println("Escaped in " + p.cnt + " minute(s).");
				return;
			}
			
			for(int i = 0; i < 6; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nh = p.h + dh[i];
				
				if(nx < 0 || ny < 0 || nh < 0 || nx >= r || ny >= c || nh >= k) continue;
				if(map[nh][nx][ny] == '#' || visit[nh][nx][ny]) continue;
				
				visit[nh][nx][ny] = true;
				queue.add(new Point(nx, ny, nh, p.cnt + 1));
			}
		}
		
		System.out.println("Trapped!");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
