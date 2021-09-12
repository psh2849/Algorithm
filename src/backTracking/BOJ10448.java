/*
 * 10448. 유레카 이론
 */
package backTracking;

import java.util.Scanner;

public class BOJ10448 {
	static int K;
	static int num;
	static int dp[];

	static void input() {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		dp = new int[45];

		for (int i = 1; i <= 44; i++) {
			dp[i] = i * (i + 1) / 2;
		}
		while (K-- > 0) {
			num = sc.nextInt();
			pro();
		}

	}

	static void pro() {
		int ans = 0;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				for (int z = 1; z < dp.length; z++) {
					ans = dp[i] + dp[j] + dp[z];
					if (ans == num) {
						System.out.println(1);
						return;
					}
				}
			}
		}

		System.out.println(0);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
	}

}
