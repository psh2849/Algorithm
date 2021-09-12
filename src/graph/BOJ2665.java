package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class BOJ2665 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int[][] map;
	static int[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visit = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] str= br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[x][y] = 0;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				
				
				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;

				if (visit[dx][dy] <= visit[p.x][p.y])
					continue;
				
				if (map[dx][dy] == 1) {
					queue.add(new Point(dx, dy));
					visit[dx][dy] = visit[p.x][p.y];
				} else {
					queue.add(new Point(dx, dy));
					visit[dx][dy] = visit[p.x][p.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		bfs(0, 0);
		System.out.println(visit[N-1][N-1]);
	}

}
