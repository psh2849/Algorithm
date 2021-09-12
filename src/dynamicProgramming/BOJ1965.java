package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		int max  = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int k = 0; k < i; k++) {
				if (arr[i] > arr[k]) {
					if(dp[i] < dp[k] + 1) {
						dp[i] = dp[k] + 1;
					}
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}

}
