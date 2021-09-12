/*
 * 11057 오르막수(dp) (3)
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ11057 {
	static int N;
	static int[][] dp;
	static int ans = 0;
	
	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N + 1][10];

	}

	static void pro() {
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		for (int len = 2; len <= N; len++) {
			for (int num = 0; num <= 9; num++) {
				for(int prev = 0; prev <= num; prev++) {
					dp[len][num] += dp[len-1][prev];
					dp[len][num] = dp[len][num] % 10007;
				}
			}
		}
		
		for(int num = 0 ; num <= 9; num++) {
			ans += dp[N][num];
			ans %= 10007;
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
