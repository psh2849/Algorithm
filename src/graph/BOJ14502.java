package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, cnt;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] copyMap;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copyMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

	}

	static void dfs(int k) {
		if (k == 3) {
			bfs();
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						dfs(k + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
				if (copyMap[i][j] == 2) {
					queue.add(new Point(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
					continue;
				}

				if (copyMap[dx][dy] == 1) {
					continue;
				}

				if (copyMap[dx][dy] == 0) {
					copyMap[dx][dy] = 2;
					queue.add(new Point(dx, dy));
				}
			}
		}
		
		printMaxArea();
	}
	
	static void printMaxArea() {
		for(int i =0; i < N; i++) {
			for(int j =0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(cnt, max);
		cnt = 0;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		
		sb.append(max);
		System.out.println(sb);
	}

}
