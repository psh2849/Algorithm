/*
 * 1253. ¡¡¥Ÿ
 */
package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {
	static int N;
	static int A[];
	static StringBuilder sb = new StringBuilder();

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		A = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A, 1, N + 1);

	}

	static boolean func(int target_idx) {
		int L = 1, R = N;
		int target = A[target_idx];

		while (L < R) {
			if (L == target_idx)
				L++;
			else if (R == target_idx)
				R--;
			else {
				if(A[L] + A[R] == target) {
					return true;
				}
				if(A[L] + A[R] > target) {
					R--;
				} else {
					L++;
				}
			}
		}
		
		return false;
	}

	static void pro() {
		int sum = 0;

		for (int left = 1; left <= N; left++) {
			if(func(left)) sum++;
		}

		sb.append(sum);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		input();
		pro();
		System.out.println(sb);
	}

}
