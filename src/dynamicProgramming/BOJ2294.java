package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ2294 {
	
	static int n, k;
	static int[] coin;
	static int[] dp;
	
	static void input() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[k + 1];
		for(int i = 1; i <= k; i++) {
			dp[i] = 100001;
		}
		dp[0] = 0;
		
		coin = new int[n + 1];
		for(int i = 1; i <= n; i++) { 
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		
		for(int i = 1; i <= n; i++) {
			for(int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		
		if(dp[k] == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
