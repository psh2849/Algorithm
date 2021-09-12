package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3197 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> waterQ = new LinkedList<>();
	static boolean[][] visit;
	static char[][] map;
	static Point[] swan;
	static int R, C;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visit = new boolean[R][C];
		map = new char[R][C];
		swan = new Point[2];

		int swan_cnt = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'L') {
					swan[swan_cnt++] = new Point(i, j);
				}
				if (map[i][j] != 'X') {
					waterQ.add(new Point(i, j));
				}
			}
		}

		queue.add(swan[0]);
		visit[swan[0].x][swan[0].y] = true;

		int day = 0;
		while (true) {
			boolean isMeet = bfs();
			if (isMeet) {
				sb.append(day);
				System.out.println(sb);
				break;
			}
			
			dfs();
			day++;
		}
	}
	
	
	static void dfs() {
		int size = waterQ.size();

		for (int i = 0; i < size; i++) {
			Point p = waterQ.poll();

			for (int j = 0; j < 4; j++) {
				int dx = p.x + dir[j][0];
				int dy = p.y + dir[j][1];

				if (dx < 0 || dy < 0 || dx >= R || dy >= C)
					continue;

				if (map[dx][dy] == 'X') {
					map[dx][dy] = '.';
					waterQ.add(new Point(dx, dy));
				}
			}
		}
	}

	static boolean bfs() {
		Queue<Point> nextQ = new LinkedList<>();

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == swan[1].x && p.y == swan[1].y) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= R || dy >= C)
					continue;
				if (visit[dx][dy])
					continue;

				visit[dx][dy] = true;

				if (map[dx][dy] == 'X') {
					nextQ.add(new Point(dx, dy));
				} else {
					queue.add(new Point(dx, dy));
				}
			}
		}
		queue = nextQ;
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}
}
