/*
 * 9095번 1,2,3 더하기(dp)(2)
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ9095 {

	static int N, T;
	static long[] dp;
	static Scanner sc = new Scanner(System.in);

	static void input() {
		N = sc.nextInt();
		dp = new long[1000000];
	}

	static void pro() {
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;

		for (int i = 3; i < N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}

		System.out.println(dp[N - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();

		while (T-- > 0) {
			input();
			pro();
		}
	}
}
