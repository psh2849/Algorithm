package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ15989 {

	static int n, num;
	static int[][] dp;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new int[10001][4];
		dp[1][1] = 1;
		dp[1][2] = 0;
		dp[1][3] = 0;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[2][3] = 0;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		
		for(int i = 4; i <= 10000; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
		}
		
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			
			System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
