package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1445 {

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int count;
		int around;

		public Point(int x, int y, int count, int around) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.around = around;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (count > o.count) {
				return 1;
			} else if (count == o.count) {
				return this.around - o.around;
			}
			return -1;
		}
	}

	static int N, M, fx, fy, sx, sy;
	static int resultCnt = Integer.MAX_VALUE;
	static int resultAround = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N][M];
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'F') {
					fx = i;
					fy = j;
				}
				if (map[i][j] == 'S') {
					sx = i;
					sy = j;
				}
			}
		}
		
		dijkstra();
	
		System.out.println(resultCnt + " " + resultAround);
	}

	static void dijkstra() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(sx, sy, 0, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (visit[p.x][p.y])
				continue;
			visit[p.x][p.y] = true;
			for (int i = 0; i < 4; i++) {
				int dx = p.x + dir[i][0];
				int dy = p.y + dir[i][1];
				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (visit[dx][dy])
					continue;
				if (dx == fx && dy == fy) {
					resultCnt = Math.min(resultCnt, p.count);
					resultAround = Math.min(resultAround, p.around);
				}
				if (map[dx][dy] == 'g') {
					queue.add(new Point(dx, dy, p.count + 1, p.around));
				} else {
					boolean flag = true;
					for (int j = 0; j < 4; j++) {
						int nx = dx + dir[j][0];
						int ny = dy + dir[j][1];

						if (nx < 0 || ny < 0 || nx >= N || ny >= M)
							continue;
						if (map[nx][ny] == 'g') {
							queue.add(new Point(dx, dy, p.count, p.around + 1));
							flag = false;
						}
					}
					if(flag) {
						queue.add(new Point(dx, dy, p.count, p.around));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
