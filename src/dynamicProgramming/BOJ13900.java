package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ13900 {

	static int n;
	static int[] arr;

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pro();
	}

	static void pro() {
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[n];
		
		dp[0] = arr[0];
		for(int i = 1; i < n; i++) {
			dp[i] = dp[i - 1] + arr[i];
		}
		
		long answer = 0;
		for(int i = 0; i < n; i++) {
			answer += arr[i] * (dp[n - 1] - dp[i]);
		}
		
		sb.append(answer);
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		input();
	}

}
