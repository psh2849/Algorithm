package graph;

import java.util.*;
import java.io.*;

public class BOJ1937 {
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[][] dp;
	static int[][] arr;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int answer = pro(i, j);
				max = Math.max(max, answer);
			}
		}
	
		System.out.println(max);
	}

	static int pro(int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		dp[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];

			if (dx < 0 || dy < 0 || dx >= N || dy >= N)
				continue;
			if (arr[dx][dy] > arr[x][y]) {
				dp[x][y] = Math.max(dp[x][y], pro(dx, dy) + 1);
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
