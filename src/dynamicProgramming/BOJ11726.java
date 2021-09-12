/*
 * 11726번. 2xn 타일링(dp) (2)
 */
package dynamicProgramming;

import java.util.Scanner;

public class BOJ11726 {

	static int N;
	static int[] dp;

	static void input() {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[1000];

	}

	static void pro() {
		dp[0] = 1;
		dp[1] = 2;

		for (int i = 2; i < N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[N - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
