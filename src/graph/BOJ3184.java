/*
 * 3184번 양(그래프 격자형 탐색 문제)
 * 
 */
package graph;

import java.util.Scanner;

public class BOJ3184 {

	static int N, M;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] visit;
	static String[] map;
	static int w_cnt = 0, o_cnt = 0;
	static int w_total = 0, o_total = 0;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		visit = new boolean[N][M];
		map = new String[N];

		for (int i = 0; i < N; i++) {
			map[i] = sc.next();
		}

	}

	static void dfs(int x, int y) {

		if (map[x].charAt(y) == 'v')
			w_cnt++;
		if (map[x].charAt(y) == 'o')
			o_cnt++;

		visit[x][y] = true;

		for (int k = 0; k < 4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (map[nx].charAt(ny) == '#')
				continue;
			if (visit[nx][ny])
				continue;

			dfs(nx, ny);
		}
	}

	static void pro() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i].charAt(j) != '#') {
					w_cnt = 0;
					o_cnt = 0;
					dfs(i, j);

					if (w_cnt >= o_cnt) {
						w_total += w_cnt;
					} else {
						o_total += o_cnt;
					}
				}
			}
		}

		System.out.println(o_total + " " + w_total);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
