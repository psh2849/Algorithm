package dynamicProgramming;

import java.io.*;

public class BOJ1309 {
	
	static int n, answer;
	static int[][] dp;
	static final int MOD = 9901;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][3];
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}
		
		answer = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
		sb.append(answer);
		System.out.println(sb);
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
	}

}
