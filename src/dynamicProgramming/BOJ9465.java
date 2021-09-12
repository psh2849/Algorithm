package dynamicProgramming;

import java.util.Scanner;

public class BOJ9465 {
	private static int tc, n;
	private static int[][] arr;
	private static int[][] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		tc = sc.nextInt();

		while (tc-- > 0) {
			n = sc.nextInt();
			arr = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}

