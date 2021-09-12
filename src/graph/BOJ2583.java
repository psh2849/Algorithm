package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
	static int N, M, K;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[][] map;
	static boolean[][] visit;
	static int cnt = 0, block = 1;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 0) {
					cnt++;
					pro(i, j);
					list.add(block);
					block = 1;
				}
			}
		}

		Collections.sort(list);

		System.out.println(cnt);

		for (int i = 0; i < cnt; i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	static void pro(int x, int y) {
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= M)
				continue;
			if (visit[dx][dy])
				continue;
			if (map[dx][dy] == 1)
				continue;

			block++;
			pro(dx, dy);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
