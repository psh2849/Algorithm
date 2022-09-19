package backTracking;

import java.util.*;
import java.io.*;

public class BOJ14620 {
	static int n, min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static boolean[][] visit;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		sb.append(min);
		System.out.println(min);
	}

	static void dfs(int count, int sum) {
		if (count == 3) {
			min = Math.min(min, sum);
		} else {
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < n - 1; j++) {
					if (!visit[i][j] && check(i, j)) {
						visit[i][j] = true;
						int result = sum(i, j);
						
						dfs(count + 1, sum + result);
						
						clear(i, j);
						visit[i][j] = false;
					}
				}
			}
		}
	}

	static boolean check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (visit[dx][dy])
				return false;
		}

		return true;
	}

	static int sum(int x, int y) {
		int result = map[x][y];

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			visit[dx][dy] = true;
			result += map[dx][dy];
		}
		
		return result;
	}

	static void clear(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			visit[dx][dy] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
