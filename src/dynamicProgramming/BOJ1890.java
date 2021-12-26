package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ1890 {

	static int n;
	static int[][] map;
	static long[][] dp;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new long[n][n];
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == n - 1 && j == n - 1) continue;
				
				int p = map[i][j];

				if (i + p < n) {
					dp[i + p][j] += dp[i][j];
				}

				if (j + p < n) {
					dp[i][j + p] += dp[i][j];
				}
			}
		}

		System.out.println(dp[n - 1][n - 1]);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
