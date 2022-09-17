package implementation;

import java.util.*;
import java.io.*;

public class BOJ10942 {

	static int n, m;
	static int[] arr;
	static boolean[][] dp;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new boolean[n + 1][n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		pro();

		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(dp[start][end]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
	}

	static void pro() {
		for (int i = 1; i <= n; i++) {
			dp[i][i] = true;
		}

		for (int i = 1; i <= n - 1; i++) {
			if (arr[i] == arr[i + 1])
				dp[i][i + 1] = true;
		}
		
		for(int i = 2; i < n; i++) {
			for(int j = 1; j <= n - i; j++) {
				if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
					dp[j][j + i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
