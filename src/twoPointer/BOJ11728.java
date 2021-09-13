package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {
	static int[] A;
	static int[] B;
	static int[] ans;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		B = new int[M];
		ans = new int[N + M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		pro();
		

		System.out.println(sb);
		
	}

	static void pro() {
		int left = 0;
		int right = 0;
		while(left < N && right < M) {
			if(A[left] < B[right]) {
				sb.append(A[left++] + " ");
			} else {
				sb.append(B[right++] + " ");
			}
		}
		
		while(left < N) {
			sb.append(A[left++] + " ");
		} 
		
		while(right < M) {
			sb.append(B[right++] + " ");
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
	}

}
