package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

	static int N, M;
	static boolean[][] visit;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 0, 0);
				exceptionTetro(i, j);
			}
		}

		
	}

	static void dfs(int x, int y, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(sum, max);
		} else {
			for (int i = 0; i < 4; i++) {
				int dx = x + dir[i][0];
				int dy = y + dir[i][1];

				if (dx < 0 || dy < 0 || dx >= N || dy >= M)
					continue;
				if (visit[dx][dy])
					continue;

				visit[dx][dy] = true;
				dfs(dx, dy, map[dx][dy] + sum, depth + 1);
				visit[dx][dy] = false;
			}
		}
	}

	static void exceptionTetro(int x, int y) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if(wing <= 2) return; 
			
			if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[dx][dy]);
			sum += map[dx][dy];
		}
		
		if(wing == 4) {
			sum -= min;
		}
		max = Math.max(max, sum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		sb.append(max);
		System.out.println(sb);
	}

}
