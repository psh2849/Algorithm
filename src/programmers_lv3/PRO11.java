/*
 * https://programmers.co.kr/learn/courses/30/lessons/12914
 */
package programmers_lv3;

public class PRO11 {
	
	static int[] dp = new int[2000];
	
	static long solution(int n) {
		long answer = 0;
		dp[0] = 1;
		dp[1] = 2;
		for(int i = 2; i < n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
		}
		answer = dp[n-1];
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
