package dynamicProgramming;


import java.util.*;
import java.io.*;

public class BOJ15486 {

	static int n;
	static int[][] job;
	static int[] dp;
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		job = new int[n + 2][2];
		dp = new int[n + 2];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			job[i][0] = Integer.parseInt(st.nextToken());
			job[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = -1;
		for(int i = 1; i <= n; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int next = i + job[i][0];
			if(next < n + 2) {
				dp[next] = Math.max(dp[next], max + job[i][1]);
			}
		}
		
		System.out.println(max < dp[n + 1] ? dp[n + 1] : max);
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
