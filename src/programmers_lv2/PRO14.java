package programmers_lv2;

public class PRO14 {
	static int solution(int n) {
		int answer = 0;
		int[] dp = new int[n + 1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
		}
		
		answer = dp[n];
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(5);
	}

}
