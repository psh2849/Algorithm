package dynamicProgramming;

import java.util.Scanner;

public class BOJ11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		
		if(N == 1) {
			System.out.println(1);
			return;
		} else if(N == 2) {
			System.out.println(3);
			return;
		}
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + (dp[i-2] * 2) % 10007;
		}
		
		System.out.println(dp[N] % 10007);
		
		
	}

}
