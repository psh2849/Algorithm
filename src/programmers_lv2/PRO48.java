/*
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 */
package programmers_lv2;

public class PRO48 {
	static int solution(int[][] board) {
		int answer = 0;
		boolean isBool = false;
		int[][] dp = board.clone();

		int max = 0;
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp.length; j++) {
				if(dp[i][j] == 1) {
					isBool = true;
					break;
				}
			}
			if(isBool) {
				break;
			}
		}
		
		if(isBool) {
			max = 1;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (dp[i][j] == 1) {
					int left = dp[i][j - 1];
					int up = dp[i - 1][j];
					int leftUp = dp[i - 1][j - 1];
					int min = Math.min(up, Math.min(left, leftUp));
					dp[i][j] = min + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		answer = max * max;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		solution(board);
	}

}
