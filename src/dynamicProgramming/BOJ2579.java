/*
 * 2579 계단오르기(dp조건)
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ2579 {

	static int N;
	static int[] cost;
	static int[][] dp;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N + 1][2];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}
	}

	static void pro() {
		if(N==1) {
			System.out.println(cost[1]);
			return;
		}
		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[1][1] = cost[1];
		dp[2][0] = cost[2];
		dp[2][1] = cost[1]+cost[2];

		for (int i = 3; i <= N; i++) {
			dp[i][0] = Math.max(dp[i-2][1] + cost[i], dp[i-2][0] + cost[i]);
			dp[i][1] = dp[i-1][0] + cost[i];
		}

		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}
}
