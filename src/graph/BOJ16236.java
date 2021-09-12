package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int eatingCnt = 0;
	static int N, time, shark_x, shark_y, sharkSize = 2, result = 0;
	static int minX = Integer.MAX_VALUE;
	static int minY = Integer.MAX_VALUE;
	static int minDist = Integer.MAX_VALUE;
	static int[][] map, dist;
	static boolean[][] visit;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Queue<Point> queue = new LinkedList<>();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		visit = new boolean[N][N];
		dist = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark_x = i;
					shark_y = j;
					map[i][j] = 0;
				}
			}
		}

		pro();
	}

	static void pro() {
		while (true) {
			dist = new int[N][N];
			minX = Integer.MAX_VALUE;
			minY = Integer.MAX_VALUE;
			minDist = Integer.MAX_VALUE;

			bfs(shark_x, shark_y);

			if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eatingCnt++;
				map[minX][minY] = 0;
				shark_x = minX;
				shark_y = minY;

				result += dist[minX][minY];

				if (eatingCnt == sharkSize) {
					eatingCnt = 0;
					sharkSize++;
				}
			} else {
				break;
			}
		}

		System.out.println(result);
	}

	static void bfs(int x, int y) {
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= N)
					continue;
				if (map[dx][dy] > sharkSize)
					continue;
				if (dist[dx][dy] != 0)
					continue;

				dist[dx][dy] = dist[p.x][p.y] + 1;
				if (map[dx][dy] != 0 && map[dx][dy] < sharkSize) {
					if (minDist > dist[dx][dy]) {
						minDist = dist[dx][dy];
						minX = dx;
						minY = dy;
					} else if (minDist == dist[dx][dy]) {
						if (minX == dx) {
							if (minY > dy) {
								minY = dy;
								minX = dx;
							}
						} else if (minX > dx) {
							minX = dx;
							minY = dy;
						}
					}
				}

				queue.add(new Point(dx, dy));
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();

	}

}
