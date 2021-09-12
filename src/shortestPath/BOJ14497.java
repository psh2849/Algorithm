package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14497 {
	static class Edge {
		int x;
		int y;

		public Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, x1, y1, x2, y2;
	static int save_x, save_y;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static char[][] map, temp;
	static boolean[][] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		temp = new char[N][M];
		map = new char[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt = 0;
		while (true) {
			visit = new boolean[N][M];
			cnt++;
			boolean isPossible = bfs();
			if (isPossible) {
				sb.append(cnt);
				break;
			}
		}
		
		System.out.println(sb);

	}

	static boolean bfs() {
		Queue<Edge> queue = new LinkedList<>();

		queue.add(new Edge(x1 - 1, y1 - 1));
		visit[x1-1][y1-1] = true;
		while (!queue.isEmpty()) {
			Edge edge = queue.poll();
			for (int i = 0; i < 4; i++) {
				int dx = edge.x + dir[i][0];
				int dy = edge.y + dir[i][1];
				
				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (visit[dx][dy])
					continue;
				visit[dx][dy] = true;
				
				if (map[dx][dy] == '#')
					return true;
				if (map[dx][dy] == '1') {
					map[dx][dy] = '0';
					continue;
				}

				queue.add(new Edge(dx, dy));

			}
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
