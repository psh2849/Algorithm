package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17144 {
	static int N, M, T;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] air;
	static int air_cnt = 0;
	static int sum =2;
	static StringBuilder sb = new StringBuilder();
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		air = new int[N][2];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					air[air_cnt][0] = i;
					air[air_cnt][1] = j;
					air_cnt++;
				}
			}
		}
	}

	static void dfs() {
		int[][] temp = new int[50][50];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == -1) {
					temp[i][j] = -1;
					continue;
				}

				temp[i][j] += map[i][j];

				for (int k = 0; k < 4; k++) {
					int dx = i + dir[k][0];
					int dy = j + dir[k][1];

					if (dx < 0 || dy < 0 || dx >= N || dy >= M)
						continue;

					if (map[dx][dy] == -1)
						continue;

					temp[dx][dy] += map[i][j] / 5;
					temp[i][j] -= map[i][j] / 5;
				}
			}
		}
		map = temp;
	}

	static void aircleaner() {
		int airTop = air[0][0];
		int airBottom = air[1][0];
		
		for (int i = airTop - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
	
		for (int i = 0; i < M - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
	
		for (int i = 0; i < airTop; i++) {
			map[i][M - 1] = map[i + 1][M - 1];
		}

		for (int i = M - 1; i > 1; i--) {
			map[airTop][i] = map[airTop][i - 1];
		}

		map[airTop][1] = 0;
		
		for (int i = airBottom + 1; i < N - 1; i++) {
			map[i][0] = map[i + 1][0];
		}

		for (int i = 0; i < M - 1; i++) {
			map[N - 1][i] = map[N - 1][i + 1];
		}

		for (int i = N - 1; i > airBottom; i--) {
			map[i][M - 1] = map[i - 1][M - 1];
		}

		for (int i = M - 1; i > 1; i--) {
			map[airBottom][i] = map[airBottom][i - 1];
		}

		map[airBottom][1] = 0;
	}
	
	static void sum() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
		}
		
		sb.append(sum);
		System.out.println(sum);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		
		for (int k = 0; k < T; k++) {
			dfs();
			aircleaner();
		}
		
		sum();
	}

}
