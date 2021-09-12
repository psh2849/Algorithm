/*
 * 15991. 1,2,3 ¥ı«œ±‚ 6
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ15991 {
	static int N, T;
	static long dp[];
	static Scanner sc = new Scanner(System.in);

	static void input() {
		N = sc.nextInt();
		System.out.println(dp[N - 1]);
	}

	static void pro() {
		dp = new long[100000];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 3;
		dp[5] = 6;

		for (int i = 6; i < 100000; i++) {
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;
			// System.out.println(dp[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		pro();
		while (T-- > 0) {
			input();
		}
		

	}

}
