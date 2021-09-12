/*
 * 11052. 카드 구매하기
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ11052 {

	static int N;
	static int[] cost;
	static int[] dp;
	static int max = Integer.MAX_VALUE;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		cost = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}
	}

	static void pro() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + cost[j]);
			}
		}
		
		System.out.println(dp[N]);
	}

	public static void main(String[] args) {
		input();
		pro();
	}
}
