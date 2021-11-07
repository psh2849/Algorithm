package dynamicProgramming;

import java.util.*;
import java.io.*;

public class BOJ2533 {
	static int n;
	static ArrayList<Integer>[] list;
	static int[][] dp;

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][2];
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		pro(1, -1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static void pro(int k, int parent) {
		dp[k][0] = 0;
		dp[k][1] = 1;
		
		for(int num : list[k]) {
			if(num != parent) {
				pro(num, k);
				dp[k][0] += dp[num][1];
				dp[k][1] += Math.min(dp[num][0], dp[num][1]);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
	}

}
