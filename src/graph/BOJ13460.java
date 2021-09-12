package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13460 {
	static class Point {
		int rx;
		int ry;
		int bx;
		int by;
		int cnt;

		public Point(int rx, int ry, int bx, int by, int cnt) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int dest_x, dest_y;
	static Point blue, red;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M][N][M];
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'O') {
					dest_x = i;
					dest_y = j;
				} else if (map[i][j] == 'R') {
					red = new Point(i, j, 0, 0, 0);
				} else if (map[i][j] == 'B') {
					blue = new Point(0, 0, i, j, 0);
				}
			}
		}

		bfs();
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(red.rx, red.ry, blue.bx, blue.by, 1));
		visited[red.rx][red.ry][blue.rx][blue.ry] = true;
	
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int curRx = p.rx;
			int curRy = p.ry;
			int curBx = p.bx;
			int curBy = p.by;
			int curCnt = p.cnt;

			if (curCnt > 10) {
				System.out.println(-1);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int dirRx = curRx;
				int dirRy = curRy;
				int dirBx = curBx;
				int dirBy = curBy;

				boolean isRedBool = false;
				boolean isBlueBool = false;
				while (map[dirRx + dx[i]][dirRy + dy[i]] != '#') {
					dirRx += dx[i];
					dirRy += dy[i];

					if (dirRx == dest_x && dirRy == dest_y) {
						isRedBool = true;
						break;
					}
				}

				while (map[dirBx + dx[i]][dirBy + dy[i]] != '#') {
					dirBx += dx[i];
					dirBy += dy[i];

					if (dirBx == dest_x && dirBy == dest_y) {
						isBlueBool = true;
						break;
					}
				}

				if (isBlueBool) {
					continue;
				}

				if (isRedBool && !isBlueBool) {
					System.out.println(curCnt);
					return;
				}

				if (dirRx == dirBx && dirRy == dirBy) {
					if (i == 0) {
						if (curRx > curBx)
							dirRx -= dx[i];
						else
							dirBx -= dx[i];
					} else if (i == 1) {
						if (curRy < curBy)
							dirRy -= dy[i];
						else
							dirBy -= dy[i];
					} else if (i == 2) {
						if (curRx < curBx)
							dirRx -= dx[i];
						else
							dirBx -= dx[i];
					} else if (i == 3) {
						if (curRy < curBy)
							dirBy -= dy[i];
						else
							dirRy -= dy[i];
					}
				}

				if (!visited[dirRx][dirRy][dirBx][dirBy]) {
					queue.add(new Point(dirRx, dirRy, dirBx, dirBy, curCnt + 1));
					visited[dirRx][dirRy][dirBx][dirBy] = true;
				}
			}
		}
		
		System.out.println(-1);
		return;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
