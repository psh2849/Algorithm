/*
 * 17404. RGB °Å¸® 2
 */
package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {
	static final int INF = 1000 * 1000;
	static int N;
	static int[][] dp;
	static int[][] cost;
	static int[] minArray;
	static StringBuilder sb = new StringBuilder();
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cost = new int[N + 1][3];
		dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void pro() {
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == i)
					dp[1][j] = cost[1][j];
				else
					dp[1][j] = INF;
			}

			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
			}
			
			
			for (int j = 0; j < 3; j++) {
				if(j == i) continue;
				ans = Math.min(ans, dp[N][j]);
			}
		}
		
		sb.append(ans);
		System.out.println(ans);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
