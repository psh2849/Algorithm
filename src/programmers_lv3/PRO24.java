/*
 * https://programmers.co.kr/learn/courses/30/lessons/1832
 */
package programmers_lv3;

public class PRO24 {
	static int MOD = 20170805;
	static int answer = 0;
	static int[][][] dp;

	static int solution(int m, int n, int[][] cityMap) {
		dp = new int[m][n][2];
		if (cityMap[0][0] == 1)
			return 0;
		dp[0][0][0] = dp[0][0][1] = 1;

		for (int i = 1; i < m; i++) {
			if (cityMap[i][0] != 1) {
				dp[i][0][0] = dp[i - 1][0][0];
			}
		}

		for (int i = 1; i < n; i++) {
			if (cityMap[0][i] != 1) {
				dp[0][i][1] = dp[0][i - 1][1];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (cityMap[i - 1][j] != 1) {
					if (cityMap[i - 1][j] == 2)
						dp[i][j][0] = dp[i - 1][j][0];
					else
						dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
				}
				if (cityMap[i][j - 1] != 1) {
					if (cityMap[i][j - 1] == 2)
						dp[i][j][1] = dp[i][j - 1][1];
					else
						dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
				}
			}
		}

		System.out.println((dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD);
		return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cityMap = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		solution(3, 6, cityMap);
	}

}