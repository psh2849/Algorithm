package graph;

import java.util.*;
import java.io.*;

public class BOJ1194 {

	static class Point {
		int x;
		int y;
		int cnt;
		int key;
		
		public Point(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	static int n, m, start_x, start_y;
	static ArrayList<Point> dest = new ArrayList<>();
	static char[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					start_x = i;
					start_y = j;
				}
			}
		}

		pro(start_x, start_y);
	}

	static void pro(int x, int y) {
		boolean[][][] visit = new boolean[64][n][m];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y, 0, 0));
		visit[0][x][y] = true;
		
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int row = p.x;
			int col = p.y;
			int count = p.cnt;
			int key = p.key;
			
			if(map[p.x][p.y] == '1') {
				System.out.println(count);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = row + dir[i][0];
				int dy = col + dir[i][1];

				if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
				if(map[dx][dy] == '#' || visit[key][dx][dy]) continue;
				
				if(map[dx][dy] == '.' || map[dx][dy] == '0' || map[dx][dy] == '1') {
					visit[key][dx][dy] = true;
					queue.add(new Point(dx, dy, count + 1, key));
				}
				else if(map[dx][dy] >= 'a' && map[dx][dy] <= 'z') {
					int nKey = 1 << (map[dx][dy] - 'a');
					nKey = nKey | key;
					if(!visit[nKey][dx][dy]) {
						visit[nKey][dx][dy] = true;
						visit[key][dx][dy] = true;
						queue.add(new Point(dx ,dy, count + 1, nKey));
					}
				}
				else if(map[dx][dy] >= 'A' && map[dx][dy] <= 'Z') {
					int door = 1 << (map[dx][dy] - 'A');
					if((key & door) > 0) {
						visit[key][dx][dy] = true;
						queue.add(new Point(dx, dy, count + 1, key));
					}
				}
			}
		}
		
		System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
